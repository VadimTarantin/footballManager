package com.football.manager.service.processing.impl;

import com.football.manager.dao.PredictionDao;
import com.football.manager.dao.TaskDao;
import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.entity.Prediction;
import com.football.manager.entity.TableTeam;
import com.football.manager.entity.Task;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;

@Service
public class ProcessingManager implements Runnable {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    @Autowired
    private TaskDao taskDao;
    private ArrayBlockingQueue<Task> tasks = new ArrayBlockingQueue<>(1500);
    @Value("${amount.tasks.managers}")
    private int amountTasksManagers;

    private ArrayBlockingQueue<String> wideAndFormResponse = new ArrayBlockingQueue<>(1000);
    private ArrayBlockingQueue<String> overUnderResponse = new ArrayBlockingQueue<>(500);
    @Value("${amount.crawlers.managers}")
    private int amountCrawlerManagers;

    private ArrayBlockingQueue<TableTeam> wideAndFormTableTeams = new ArrayBlockingQueue<>(1000);
    private ArrayBlockingQueue<OverUnderTableTeam> overUnderTableTeams = new ArrayBlockingQueue<>(500);
    @Value("${amount.parsers.managers}")
    private int amountParsersManagers;

    private ArrayBlockingQueue<Prediction> predictions = new ArrayBlockingQueue<>(1500);
    @Value("${amount.predictions.managers}")
    private int amountPredictionsManagers;

    @Autowired
    private PredictionDao predictionDao;
    @Value("${amount.prediction.savers.managers}")
    private int amountPredictionSaversManagers;

    @Autowired
    @Qualifier("getTasksFromDatabaseTaskExecutor")
    private Executor getTasksFromDatabaseTaskExecutor;

    @Autowired
    @Qualifier("crawlerTaskExecutor")
    private Executor crawlerTaskExecutor;

    @Autowired
    @Qualifier("parsersTaskExecutor")
    private Executor parsersTaskExecutor;

    @Autowired
    @Qualifier("calculatePredictionsTaskExecutor")
    private Executor calculatePredictionsTaskExecutor;

    @Autowired
    @Qualifier("saverPredictionsInDatabaseTaskExecutor")
    private Executor saverPredictionsInDatabaseTaskExecutor;

    @Override
    public void run() {
        log.info("Procession manager starts. Will started managers...");
        for (int i = 0; i < amountTasksManagers; i++) {
            getTasksFromDatabaseTaskExecutor.execute(new TaskManager(taskDao, tasks));
        }

        log.info("{} TaskManagers started", amountTasksManagers);
        for (int i = 0; i < amountCrawlerManagers; i++) {
            crawlerTaskExecutor.execute(new CrawlerManager(tasks, wideAndFormResponse, overUnderResponse));
        }
        log.info("{} CrawlerManagers started", amountCrawlerManagers);

        for (int i = 0; i < amountParsersManagers; i++) {
            parsersTaskExecutor.execute(new ParserManager(wideAndFormResponse, overUnderResponse, wideAndFormTableTeams, overUnderTableTeams));
        }
        log.info("{} ParserManager started", amountParsersManagers);

        for (int i = 0; i < amountPredictionsManagers; i++) {
            calculatePredictionsTaskExecutor.execute(new PredictionManager(wideAndFormTableTeams, overUnderTableTeams, predictions));
        }
        log.info("{} PredictionManager started", amountPredictionsManagers);

        for (int i = 0; i < amountPredictionSaversManagers; i++) {
            saverPredictionsInDatabaseTaskExecutor.execute( new PredictionSaver(predictions, predictionDao));
        }
        log.info("{} PredictionSaver started", amountPredictionSaversManagers);
        log.info("Processing prediction has ben started successful");
    }

    public void setAmountTasksManagers(int amountTasksManagers) {
        this.amountTasksManagers = amountTasksManagers;
    }

    public void setAmountCrawlerManagers(int amountCrawlerManagers) {
        this.amountCrawlerManagers = amountCrawlerManagers;
    }

    public void setAmountParsersManagers(int amountParsersManagers) {
        this.amountParsersManagers = amountParsersManagers;
    }

    public void setAmountPredictionsManagers(int amountPredictionsManagers) {
        this.amountPredictionsManagers = amountPredictionsManagers;
    }

    public void setAmountPredictionSaversManagers(int amountPredictionSaversManagers) {
        this.amountPredictionSaversManagers = amountPredictionSaversManagers;
    }

}
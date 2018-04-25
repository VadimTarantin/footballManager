package com.football.manager.service.processing.impl;

import com.football.manager.dao.PredictionDao;
import com.football.manager.dao.TaskDao;
import com.football.manager.dto.input.BusinessTaskDto;
import com.football.manager.dto.input.CrawledTablesDto;
import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.Prediction;
import com.football.manager.entity.Task;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;

@Service
public class ProcessingManager {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    @Autowired
    private TaskDao taskDao;
    private ArrayBlockingQueue<Task> tasks = new ArrayBlockingQueue<>(1500);
    @Value("${amount.tasks.getting.managers}")
    private int amountTasksGettingManagers;
    private ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos = new ArrayBlockingQueue<>(500);

    @Value("${amount.tasks.processing.managers}")
    private int amountTasksProcessingManagers;
    private ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos = new ArrayBlockingQueue<>(500);
    @Value("${amount.crawlers.managers}")
    private int amountCrawlerManagers;

    private ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos = new ArrayBlockingQueue<>(500);
    @Value("${amount.parsers.managers}")
    private int amountParsersManagers;

    private ArrayBlockingQueue<Prediction> predictions = new ArrayBlockingQueue<>(1500);
    @Value("${amount.predictions.managers}")
    private int amountPredictionsManagers;

    @Value("${amount.prediction.calculate.managers}")
    private int amountCalculatePredictionManagers;

    @Value("${amount.prediction.saver.in.database.managers}")
    private int amountPredictionSaverInDatabaseManagers;

    @Autowired
    private PredictionDao predictionDao;

    @Autowired
    @Qualifier("predictionsCalculationTaskExecutor")
    private Executor predictionsCalculationTaskExecutor;

    public void startPredictionsCalculating() {
        log.info("Procession manager starts. Will start managers...");
        for (int i = 0; i < amountTasksGettingManagers; i++) {
            predictionsCalculationTaskExecutor.execute(new TaskGettingManager(taskDao, tasks));
        }
        log.info("{} TaskGettingManagers started", amountTasksGettingManagers);

        for (int i = 0; i < amountTasksProcessingManagers; i++) {
            predictionsCalculationTaskExecutor.execute(new TaskProcessingManager(tasks, businessTaskDtos));
        }
        log.info("{} TaskProcessingManagers started", amountTasksProcessingManagers);

        for (int i = 0; i < amountCrawlerManagers; i++) {
            predictionsCalculationTaskExecutor.execute(new CrawlerManager(businessTaskDtos, crawledTablesDtos));
        }
        log.info("{} CrawlerManagers started", amountCrawlerManagers);

        for (int i = 0; i < amountParsersManagers; i++) {
            predictionsCalculationTaskExecutor.execute(new ParserManager(crawledTablesDtos, parsedTablesDtos));
        }
        log.info("{} ParserManager started", amountParsersManagers);

        for (int i = 0; i < amountPredictionsManagers; i++) {
            predictionsCalculationTaskExecutor.execute(new PredictionManager(parsedTablesDtos, predictions));
        }
        log.info("{} PredictionManager started", amountPredictionsManagers);

        for (int i = 0; i < amountCalculatePredictionManagers; i++) {
            predictionsCalculationTaskExecutor.execute( new PredictionSaver(predictions, predictionDao));
        }
        log.info("{} PredictionSaver started", amountCalculatePredictionManagers);
        log.info("Processing prediction has been started successful");
    }

    public void setAmountTasksGettingManagers(int amountTasksGettingManagers) {
        this.amountTasksGettingManagers = amountTasksGettingManagers;
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

    public void setAmountCalculatePredictionManagers(int amountCalculatePredictionManagers) {
        this.amountCalculatePredictionManagers = amountCalculatePredictionManagers;
    }

    public void setAmountTasksProcessingManagers(int amountTasksProcessingManagers) {
        this.amountTasksProcessingManagers = amountTasksProcessingManagers;
    }

}
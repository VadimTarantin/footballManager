package com.football.manager.service.processing.impl;

import com.football.manager.dao.PredictionDao;
import com.football.manager.entity.Prediction;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;

public class PredictionSaver extends BaseProcessor {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    private ArrayBlockingQueue<Prediction> predictions;
    private PredictionDao predictionDao;

    public PredictionSaver(ArrayBlockingQueue<Prediction> predictions, PredictionDao predictionDao) {
        this.predictions = predictions;
        this.predictionDao = predictionDao;
    }

    @Override
    protected void doWork() throws InterruptedException {
        //predictions -> database
    }

    @Override
    protected void logInfo(String message, Object p0) {
        log.info(message, p0);
    }

    @Override
    protected void logInfo(String message) {
        log.info(message);
    }

}
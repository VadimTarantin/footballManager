package com.football.manager.service.processing.impl;

import com.football.manager.entity.Prediction;
import com.football.manager.service.domain.PredictionService;
import com.football.manager.service.domain.exception.PredictionServiceException;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PredictionSaver extends BaseProcessor {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    private ArrayBlockingQueue<Set<Prediction>> predictions;
    private PredictionService predictionService;

    public PredictionSaver(ArrayBlockingQueue<Set<Prediction>> predictions, PredictionService predictionService) {
        this.predictions = predictions;
        this.predictionService = predictionService;
    }

    @Override
    protected void doWork() throws InterruptedException {
        Set<Prediction> predictions = this.predictions.poll(TIMEOUT, TimeUnit.MILLISECONDS);
        if (predictions == null) {
            String message = String.format("Queue was empty during waiting time=%s so work will be stopped", TIMEOUT);
            log.info(message);
            throw new InterruptedException(message);
        }
        try {
            predictionService.insertOrUpdate(predictions);
            log.info("Set of predictions with size={} was stored successful", predictions.size());
        } catch (PredictionServiceException e) {
            log.warn("Unexpected exception during storing predictions with size={}", predictions.size(), e);
        }
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
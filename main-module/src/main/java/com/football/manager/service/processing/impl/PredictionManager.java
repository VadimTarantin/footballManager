package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.Prediction;
import com.football.manager.service.prediction.impl.Predictor;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PredictionManager extends BaseProcessor {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    private ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos;
    private ArrayBlockingQueue<Set<Prediction>> predictions;
    private Predictor predictor;

    public PredictionManager(ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos,
                             ArrayBlockingQueue<Set<Prediction>> predictions,
                             Predictor predictor) {
        this.parsedTablesDtos = parsedTablesDtos;
        this.predictions = predictions;
        this.predictor = predictor;
    }

    @Override
    protected void doWork() throws InterruptedException {
        ParsedTablesDto parsedTablesDto = parsedTablesDtos.poll(TIMEOUT, TimeUnit.MILLISECONDS);
        if (parsedTablesDto == null) {
            String message = String.format("Queue was empty during waiting time=%s so work will be stopped", TIMEOUT);
            log.info(message);
            throw new InterruptedException(message);
        }
        Set<Prediction> preds = predictor.calculate(parsedTablesDto);
        boolean offerIsSuccess = predictions.offer(preds, TIMEOUT, TimeUnit.MILLISECONDS);
        if (offerIsSuccess) {
            log.info("Set of predictions with size={} for eventID={} was created successful", preds.size(), parsedTablesDto.getEventId());
        } else {
            log.warn("Set of predictions with size={} for eventID={} cannot put in queue to processing because queue is full",
                    preds.size(), parsedTablesDto.getEventId());
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
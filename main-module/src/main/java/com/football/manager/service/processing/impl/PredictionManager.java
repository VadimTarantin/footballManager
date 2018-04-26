package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.Prediction;
import com.football.manager.service.prediction.impl.Predictor;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PredictionManager extends BaseProcessor {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    private ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos;
    private ArrayBlockingQueue<List<Prediction>> predictions;
    private Predictor predictor;

    public PredictionManager(ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos,
                             ArrayBlockingQueue<List<Prediction>> predictions,
                             Predictor predictor) {
        this.parsedTablesDtos = parsedTablesDtos;
        this.predictions = predictions;
        this.predictor = predictor;
    }

    @Override
    protected void doWork() throws InterruptedException {
        ParsedTablesDto parsedTablesDto = parsedTablesDtos.poll(TIMEOUT, TimeUnit.MILLISECONDS);
        List<Prediction> preds = predictor.calculate(parsedTablesDto);
        predictions.offer(preds, TIMEOUT, TimeUnit.MILLISECONDS);

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
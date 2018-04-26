package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.Prediction;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;

public class PredictionManager extends BaseProcessor {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    private ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos;
    private ArrayBlockingQueue<Prediction> predictions;

    public PredictionManager(ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos, ArrayBlockingQueue<Prediction> predictions) {
        this.parsedTablesDtos = parsedTablesDtos;
        this.predictions = predictions;
    }

    @Override
    protected void doWork() throws InterruptedException {
        //ParsedTablesDto -> predictions
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
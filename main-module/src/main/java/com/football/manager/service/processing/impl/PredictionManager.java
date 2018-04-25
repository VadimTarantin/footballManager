package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.Prediction;

import java.util.concurrent.ArrayBlockingQueue;

public class PredictionManager implements Runnable {

    private ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos;
    private ArrayBlockingQueue<Prediction> predictions;

    public PredictionManager(ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos, ArrayBlockingQueue<Prediction> predictions) {
        this.parsedTablesDtos = parsedTablesDtos;
        this.predictions = predictions;
    }

    @Override
    public void run() {
        //ParsedTablesDto -> predictions
    }

}
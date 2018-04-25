package com.football.manager.service.processing.impl;

import com.football.manager.dao.PredictionDao;
import com.football.manager.entity.Prediction;

import java.util.concurrent.ArrayBlockingQueue;

public class PredictionSaver implements Runnable {

    private ArrayBlockingQueue<Prediction> predictions;
    private PredictionDao predictionDao;

    public PredictionSaver(ArrayBlockingQueue<Prediction> predictions, PredictionDao predictionDao) {
        this.predictions = predictions;
        this.predictionDao = predictionDao;
    }

    @Override
    public void run() {
        //predictions -> database
    }

}
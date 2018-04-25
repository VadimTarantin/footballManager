package com.football.manager.service.processing.impl;

import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.entity.Prediction;
import com.football.manager.entity.TableTeam;

import java.util.concurrent.ArrayBlockingQueue;

public class PredictionManager implements Runnable {

    private ArrayBlockingQueue<TableTeam> wideAndFormTableTeams;
    private ArrayBlockingQueue<OverUnderTableTeam> overUnderTableTeams;

    private ArrayBlockingQueue<Prediction> predictions;

    public PredictionManager(ArrayBlockingQueue<TableTeam> wideAndFormTableTeams,
                             ArrayBlockingQueue<OverUnderTableTeam> overUnderTableTeams,
                             ArrayBlockingQueue<Prediction> predictions) {
        this.wideAndFormTableTeams = wideAndFormTableTeams;
        this.overUnderTableTeams = overUnderTableTeams;
        this.predictions = predictions;
    }

    @Override
    public void run() {
        //wideAndFormTableTeams and overUnderTableTeams -> predictions
    }

}
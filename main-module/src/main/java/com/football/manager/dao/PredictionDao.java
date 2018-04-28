package com.football.manager.dao;

import com.football.manager.entity.Prediction;

public interface PredictionDao {
    void add(Prediction prediction);
    void update(Prediction prediction);
    boolean exists(Prediction prediction);
}
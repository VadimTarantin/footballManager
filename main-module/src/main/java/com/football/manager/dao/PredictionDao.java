package com.football.manager.dao;

import com.football.manager.entity.Prediction;

import java.util.List;

public interface PredictionDao {
    void add(Prediction prediction);
    void update(Prediction prediction);
    boolean exists(Prediction prediction);
    List<Prediction> getAll();
}
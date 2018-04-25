package com.football.manager.dao;

import com.football.manager.entity.Prediction;

import java.util.Collection;
import java.util.List;

public interface PredictionDao {
    void add(Collection<Prediction> predictions);
    void update(Collection<Prediction> predictions);
    List<Prediction> getAll();
}
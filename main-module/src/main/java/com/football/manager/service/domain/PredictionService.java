package com.football.manager.service.domain;

import com.football.manager.entity.Prediction;

import java.util.List;
import java.util.Set;

public interface PredictionService {
    void insertOrUpdate(Set<Prediction> predictions);
    List<Prediction> getAll();
}
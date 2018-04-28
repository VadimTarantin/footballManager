package com.football.manager.service.domain;

import com.football.manager.entity.Prediction;

import java.util.Set;

public interface PredictionService {
    void insertOrUpdate(Set<Prediction> predictions);
}
package com.football.manager.service.domain.impl;

import com.football.manager.dao.PredictionDao;
import com.football.manager.entity.Prediction;
import com.football.manager.service.domain.PredictionService;
import com.football.manager.service.domain.exception.PredictionServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class PredictionServiceImpl implements PredictionService {

    @Autowired
    private PredictionDao predictionDao;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void insertOrUpdate(Set<Prediction> predictions) {
        try {
            for (Prediction prediction : predictions) {
                if (predictionDao.exists(prediction)) {
                    predictionDao.update(prediction);
                } else {
                    predictionDao.add(prediction);
                }
            }
        } catch (Exception e) {
            throw new PredictionServiceException("Unexpected exception during insert or update predictions", e);
        }

    }

}
package com.football.manager.service.domain.impl;

import com.football.manager.dao.PredictionDao;
import com.football.manager.entity.Prediction;
import com.football.manager.service.domain.PredictionService;
import com.football.manager.service.domain.exception.PredictionServiceException;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class PredictionServiceImpl implements PredictionService {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    @Autowired
    private PredictionDao predictionDao;

    public void setPredictionDao(PredictionDao predictionDao) {
        this.predictionDao = predictionDao;
    }

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

    @Override
    @Transactional(readOnly = true)
    public List<Prediction> getAll() {
        try {
            return predictionDao.getAll();
        } catch (Exception e) {
            throw new PredictionServiceException("Error during getting all predictions", e);
        }
    }
}
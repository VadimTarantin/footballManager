package com.football.manager.service.prediction.impl;

import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.Prediction;
import com.football.manager.service.prediction.Predicable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Predictor implements Predicable {

    @Override
    public List<Prediction> calculate(ParsedTablesDto parsedTablesDto) {


        return null;
    }

}
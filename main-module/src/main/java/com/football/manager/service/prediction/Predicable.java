package com.football.manager.service.prediction;

import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.Prediction;

import java.util.List;

public interface Predicable {
    List<Prediction> calculate(ParsedTablesDto parsedTablesDto);
}
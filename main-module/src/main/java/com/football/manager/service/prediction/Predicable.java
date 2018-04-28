package com.football.manager.service.prediction;

import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.Prediction;

import java.util.Set;

public interface Predicable {
    Set<Prediction> calculate(ParsedTablesDto parsedTablesDto);
}
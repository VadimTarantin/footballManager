package com.football.manager.com.football.manager.service.prediction.impl;

import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.entity.Prediction;
import com.football.manager.entity.TableTeam;
import com.football.manager.service.parser.BaseTableTeamParserTest;
import com.football.manager.service.parser.OverUnderParser;
import com.football.manager.service.parser.Parser;
import com.football.manager.service.prediction.impl.Predictor;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PredictorTest extends BaseTableTeamParserTest {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    @Autowired
    private Predictor predictor;

    @Value("${predictor.test.wide}")
    private String wideTableFileName;
    @Value("${predictor.test.form}")
    private String formTableFileName;
    @Value("${predictor.test.over.under}")
    private String overUnderFileName;

    @Autowired
    @Qualifier(value = "wideTableTeamParser")
    private Parser wideTableParser;

    @Autowired
    @Qualifier(value = "formTableTeamParser")
    private Parser formTableParser;

    @Autowired
    @Qualifier(value = "overUnderTableTeamParser")
    private OverUnderParser overUnderTableParser;

    @Test
    public void testPredictor() throws Exception {
        List<? extends TableTeam> wideTableTeams = wideTableParser.parse(getResponse(wideTableFileName));
        List<? extends TableTeam> formTableTeams = formTableParser.parse(getResponse(formTableFileName));
        List<? extends OverUnderTableTeam> overUnderTableTeams = overUnderTableParser.parse(getResponse(overUnderFileName));

        ParsedTablesDto parsedTablesDto = new ParsedTablesDto(wideTableTeams, formTableTeams, overUnderTableTeams, 1);

        List<Prediction> predictions = predictor.calculate(parsedTablesDto);

        log.info("predictions.size()={}", predictions.size());
        assertEquals(2, predictions.size());
    }

}
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
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

    @Value("${wide.table.team.parser.test.file.name}")
    private String wideTableFileNameTwentyFourTeam;
    @Value("${form.table.team.parser.test.file.name}")
    private String formTableFileNameTwentyFourTeam;
    @Value("${over.under.table.team.parser.test.file.name}")
    private String overUnderFileNameTwentyFourTeam;

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
    public void testPredictorWhenTwoTeamsShouldBeTwoPredictions() throws Exception {
        List<? extends TableTeam> wideTableTeams = wideTableParser.parse(getResponse(wideTableFileName));
        List<? extends TableTeam> formTableTeams = formTableParser.parse(getResponse(formTableFileName));
        List<? extends OverUnderTableTeam> overUnderTableTeams = overUnderTableParser.parse(getResponse(overUnderFileName));

        ParsedTablesDto parsedTablesDto = new ParsedTablesDto(wideTableTeams, formTableTeams, overUnderTableTeams, 1);

        Set<Prediction> predictions = predictor.calculate(parsedTablesDto);

        log.info("predictions.size()={}", predictions.size());
        assertEquals(2, predictions.size());
    }

    @Ignore
    @Test
    public void testPredictorWhenTwentyFourTeamsShouldBeFiveHundredFiftyPredictions() throws Exception {
        List<? extends TableTeam> wideTableTeams = wideTableParser.parse(getResponse(wideTableFileNameTwentyFourTeam));
        List<? extends TableTeam> formTableTeams = formTableParser.parse(getResponse(formTableFileNameTwentyFourTeam));
        List<? extends OverUnderTableTeam> overUnderTableTeams = overUnderTableParser.parse(getResponse(overUnderFileNameTwentyFourTeam));

        ParsedTablesDto parsedTablesDto = new ParsedTablesDto(wideTableTeams, formTableTeams, overUnderTableTeams, 1);

        Set<Prediction> predictions = predictor.calculate(parsedTablesDto);

        log.info("predictions.size()={}", predictions.size());
        //double C2 24 minus 2
        assertEquals(552, predictions.size());
    }

    @Test
    public void testPredictorPredictionValues() throws Exception {
        List<? extends TableTeam> wideTableTeams = wideTableParser.parse(getResponse(wideTableFileName));
        List<? extends TableTeam> formTableTeams = formTableParser.parse(getResponse(formTableFileName));
        List<? extends OverUnderTableTeam> overUnderTableTeams = overUnderTableParser.parse(getResponse(overUnderFileName));

        ParsedTablesDto parsedTablesDto = new ParsedTablesDto(wideTableTeams, formTableTeams, overUnderTableTeams, 1);

        List<Prediction> predictions = new ArrayList<>(predictor.calculate(parsedTablesDto));

        log.info("predictions.size()={}", predictions.size());

        Collections.sort(predictions, new Comparator<Prediction>() {
            @Override
            public int compare(Prediction o1, Prediction o2) {
                return o1.getTeamHomeName().compareTo(o2.getTeamHomeName());
            }
        });
        Prediction first = predictions.get(0);
        log.info("first: {}", first);


        Prediction second = predictions.get(1);
        log.info("second: {}", second);

        assertFalse(first.getEventId() == 0);
        assertEquals(first.getEventId(), second.getEventId());
        assertEquals(first.getTeamHomeName(), second.getTeamAwayName());
        assertEquals(first.getTeamAwayName(), second.getTeamHomeName());

        //home team
        first.getGoalsForGameForAllGamesForHomeTeam();
        first.getMissesForGameForAllGamesForHomeTeam();
        first.getWonsForAllGamesForHomeTeam();
        first.getDrawnsForAllGamesForHomeTeam();
        first.getLostsForAllGamesForHomeTeam();
        first.getTotalForMatchForAllGamesForHomeTeam();

        first.getGamesTb2Point5ForAllGamesForHomeTeam();
        first.getGamesTm2Point5ForAllGamesForHomeTeam();
        first.getGamesTb1Point5ForAllGamesForHomeTeam();
        first.getGamesTm1Point5ForAllGamesForHomeTeam();

        first.getGoalsForGameForLastThreeGamesForHomeTeam();
        first.getMissesForGameForLastThreeGamesForHomeTeam();
        first.getWonsForLastThreeGamesForHomeTeam();
        first.getDrawnsForLastThreeGamesForHomeTeam();
        first.getLostsForLastThreeGamesForHomeTeam();
        first.getTotalForMatchForLastThreeGamesForHomeTeam();


        //away team
        first.getGoalsForGameForAllGamesForAwayTeam();
        first.getMissesForGameForAllGamesForAwayTeam();
        first.getWonsForAllGamesForAwayTeam();
        first.getDrawnsForAllGamesForAwayTeam();
        first.getLostsForAllGamesForAwayTeam();
        first.getTotalForMatchForAllGamesForAwayTeam();

        first.getGamesTb2Point5ForAllGamesForAwayTeam();
        first.getGamesTm2Point5ForAllGamesForAwayTeam();
        first.getGamesTb1Point5ForAllGamesForAwayTeam();
        first.getGamesTm1Point5ForAllGamesForAwayTeam();

        first.getGoalsForGameForLastThreeGamesForAwayTeam();
        first.getMissesForGameForLastThreeGamesForAwayTeam();
        first.getWonsForLastThreeGamesForAwayTeam();
        first.getDrawnsForLastThreeGamesForAwayTeam();
        first.getLostsForLastThreeGamesForAwayTeam();
        first.getTotalForMatchForLastThreeGamesForAwayTeam();


        //second
        //home team
        second.getGoalsForGameForAllGamesForHomeTeam();
        second.getMissesForGameForAllGamesForHomeTeam();
        second.getWonsForAllGamesForHomeTeam();
        second.getDrawnsForAllGamesForHomeTeam();
        second.getLostsForAllGamesForHomeTeam();
        second.getTotalForMatchForAllGamesForHomeTeam();

        second.getGamesTb2Point5ForAllGamesForHomeTeam();
        second.getGamesTm2Point5ForAllGamesForHomeTeam();
        second.getGamesTb1Point5ForAllGamesForHomeTeam();
        second.getGamesTm1Point5ForAllGamesForHomeTeam();

        second.getGoalsForGameForLastThreeGamesForHomeTeam();
        second.getMissesForGameForLastThreeGamesForHomeTeam();
        second.getWonsForLastThreeGamesForHomeTeam();
        second.getDrawnsForLastThreeGamesForHomeTeam();
        second.getLostsForLastThreeGamesForHomeTeam();
        second.getTotalForMatchForLastThreeGamesForHomeTeam();


        //away team
        second.getGoalsForGameForAllGamesForAwayTeam();
        second.getMissesForGameForAllGamesForAwayTeam();
        second.getWonsForAllGamesForAwayTeam();
        second.getDrawnsForAllGamesForAwayTeam();
        second.getLostsForAllGamesForAwayTeam();
        second.getTotalForMatchForAllGamesForAwayTeam();

        second.getGamesTb2Point5ForAllGamesForAwayTeam();
        second.getGamesTm2Point5ForAllGamesForAwayTeam();
        second.getGamesTb1Point5ForAllGamesForAwayTeam();
        second.getGamesTm1Point5ForAllGamesForAwayTeam();

        second.getGoalsForGameForLastThreeGamesForAwayTeam();
        second.getMissesForGameForLastThreeGamesForAwayTeam();
        second.getWonsForLastThreeGamesForAwayTeam();
        second.getDrawnsForLastThreeGamesForAwayTeam();
        second.getLostsForLastThreeGamesForAwayTeam();
        second.getTotalForMatchForLastThreeGamesForAwayTeam();
    }

}
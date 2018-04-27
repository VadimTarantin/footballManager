package com.football.manager.service.prediction.impl;

import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.entity.Prediction;
import com.football.manager.entity.TableTeam;
import com.football.manager.service.prediction.Predicable;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class Predictor implements Predicable {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    @Override
    public List<Prediction> calculate(ParsedTablesDto parsedTablesDto) {
        List<Prediction> result = calc(parsedTablesDto);
        setEventId(result, parsedTablesDto.getEventId());
        return result;
    }

    private List<Prediction> calc(ParsedTablesDto parsedTablesDto) {
        List<Prediction> result = new LinkedList<>();
        List<? extends TableTeam> wideTableTeams = parsedTablesDto.getWideTableTeams();
        List<? extends TableTeam> formTableTeams = parsedTablesDto.getFormTableTeams();
        List<? extends OverUnderTableTeam> overUnderTableTeams = parsedTablesDto.getOverUnderTableTeams();

        Collections.sort(wideTableTeams);
        Collections.sort(formTableTeams);
        Collections.sort(overUnderTableTeams);

        for (int i = 0; i < wideTableTeams.size(); i++) {
            String currentTeamName = wideTableTeams.get(i).getTeamName();
            for (int j = 0; j < wideTableTeams.size(); j++) {
                String secondTeamName = wideTableTeams.get(j).getTeamName();
                if (!currentTeamName.equals(secondTeamName)) {
                    try {
                        result.add(calculatePredictionForPairFirstHomeSecondAway(parsedTablesDto, i, j));
                    } catch (Exception e) {
                        log.warn("Cannot calculate prediction for teams: {}, {}, {} and {}, {}, {}",
                                wideTableTeams.get(i), formTableTeams.get(i), overUnderTableTeams.get(i),
                                wideTableTeams.get(j), formTableTeams.get(j), overUnderTableTeams.get(j), e);
                    }
                    try {
                        result.add(calculatePredictionForPairFirstAwaySecondHome(parsedTablesDto, j, i));
                    } catch (Exception e) {
                        log.warn("Cannot calculate prediction for teams: {}, {}, {} and {}, {}, {}",
                                wideTableTeams.get(i), formTableTeams.get(i), overUnderTableTeams.get(i),
                                wideTableTeams.get(j), formTableTeams.get(j), overUnderTableTeams.get(j), e);
                    }
                }
            }

        }

        return result;
    }

    private Prediction calculatePredictionForPairFirstHomeSecondAway(ParsedTablesDto parsedTablesDto, int i, int j) {
        List<? extends TableTeam> wideTableTeams = parsedTablesDto.getWideTableTeams();
        List<? extends TableTeam> formTableTeams = parsedTablesDto.getFormTableTeams();
        List<? extends OverUnderTableTeam> overUnderTableTeams = parsedTablesDto.getOverUnderTableTeams();

        Prediction result = new Prediction();
        result.setTeamHomeName(wideTableTeams.get(i).getTeamName());
        result.setTeamAwayName(wideTableTeams.get(j).getTeamName());

        //home team
        result.setGoalsForGameForAllGamesForHomeTeam(wideTableTeams.get(i).getTotalGoalsHome() / wideTableTeams.get(i).getTotalMatchesHome());
        result.setMissesForGameForAllGamesForHomeTeam(wideTableTeams.get(i).getTotalMissedHome() / wideTableTeams.get(i).getTotalMatchesHome());
        result.setWonsForAllGamesForHomeTeam(wideTableTeams.get(i).getTotalMatchesWonHome() * 100 / wideTableTeams.get(i).getTotalMatchesHome());
        result.setLostsForAllGamesForHomeTeam(wideTableTeams.get(i).getTotalMatchesLostHome() * 100 / wideTableTeams.get(i).getTotalMatchesHome());
        result.setDrawnsForAllGamesForHomeTeam(100 - result.getWonsForAllGamesForHomeTeam() - result.getLostsForAllGamesForHomeTeam());
        result.setTotalForMatchForAllGamesForHomeTeam((wideTableTeams.get(i).getTotalGoalsHome() + wideTableTeams.get(i).getTotalMissedHome()) / wideTableTeams.get(i).getTotalMatchesHome());

        OverUnderTableTeam currentOverUnderTableTeam = overUnderTableTeams.get(i);
        result.setGamesTb2Point5ForAllGamesForHomeTeam((currentOverUnderTableTeam.getThreeGoals() + currentOverUnderTableTeam.getFourGoals()
                + currentOverUnderTableTeam.getFiveGoals() + currentOverUnderTableTeam.getSixGoals()
                + currentOverUnderTableTeam.getSevenGoals() + currentOverUnderTableTeam.getMoreThenSevenGoals()) * 100
                / currentOverUnderTableTeam.getTotalMatches());
        result.setGamesTm2Point5ForAllGamesForHomeTeam(100 - result.getGamesTb2Point5ForAllGamesForHomeTeam());
        result.setGamesTb1Point5ForAllGamesForHomeTeam((currentOverUnderTableTeam.getTwoGoals() + currentOverUnderTableTeam.getThreeGoals()
                + currentOverUnderTableTeam.getFourGoals() + currentOverUnderTableTeam.getFiveGoals() + currentOverUnderTableTeam.getSixGoals()
                + currentOverUnderTableTeam.getSevenGoals() + currentOverUnderTableTeam.getMoreThenSevenGoals()) * 100
                / currentOverUnderTableTeam.getTotalMatches());
        result.setGamesTm1Point5ForAllGamesForHomeTeam(100 - result.getGamesTb1Point5ForAllGamesForHomeTeam());

        TableTeam currentFormTableTeam = formTableTeams.get(i);
        result.setGoalsForGameForLastThreeGamesForHomeTeam(currentFormTableTeam.getTotalGoalsHome() / currentFormTableTeam.getTotalMatchesHome());
        result.setMissesForGameForLastThreeGamesForHomeTeam(currentFormTableTeam.getTotalMissedHome() / currentFormTableTeam.getTotalMatchesHome());
        result.setWonsForLastThreeGamesForHomeTeam(100 * currentFormTableTeam.getTotalMatchesWonHome() / currentFormTableTeam.getTotalMatchesHome());
        result.setDrawnsForLastThreeGamesForHomeTeam(100 * currentFormTableTeam.getTotalMatchesDrawnHome() / currentFormTableTeam.getTotalMatchesHome());
        result.setLostsForLastThreeGamesForHomeTeam(100 - result.getWonsForLastThreeGamesForHomeTeam() - result.getDrawnsForLastThreeGamesForHomeTeam());
        result.setTotalForMatchForLastThreeGamesForHomeTeam((currentFormTableTeam.getTotalGoalsHome() + currentFormTableTeam.getTotalMissedHome()) / currentFormTableTeam.getTotalMatchesHome());


        //away team
        TableTeam awayWideTableTeam = wideTableTeams.get(j);
        result.setGoalsForGameForAllGamesForAwayTeam(awayWideTableTeam.getTotalGoalsAway() / awayWideTableTeam.getTotalMatchesAway());
        result.setMissesForGameForAllGamesForAwayTeam(awayWideTableTeam.getTotalMissedAway() / awayWideTableTeam.getTotalMatchesAway());
        result.setWonsForAllGamesForAwayTeam(100 * awayWideTableTeam.getTotalMatchesWonAway() / awayWideTableTeam.getTotalMatchesAway());
        result.setLostsForAllGamesForAwayTeam(awayWideTableTeam.getTotalGoalsAway() / awayWideTableTeam.getTotalMatchesAway());
        result.setDrawnsForAllGamesForAwayTeam(100 - result.getWonsForAllGamesForAwayTeam() - result.getLostsForAllGamesForAwayTeam());
        result.setTotalForMatchForAllGamesForAwayTeam((awayWideTableTeam.getTotalGoalsAway() + awayWideTableTeam.getTotalMissedAway()) / awayWideTableTeam.getTotalMatchesAway());

        OverUnderTableTeam awayOverUnderTableTeam = overUnderTableTeams.get(j);
        result.setGamesTb2Point5ForAllGamesForAwayTeam(100 * (awayOverUnderTableTeam.getThreeGoals() + awayOverUnderTableTeam.getFourGoals()
        + awayOverUnderTableTeam.getFiveGoals() + awayOverUnderTableTeam.getSixGoals() + awayOverUnderTableTeam.getSevenGoals()
        + awayOverUnderTableTeam.getMoreThenSevenGoals()) / awayOverUnderTableTeam.getTotalMatches());
        result.setGamesTm2Point5ForAllGamesForAwayTeam(100 - result.getGamesTb2Point5ForAllGamesForAwayTeam());
        result.setGamesTb1Point5ForAllGamesForAwayTeam(100 * (awayOverUnderTableTeam.getTwoGoals() + awayOverUnderTableTeam.getThreeGoals() + awayOverUnderTableTeam.getFourGoals()
                + awayOverUnderTableTeam.getFiveGoals() + awayOverUnderTableTeam.getSixGoals() + awayOverUnderTableTeam.getSevenGoals()
                + awayOverUnderTableTeam.getMoreThenSevenGoals()) / awayOverUnderTableTeam.getTotalMatches());
        result.setGamesTm1Point5ForAllGamesForAwayTeam(100 - result.getGamesTb1Point5ForAllGamesForAwayTeam());

        TableTeam awayTableTeam = formTableTeams.get(j);
        result.setGoalsForGameForLastThreeGamesForAwayTeam(awayTableTeam.getTotalGoalsAway() / awayTableTeam.getTotalMatchesAway());
        result.setMissesForGameForLastThreeGamesForAwayTeam(awayTableTeam.getTotalMissedAway() / awayTableTeam.getTotalMatchesAway());
        result.setWonsForLastThreeGamesForAwayTeam(100 * awayTableTeam.getTotalMatchesWonAway() / awayTableTeam.getTotalMatchesAway());
        result.setDrawnsForLastThreeGamesForAwayTeam(100 * awayTableTeam.getTotalMatchesDrawnAway() / awayTableTeam.getTotalMatchesAway());
        result.setLostsForLastThreeGamesForAwayTeam(100 - result.getWonsForLastThreeGamesForAwayTeam() - result.getDrawnsForLastThreeGamesForAwayTeam());
        result.setTotalForMatchForLastThreeGamesForAwayTeam((awayTableTeam.getTotalGoalsAway() + awayTableTeam.getTotalMissedAway()) / awayTableTeam.getTotalMatchesAway());
        return result;
    }

    private Prediction calculatePredictionForPairFirstAwaySecondHome(ParsedTablesDto parsedTablesDto, int i, int j) {
        return null;
    }

    private void setEventId(List<Prediction> result, int eventId) {
        for (Prediction prediction : result) {
            prediction.setEventId(eventId);
        }
    }


}
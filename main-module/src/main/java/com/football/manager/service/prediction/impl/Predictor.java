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
            for (int j = i; j < wideTableTeams.size(); j++) {
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
                        result.add(calculatePredictionForPairFirstAwaySecondHome(parsedTablesDto, i, j));
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
        TableTeam homeTableTeam = wideTableTeams.get(i);
        result.setGoalsForGameForAllGamesForHomeTeam(homeTableTeam.getTotalGoalsHome() / homeTableTeam.getTotalMatchesHome());
        result.setMissesForGameForAllGamesForHomeTeam(homeTableTeam.getTotalMissedHome() / homeTableTeam.getTotalMatchesHome());
        result.setWonsForAllGamesForHomeTeam(homeTableTeam.getTotalMatchesWonHome() * 100 / homeTableTeam.getTotalMatchesHome());
        result.setLostsForAllGamesForHomeTeam(homeTableTeam.getTotalMatchesLostHome() * 100 / homeTableTeam.getTotalMatchesHome());
        result.setDrawnsForAllGamesForHomeTeam(100 - result.getWonsForAllGamesForHomeTeam() - result.getLostsForAllGamesForHomeTeam());
        result.setTotalForMatchForAllGamesForHomeTeam((homeTableTeam.getTotalGoalsHome() + homeTableTeam.getTotalMissedHome()) / homeTableTeam.getTotalMatchesHome());

        OverUnderTableTeam homeOverUnderTableTeam = overUnderTableTeams.get(i);
        result.setGamesTb2Point5ForAllGamesForHomeTeam((homeOverUnderTableTeam.getThreeGoals() + homeOverUnderTableTeam.getFourGoals()
                + homeOverUnderTableTeam.getFiveGoals() + homeOverUnderTableTeam.getSixGoals()
                + homeOverUnderTableTeam.getSevenGoals() + homeOverUnderTableTeam.getMoreThenSevenGoals()) * 100
                / homeOverUnderTableTeam.getTotalMatches());
        result.setGamesTm2Point5ForAllGamesForHomeTeam(100 - result.getGamesTb2Point5ForAllGamesForHomeTeam());
        result.setGamesTb1Point5ForAllGamesForHomeTeam((homeOverUnderTableTeam.getTwoGoals() + homeOverUnderTableTeam.getThreeGoals()
                + homeOverUnderTableTeam.getFourGoals() + homeOverUnderTableTeam.getFiveGoals() + homeOverUnderTableTeam.getSixGoals()
                + homeOverUnderTableTeam.getSevenGoals() + homeOverUnderTableTeam.getMoreThenSevenGoals()) * 100
                / homeOverUnderTableTeam.getTotalMatches());
        result.setGamesTm1Point5ForAllGamesForHomeTeam(100 - result.getGamesTb1Point5ForAllGamesForHomeTeam());

        TableTeam homeFormTableTeam = formTableTeams.get(i);
        result.setGoalsForGameForLastThreeGamesForHomeTeam(homeFormTableTeam.getTotalGoalsHome() / homeFormTableTeam.getTotalMatchesHome());
        result.setMissesForGameForLastThreeGamesForHomeTeam(homeFormTableTeam.getTotalMissedHome() / homeFormTableTeam.getTotalMatchesHome());
        result.setWonsForLastThreeGamesForHomeTeam(100 * homeFormTableTeam.getTotalMatchesWonHome() / homeFormTableTeam.getTotalMatchesHome());
        result.setDrawnsForLastThreeGamesForHomeTeam(100 * homeFormTableTeam.getTotalMatchesDrawnHome() / homeFormTableTeam.getTotalMatchesHome());
        result.setLostsForLastThreeGamesForHomeTeam(100 - result.getWonsForLastThreeGamesForHomeTeam() - result.getDrawnsForLastThreeGamesForHomeTeam());
        result.setTotalForMatchForLastThreeGamesForHomeTeam((homeFormTableTeam.getTotalGoalsHome() + homeFormTableTeam.getTotalMissedHome()) / homeFormTableTeam.getTotalMatchesHome());


        //away team
        TableTeam awayWideTableTeam = wideTableTeams.get(j);
        result.setGoalsForGameForAllGamesForAwayTeam(awayWideTableTeam.getTotalGoalsAway() / awayWideTableTeam.getTotalMatchesAway());
        result.setMissesForGameForAllGamesForAwayTeam(awayWideTableTeam.getTotalMissedAway() / awayWideTableTeam.getTotalMatchesAway());
        result.setWonsForAllGamesForAwayTeam(100 * awayWideTableTeam.getTotalMatchesWonAway() / awayWideTableTeam.getTotalMatchesAway());
        result.setLostsForAllGamesForAwayTeam(awayWideTableTeam.getTotalMatchesLostAway() / awayWideTableTeam.getTotalMatchesAway());
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
        //i - away
        //j - home
        List<? extends TableTeam> wideTableTeams = parsedTablesDto.getWideTableTeams();
        List<? extends TableTeam> formTableTeams = parsedTablesDto.getFormTableTeams();
        List<? extends OverUnderTableTeam> overUnderTableTeams = parsedTablesDto.getOverUnderTableTeams();

        Prediction result = new Prediction();
        result.setTeamAwayName(wideTableTeams.get(i).getTeamName());
        result.setTeamHomeName(wideTableTeams.get(j).getTeamName());

        //away team
        TableTeam homeWideTableTeam = wideTableTeams.get(j);
        result.setGoalsForGameForAllGamesForAwayTeam(homeWideTableTeam.getTotalGoalsAway() / homeWideTableTeam.getTotalMatchesAway());
        result.setMissesForGameForAllGamesForAwayTeam(homeWideTableTeam.getTotalMissedAway() / homeWideTableTeam.getTotalMatchesAway());
        result.setWonsForAllGamesForAwayTeam(100 * homeWideTableTeam.getTotalMatchesWonAway() / homeWideTableTeam.getTotalMatchesAway());
        result.setLostsForAllGamesForAwayTeam(100 * homeWideTableTeam.getTotalMissedAway() / homeWideTableTeam.getTotalMatchesAway());
        result.setDrawnsForAllGamesForAwayTeam(100 - result.getWonsForAllGamesForAwayTeam() - result.getLostsForAllGamesForAwayTeam());
        result.setTotalForMatchForAllGamesForAwayTeam((homeWideTableTeam.getTotalGoalsAway() + homeWideTableTeam.getTotalMissedAway()) / homeWideTableTeam.getTotalMatchesAway());

        OverUnderTableTeam homeOverUnderTableTeam = overUnderTableTeams.get(j);
        result.setGamesTb2Point5ForAllGamesForAwayTeam(100 * (homeOverUnderTableTeam.getThreeGoals() + homeOverUnderTableTeam.getFourGoals() + homeOverUnderTableTeam.getFiveGoals()
        + homeOverUnderTableTeam.getSixGoals() + homeOverUnderTableTeam.getSevenGoals() + homeOverUnderTableTeam.getMoreThenSevenGoals()) / homeOverUnderTableTeam.getTotalMatches());
        result.setGamesTm2Point5ForAllGamesForAwayTeam(100 - result.getGamesTb2Point5ForAllGamesForAwayTeam());
        result.setGamesTb1Point5ForAllGamesForAwayTeam(100 * (homeOverUnderTableTeam.getTwoGoals() + homeOverUnderTableTeam.getThreeGoals() + homeOverUnderTableTeam.getFourGoals()
                + homeOverUnderTableTeam.getFiveGoals() + homeOverUnderTableTeam.getSixGoals() + homeOverUnderTableTeam.getSevenGoals()
                + homeOverUnderTableTeam.getMoreThenSevenGoals()) / homeOverUnderTableTeam.getTotalMatches());
        result.setGamesTm1Point5ForAllGamesForAwayTeam(100 - result.getGamesTb1Point5ForAllGamesForAwayTeam());

        TableTeam homeTableTeam = formTableTeams.get(j);
        result.setGoalsForGameForLastThreeGamesForAwayTeam(homeTableTeam.getTotalGoalsAway() / homeTableTeam.getTotalMatchesAway());
        result.setMissesForGameForLastThreeGamesForAwayTeam(homeTableTeam.getTotalMissedAway() / homeTableTeam.getTotalMatchesAway());
        result.setWonsForLastThreeGamesForAwayTeam(100 * homeTableTeam.getTotalMatchesWonAway() / homeTableTeam.getTotalMatchesAway());
        result.setLostsForLastThreeGamesForAwayTeam(100 * homeTableTeam.getTotalMatchesLostAway() / homeTableTeam.getTotalMatchesAway());
        result.setDrawnsForLastThreeGamesForAwayTeam(100 - result.getWonsForLastThreeGamesForAwayTeam() - result.getLostsForLastThreeGamesForAwayTeam());
        result.setTotalForMatchForLastThreeGamesForAwayTeam((homeTableTeam.getTotalGoalsAway() + homeTableTeam.getTotalMissedAway()) / homeTableTeam.getTotalMatchesAway());


        //home team
        TableTeam awayTableTeam = wideTableTeams.get(i);
        result.setGoalsForGameForAllGamesForHomeTeam(awayTableTeam.getTotalGoalsHome() / awayTableTeam.getTotalMatchesHome());
        result.setMissesForGameForAllGamesForHomeTeam(awayTableTeam.getTotalMissedHome() / awayTableTeam.getTotalMatchesHome());
        result.setWonsForAllGamesForHomeTeam(100 * awayTableTeam.getTotalMatchesWonHome() / awayTableTeam.getTotalMatchesHome());
        result.setLostsForAllGamesForHomeTeam(100 * awayTableTeam.getTotalMatchesLostHome() / awayTableTeam.getTotalMatchesHome());
        result.setDrawnsForAllGamesForHomeTeam(100 - result.getWonsForAllGamesForHomeTeam() - result.getLostsForAllGamesForHomeTeam());
        result.setTotalForMatchForAllGamesForHomeTeam((awayTableTeam.getTotalGoalsHome() + awayTableTeam.getTotalMissedHome()) / awayTableTeam.getTotalMatchesHome());

        OverUnderTableTeam awayOverUnderTableTeam = overUnderTableTeams.get(i);
        result.setGamesTb2Point5ForAllGamesForHomeTeam((awayOverUnderTableTeam.getThreeGoals() + awayOverUnderTableTeam.getFourGoals() + awayOverUnderTableTeam.getFiveGoals()
        + awayOverUnderTableTeam.getSixGoals() + awayOverUnderTableTeam.getSevenGoals() + awayOverUnderTableTeam.getMoreThenSevenGoals()) / awayOverUnderTableTeam.getTotalMatches());
        result.setGamesTm2Point5ForAllGamesForHomeTeam(result.getGamesTb2Point5ForAllGamesForHomeTeam());
        result.setGamesTb1Point5ForAllGamesForHomeTeam((awayOverUnderTableTeam.getTwoGoals() + awayOverUnderTableTeam.getThreeGoals() + awayOverUnderTableTeam.getFourGoals()
                + awayOverUnderTableTeam.getFiveGoals() + awayOverUnderTableTeam.getSixGoals() + awayOverUnderTableTeam.getSevenGoals()
                + awayOverUnderTableTeam.getMoreThenSevenGoals()) / awayOverUnderTableTeam.getTotalMatches());
        result.setGamesTm1Point5ForAllGamesForHomeTeam(result.getGamesTb1Point5ForAllGamesForHomeTeam());

        TableTeam awayFormTableTeam = formTableTeams.get(i);
        result.setGoalsForGameForLastThreeGamesForHomeTeam(awayFormTableTeam.getTotalGoalsHome() / awayFormTableTeam.getTotalMatchesHome());
        result.setMissesForGameForLastThreeGamesForHomeTeam(awayFormTableTeam.getTotalMissedHome() / awayFormTableTeam.getTotalMatchesHome());
        result.setWonsForLastThreeGamesForHomeTeam(100 * awayFormTableTeam.getTotalMatchesWonHome() / awayFormTableTeam.getTotalMatchesHome());
        result.setLostsForLastThreeGamesForHomeTeam(100 * awayFormTableTeam.getTotalMatchesLostHome() / awayFormTableTeam.getTotalMatchesHome());
        result.setDrawnsForLastThreeGamesForHomeTeam(100 - result.getWonsForLastThreeGamesForHomeTeam() - result.getLostsForLastThreeGamesForHomeTeam());
        result.setTotalForMatchForLastThreeGamesForHomeTeam((awayFormTableTeam.getTotalGoalsHome() + awayFormTableTeam.getTotalMissedHome()) / awayFormTableTeam.getTotalMatchesHome());

        return result;
    }

    private void setEventId(List<Prediction> result, int eventId) {
        for (Prediction prediction : result) {
            prediction.setEventId(eventId);
        }
    }


}
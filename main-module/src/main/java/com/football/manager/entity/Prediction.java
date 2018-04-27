package com.football.manager.entity;

import java.util.Objects;

public class Prediction {

    private int eventId;
    private int idTeamHome;
    private int idTeamAway;

    //home team
    private float goalsForGameForAllGamesForHomeTeam;
    private float missesForGameForAllGamesForHomeTeam;
    private float wonsForAllGamesForHomeTeam;
    private float drawnsForAllGamesForHomeTeam;
    private float lostsForAllGamesForHomeTeam;
    private float totalForMatchForAllGamesForHomeTeam;

    private float gamesTb2Point5ForAllGamesForHomeTeam;
    private float gamesTm2Point5ForAllGamesForHomeTeam;
    private float gamesTb1Point5ForAllGamesForHomeTeam;
    private float gamesTm1Point5ForAllGamesForHomeTeam;

    private float goalsForGameForLastThreeGamesForHomeTeam;
    private float missesForGameForLastThreeGamesForHomeTeam;
    private float wonsForLastThreeGamesForHomeTeam;
    private float drawnsForLastThreeGamesForHomeTeam;
    private float lostsForLastThreeGamesForHomeTeam;
    private float totalForMatchForLastThreeGamesForHomeTeam;

    //away team
    private float goalsForGameForAllGamesForAwayTeam;
    private float missesForGameForAllGamesForAwayTeam;
    private float wonsForAllGamesForAwayTeam;
    private float drawnsForAllGamesForAwayTeam;
    private float lostsForAllGamesForAwayTeam;
    private float totalForMatchForAllGamesForAwayTeam;

    private float gamesTb2Point5ForAllGamesForAwayTeam;
    private float gamesTm2Point5ForAllGamesForAwayTeam;
    private float gamesTb1Point5ForAllGamesForAwayTeam;
    private float gamesTm1Point5ForAllGamesForAwayTeam;

    private float goalsForGameForLastThreeGamesForAwayTeam;
    private float missesForGameForLastThreeGamesForAwayTeam;
    private float wonsForLastThreeGamesForAwayTeam;
    private float drawnsForLastThreeGamesForAwayTeam;
    private float lostsForLastThreeGamesForAwayTeam;
    private float totalForMatchForLastThreeGamesForAwayTeam;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediction that = (Prediction) o;
        return eventId == that.eventId &&
                idTeamHome == that.idTeamHome &&
                idTeamAway == that.idTeamAway;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, idTeamHome, idTeamAway);
    }



}
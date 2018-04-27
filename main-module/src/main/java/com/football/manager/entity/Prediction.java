package com.football.manager.entity;

import java.util.Objects;

public class Prediction {

    private int eventId;
    private String teamHomeName;
    private String teamAwayName;

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

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTeamHomeName() {
        return teamHomeName;
    }

    public void setTeamHomeName(String teamHomeName) {
        this.teamHomeName = teamHomeName;
    }

    public String getTeamAwayName() {
        return teamAwayName;
    }

    public void setTeamAwayName(String teamAwayName) {
        this.teamAwayName = teamAwayName;
    }

    public void setGoalsForGameForAllGamesForHomeTeam(float goalsForGameForAllGamesForHomeTeam) {
        this.goalsForGameForAllGamesForHomeTeam = goalsForGameForAllGamesForHomeTeam;
    }

    public void setMissesForGameForAllGamesForHomeTeam(float missesForGameForAllGamesForHomeTeam) {
        this.missesForGameForAllGamesForHomeTeam = missesForGameForAllGamesForHomeTeam;
    }

    public void setWonsForAllGamesForHomeTeam(float wonsForAllGamesForHomeTeam) {
        this.wonsForAllGamesForHomeTeam = wonsForAllGamesForHomeTeam;
    }

    public void setDrawnsForAllGamesForHomeTeam(float drawnsForAllGamesForHomeTeam) {
        this.drawnsForAllGamesForHomeTeam = drawnsForAllGamesForHomeTeam;
    }

    public void setLostsForAllGamesForHomeTeam(float lostsForAllGamesForHomeTeam) {
        this.lostsForAllGamesForHomeTeam = lostsForAllGamesForHomeTeam;
    }

    public void setTotalForMatchForAllGamesForHomeTeam(float totalForMatchForAllGamesForHomeTeam) {
        this.totalForMatchForAllGamesForHomeTeam = totalForMatchForAllGamesForHomeTeam;
    }

    public void setGamesTb2Point5ForAllGamesForHomeTeam(float gamesTb2Point5ForAllGamesForHomeTeam) {
        this.gamesTb2Point5ForAllGamesForHomeTeam = gamesTb2Point5ForAllGamesForHomeTeam;
    }

    public void setGamesTm2Point5ForAllGamesForHomeTeam(float gamesTm2Point5ForAllGamesForHomeTeam) {
        this.gamesTm2Point5ForAllGamesForHomeTeam = gamesTm2Point5ForAllGamesForHomeTeam;
    }

    public void setGamesTb1Point5ForAllGamesForHomeTeam(float gamesTb1Point5ForAllGamesForHomeTeam) {
        this.gamesTb1Point5ForAllGamesForHomeTeam = gamesTb1Point5ForAllGamesForHomeTeam;
    }

    public void setGamesTm1Point5ForAllGamesForHomeTeam(float gamesTm1Point5ForAllGamesForHomeTeam) {
        this.gamesTm1Point5ForAllGamesForHomeTeam = gamesTm1Point5ForAllGamesForHomeTeam;
    }

    public void setGoalsForGameForLastThreeGamesForHomeTeam(float goalsForGameForLastThreeGamesForHomeTeam) {
        this.goalsForGameForLastThreeGamesForHomeTeam = goalsForGameForLastThreeGamesForHomeTeam;
    }

    public void setMissesForGameForLastThreeGamesForHomeTeam(float missesForGameForLastThreeGamesForHomeTeam) {
        this.missesForGameForLastThreeGamesForHomeTeam = missesForGameForLastThreeGamesForHomeTeam;
    }

    public void setWonsForLastThreeGamesForHomeTeam(float wonsForLastThreeGamesForHomeTeam) {
        this.wonsForLastThreeGamesForHomeTeam = wonsForLastThreeGamesForHomeTeam;
    }

    public void setDrawnsForLastThreeGamesForHomeTeam(float drawnsForLastThreeGamesForHomeTeam) {
        this.drawnsForLastThreeGamesForHomeTeam = drawnsForLastThreeGamesForHomeTeam;
    }

    public void setLostsForLastThreeGamesForHomeTeam(float lostsForLastThreeGamesForHomeTeam) {
        this.lostsForLastThreeGamesForHomeTeam = lostsForLastThreeGamesForHomeTeam;
    }

    public void setTotalForMatchForLastThreeGamesForHomeTeam(float totalForMatchForLastThreeGamesForHomeTeam) {
        this.totalForMatchForLastThreeGamesForHomeTeam = totalForMatchForLastThreeGamesForHomeTeam;
    }

    public void setGoalsForGameForAllGamesForAwayTeam(float goalsForGameForAllGamesForAwayTeam) {
        this.goalsForGameForAllGamesForAwayTeam = goalsForGameForAllGamesForAwayTeam;
    }

    public void setMissesForGameForAllGamesForAwayTeam(float missesForGameForAllGamesForAwayTeam) {
        this.missesForGameForAllGamesForAwayTeam = missesForGameForAllGamesForAwayTeam;
    }

    public void setWonsForAllGamesForAwayTeam(float wonsForAllGamesForAwayTeam) {
        this.wonsForAllGamesForAwayTeam = wonsForAllGamesForAwayTeam;
    }

    public void setDrawnsForAllGamesForAwayTeam(float drawnsForAllGamesForAwayTeam) {
        this.drawnsForAllGamesForAwayTeam = drawnsForAllGamesForAwayTeam;
    }

    public void setLostsForAllGamesForAwayTeam(float lostsForAllGamesForAwayTeam) {
        this.lostsForAllGamesForAwayTeam = lostsForAllGamesForAwayTeam;
    }

    public void setTotalForMatchForAllGamesForAwayTeam(float totalForMatchForAllGamesForAwayTeam) {
        this.totalForMatchForAllGamesForAwayTeam = totalForMatchForAllGamesForAwayTeam;
    }

    public void setGamesTb2Point5ForAllGamesForAwayTeam(float gamesTb2Point5ForAllGamesForAwayTeam) {
        this.gamesTb2Point5ForAllGamesForAwayTeam = gamesTb2Point5ForAllGamesForAwayTeam;
    }

    public void setGamesTm2Point5ForAllGamesForAwayTeam(float gamesTm2Point5ForAllGamesForAwayTeam) {
        this.gamesTm2Point5ForAllGamesForAwayTeam = gamesTm2Point5ForAllGamesForAwayTeam;
    }

    public void setGamesTb1Point5ForAllGamesForAwayTeam(float gamesTb1Point5ForAllGamesForAwayTeam) {
        this.gamesTb1Point5ForAllGamesForAwayTeam = gamesTb1Point5ForAllGamesForAwayTeam;
    }

    public void setGamesTm1Point5ForAllGamesForAwayTeam(float gamesTm1Point5ForAllGamesForAwayTeam) {
        this.gamesTm1Point5ForAllGamesForAwayTeam = gamesTm1Point5ForAllGamesForAwayTeam;
    }

    public void setGoalsForGameForLastThreeGamesForAwayTeam(float goalsForGameForLastThreeGamesForAwayTeam) {
        this.goalsForGameForLastThreeGamesForAwayTeam = goalsForGameForLastThreeGamesForAwayTeam;
    }

    public void setMissesForGameForLastThreeGamesForAwayTeam(float missesForGameForLastThreeGamesForAwayTeam) {
        this.missesForGameForLastThreeGamesForAwayTeam = missesForGameForLastThreeGamesForAwayTeam;
    }

    public void setWonsForLastThreeGamesForAwayTeam(float wonsForLastThreeGamesForAwayTeam) {
        this.wonsForLastThreeGamesForAwayTeam = wonsForLastThreeGamesForAwayTeam;
    }

    public void setDrawnsForLastThreeGamesForAwayTeam(float drawnsForLastThreeGamesForAwayTeam) {
        this.drawnsForLastThreeGamesForAwayTeam = drawnsForLastThreeGamesForAwayTeam;
    }

    public void setLostsForLastThreeGamesForAwayTeam(float lostsForLastThreeGamesForAwayTeam) {
        this.lostsForLastThreeGamesForAwayTeam = lostsForLastThreeGamesForAwayTeam;
    }

    public void setTotalForMatchForLastThreeGamesForAwayTeam(float totalForMatchForLastThreeGamesForAwayTeam) {
        this.totalForMatchForLastThreeGamesForAwayTeam = totalForMatchForLastThreeGamesForAwayTeam;
    }

    public int getEventId() {
        return eventId;
    }

    public float getGoalsForGameForAllGamesForHomeTeam() {
        return goalsForGameForAllGamesForHomeTeam;
    }

    public float getMissesForGameForAllGamesForHomeTeam() {
        return missesForGameForAllGamesForHomeTeam;
    }

    public float getWonsForAllGamesForHomeTeam() {
        return wonsForAllGamesForHomeTeam;
    }

    public float getDrawnsForAllGamesForHomeTeam() {
        return drawnsForAllGamesForHomeTeam;
    }

    public float getLostsForAllGamesForHomeTeam() {
        return lostsForAllGamesForHomeTeam;
    }

    public float getTotalForMatchForAllGamesForHomeTeam() {
        return totalForMatchForAllGamesForHomeTeam;
    }

    public float getGamesTb2Point5ForAllGamesForHomeTeam() {
        return gamesTb2Point5ForAllGamesForHomeTeam;
    }

    public float getGamesTm2Point5ForAllGamesForHomeTeam() {
        return gamesTm2Point5ForAllGamesForHomeTeam;
    }

    public float getGamesTb1Point5ForAllGamesForHomeTeam() {
        return gamesTb1Point5ForAllGamesForHomeTeam;
    }

    public float getGamesTm1Point5ForAllGamesForHomeTeam() {
        return gamesTm1Point5ForAllGamesForHomeTeam;
    }

    public float getGoalsForGameForLastThreeGamesForHomeTeam() {
        return goalsForGameForLastThreeGamesForHomeTeam;
    }

    public float getMissesForGameForLastThreeGamesForHomeTeam() {
        return missesForGameForLastThreeGamesForHomeTeam;
    }

    public float getWonsForLastThreeGamesForHomeTeam() {
        return wonsForLastThreeGamesForHomeTeam;
    }

    public float getDrawnsForLastThreeGamesForHomeTeam() {
        return drawnsForLastThreeGamesForHomeTeam;
    }

    public float getLostsForLastThreeGamesForHomeTeam() {
        return lostsForLastThreeGamesForHomeTeam;
    }

    public float getTotalForMatchForLastThreeGamesForHomeTeam() {
        return totalForMatchForLastThreeGamesForHomeTeam;
    }

    public float getGoalsForGameForAllGamesForAwayTeam() {
        return goalsForGameForAllGamesForAwayTeam;
    }

    public float getMissesForGameForAllGamesForAwayTeam() {
        return missesForGameForAllGamesForAwayTeam;
    }

    public float getWonsForAllGamesForAwayTeam() {
        return wonsForAllGamesForAwayTeam;
    }

    public float getDrawnsForAllGamesForAwayTeam() {
        return drawnsForAllGamesForAwayTeam;
    }

    public float getLostsForAllGamesForAwayTeam() {
        return lostsForAllGamesForAwayTeam;
    }

    public float getTotalForMatchForAllGamesForAwayTeam() {
        return totalForMatchForAllGamesForAwayTeam;
    }

    public float getGamesTb2Point5ForAllGamesForAwayTeam() {
        return gamesTb2Point5ForAllGamesForAwayTeam;
    }

    public float getGamesTm2Point5ForAllGamesForAwayTeam() {
        return gamesTm2Point5ForAllGamesForAwayTeam;
    }

    public float getGamesTb1Point5ForAllGamesForAwayTeam() {
        return gamesTb1Point5ForAllGamesForAwayTeam;
    }

    public float getGamesTm1Point5ForAllGamesForAwayTeam() {
        return gamesTm1Point5ForAllGamesForAwayTeam;
    }

    public float getGoalsForGameForLastThreeGamesForAwayTeam() {
        return goalsForGameForLastThreeGamesForAwayTeam;
    }

    public float getMissesForGameForLastThreeGamesForAwayTeam() {
        return missesForGameForLastThreeGamesForAwayTeam;
    }

    public float getWonsForLastThreeGamesForAwayTeam() {
        return wonsForLastThreeGamesForAwayTeam;
    }

    public float getDrawnsForLastThreeGamesForAwayTeam() {
        return drawnsForLastThreeGamesForAwayTeam;
    }

    public float getLostsForLastThreeGamesForAwayTeam() {
        return lostsForLastThreeGamesForAwayTeam;
    }

    public float getTotalForMatchForLastThreeGamesForAwayTeam() {
        return totalForMatchForLastThreeGamesForAwayTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediction that = (Prediction) o;
        return eventId == that.eventId &&
                Objects.equals(teamHomeName, that.teamHomeName) &&
                Objects.equals(teamAwayName, that.teamAwayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, teamHomeName, teamAwayName);
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "eventId=" + eventId +
                ", teamHomeName='" + teamHomeName + '\'' +
                ", teamAwayName='" + teamAwayName + '\'' +
                ", goalsForGameForAllGamesForHomeTeam=" + goalsForGameForAllGamesForHomeTeam +
                ", missesForGameForAllGamesForHomeTeam=" + missesForGameForAllGamesForHomeTeam +
                ", wonsForAllGamesForHomeTeam=" + wonsForAllGamesForHomeTeam +
                ", drawnsForAllGamesForHomeTeam=" + drawnsForAllGamesForHomeTeam +
                ", lostsForAllGamesForHomeTeam=" + lostsForAllGamesForHomeTeam +
                ", totalForMatchForAllGamesForHomeTeam=" + totalForMatchForAllGamesForHomeTeam +
                ", gamesTb2Point5ForAllGamesForHomeTeam=" + gamesTb2Point5ForAllGamesForHomeTeam +
                ", gamesTm2Point5ForAllGamesForHomeTeam=" + gamesTm2Point5ForAllGamesForHomeTeam +
                ", gamesTb1Point5ForAllGamesForHomeTeam=" + gamesTb1Point5ForAllGamesForHomeTeam +
                ", gamesTm1Point5ForAllGamesForHomeTeam=" + gamesTm1Point5ForAllGamesForHomeTeam +
                ", goalsForGameForLastThreeGamesForHomeTeam=" + goalsForGameForLastThreeGamesForHomeTeam +
                ", missesForGameForLastThreeGamesForHomeTeam=" + missesForGameForLastThreeGamesForHomeTeam +
                ", wonsForLastThreeGamesForHomeTeam=" + wonsForLastThreeGamesForHomeTeam +
                ", drawnsForLastThreeGamesForHomeTeam=" + drawnsForLastThreeGamesForHomeTeam +
                ", lostsForLastThreeGamesForHomeTeam=" + lostsForLastThreeGamesForHomeTeam +
                ", totalForMatchForLastThreeGamesForHomeTeam=" + totalForMatchForLastThreeGamesForHomeTeam +
                ", goalsForGameForAllGamesForAwayTeam=" + goalsForGameForAllGamesForAwayTeam +
                ", missesForGameForAllGamesForAwayTeam=" + missesForGameForAllGamesForAwayTeam +
                ", wonsForAllGamesForAwayTeam=" + wonsForAllGamesForAwayTeam +
                ", drawnsForAllGamesForAwayTeam=" + drawnsForAllGamesForAwayTeam +
                ", lostsForAllGamesForAwayTeam=" + lostsForAllGamesForAwayTeam +
                ", totalForMatchForAllGamesForAwayTeam=" + totalForMatchForAllGamesForAwayTeam +
                ", gamesTb2Point5ForAllGamesForAwayTeam=" + gamesTb2Point5ForAllGamesForAwayTeam +
                ", gamesTm2Point5ForAllGamesForAwayTeam=" + gamesTm2Point5ForAllGamesForAwayTeam +
                ", gamesTb1Point5ForAllGamesForAwayTeam=" + gamesTb1Point5ForAllGamesForAwayTeam +
                ", gamesTm1Point5ForAllGamesForAwayTeam=" + gamesTm1Point5ForAllGamesForAwayTeam +
                ", goalsForGameForLastThreeGamesForAwayTeam=" + goalsForGameForLastThreeGamesForAwayTeam +
                ", missesForGameForLastThreeGamesForAwayTeam=" + missesForGameForLastThreeGamesForAwayTeam +
                ", wonsForLastThreeGamesForAwayTeam=" + wonsForLastThreeGamesForAwayTeam +
                ", drawnsForLastThreeGamesForAwayTeam=" + drawnsForLastThreeGamesForAwayTeam +
                ", lostsForLastThreeGamesForAwayTeam=" + lostsForLastThreeGamesForAwayTeam +
                ", totalForMatchForLastThreeGamesForAwayTeam=" + totalForMatchForLastThreeGamesForAwayTeam +
                '}';
    }

}
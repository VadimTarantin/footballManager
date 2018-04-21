package com.football.manager.entity;

import java.util.Objects;

public class Prediction {

    private int id;

    private int teamHome;
    private float doesGoalsHome;
    private float doesMissedHome;
    private float victoriesHomePercents;
    private float drawnsHomePercents;
    private float lostsHomePercens;

    private int teamAway;
    private float doesGoalsAway;
    private float doesMissedAway;
    private float victoriesAwayPercents;
    private float drawnAwayPercents;
    private float lostsAwayPercents;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(int teamHome) {
        this.teamHome = teamHome;
    }

    public float getDoesGoalsHome() {
        return doesGoalsHome;
    }

    public void setDoesGoalsHome(float doesGoalsHome) {
        this.doesGoalsHome = doesGoalsHome;
    }

    public float getDoesMissedHome() {
        return doesMissedHome;
    }

    public void setDoesMissedHome(float doesMissedHome) {
        this.doesMissedHome = doesMissedHome;
    }

    public float getVictoriesHomePercents() {
        return victoriesHomePercents;
    }

    public void setVictoriesHomePercents(float victoriesHomePercents) {
        this.victoriesHomePercents = victoriesHomePercents;
    }

    public float getDrawnsHomePercents() {
        return drawnsHomePercents;
    }

    public void setDrawnsHomePercents(float drawnsHomePercents) {
        this.drawnsHomePercents = drawnsHomePercents;
    }

    public float getLostsHomePercens() {
        return lostsHomePercens;
    }

    public void setLostsHomePercens(float lostsHomePercens) {
        this.lostsHomePercens = lostsHomePercens;
    }

    public int getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(int teamAway) {
        this.teamAway = teamAway;
    }

    public float getDoesGoalsAway() {
        return doesGoalsAway;
    }

    public void setDoesGoalsAway(float doesGoalsAway) {
        this.doesGoalsAway = doesGoalsAway;
    }

    public float getDoesMissedAway() {
        return doesMissedAway;
    }

    public void setDoesMissedAway(float doesMissedAway) {
        this.doesMissedAway = doesMissedAway;
    }

    public float getVictoriesAwayPercents() {
        return victoriesAwayPercents;
    }

    public void setVictoriesAwayPercents(float victoriesAwayPercents) {
        this.victoriesAwayPercents = victoriesAwayPercents;
    }

    public float getDrawnAwayPercents() {
        return drawnAwayPercents;
    }

    public void setDrawnAwayPercents(float drawnAwayPercents) {
        this.drawnAwayPercents = drawnAwayPercents;
    }

    public float getLostsAwayPercents() {
        return lostsAwayPercents;
    }

    public void setLostsAwayPercents(float lostsAwayPercents) {
        this.lostsAwayPercents = lostsAwayPercents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediction that = (Prediction) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "id=" + id +
                ", teamHome=" + teamHome +
                ", doesGoalsHome=" + doesGoalsHome +
                ", doesMissedHome=" + doesMissedHome +
                ", victoriesHomePercents=" + victoriesHomePercents +
                ", drawnsHomePercents=" + drawnsHomePercents +
                ", lostsHomePercens=" + lostsHomePercens +
                ", teamAway=" + teamAway +
                ", doesGoalsAway=" + doesGoalsAway +
                ", doesMissedAway=" + doesMissedAway +
                ", victoriesAwayPercents=" + victoriesAwayPercents +
                ", drawnAwayPercents=" + drawnAwayPercents +
                ", lostsAwayPercents=" + lostsAwayPercents +
                '}';
    }

}
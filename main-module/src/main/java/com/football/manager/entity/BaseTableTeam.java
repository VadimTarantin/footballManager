package com.football.manager.entity;

import java.util.Objects;

public abstract class BaseTableTeam implements TableTeam {

    protected String teamName;

    protected int totalMatches;
    protected int totalMatchesWon;
    protected int totalMatchesDrawn;
    protected int totalMatchesLost;
    protected int totalGoals;
    protected int totalMissed;

    protected int totalMatchesHome;
    protected int totalMatchesWonHome;
    protected int totalMatchesDrawnHome;
    protected int totalMatchesLostHome;
    protected int totalGoalsHome;
    protected int totalMissedHome;

    protected int totalMatchesAway;
    protected int totalMatchesWonAway;
    protected int totalMatchesDrawnAway;
    protected int totalMatchesLostAway;
    protected int totalGoalsAway;
    protected int totalMissedAway;

    protected int differenceGoalsMissed;
    protected int score;

    public BaseTableTeam() {
    }

    @Override
    public String getTeamName() {
        return teamName;
    }

    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public int getTotalMatches() {
        return totalMatches;
    }

    @Override
    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    @Override
    public int getTotalMatchesWon() {
        return totalMatchesWon;
    }

    @Override
    public void setTotalMatchesWon(int totalMatchesWon) {
        this.totalMatchesWon = totalMatchesWon;
    }

    @Override
    public int getTotalMatchesDrawn() {
        return totalMatchesDrawn;
    }

    @Override
    public void setTotalMatchesDrawn(int totalMatchesDrawn) {
        this.totalMatchesDrawn = totalMatchesDrawn;
    }

    @Override
    public int getTotalMatchesLost() {
        return totalMatchesLost;
    }

    @Override
    public void setTotalMatchesLost(int totalMatchesLost) {
        this.totalMatchesLost = totalMatchesLost;
    }

    @Override
    public int getTotalGoals() {
        return totalGoals;
    }

    @Override
    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }

    @Override
    public int getTotalMissed() {
        return totalMissed;
    }

    @Override
    public void setTotalMissed(int totalMissed) {
        this.totalMissed = totalMissed;
    }

    @Override
    public int getTotalMatchesHome() {
        return totalMatchesHome;
    }

    @Override
    public void setTotalMatchesHome(int totalMatchesHome) {
        this.totalMatchesHome = totalMatchesHome;
    }

    @Override
    public int getTotalMatchesWonHome() {
        return totalMatchesWonHome;
    }

    @Override
    public void setTotalMatchesWonHome(int totalMatchesWonHome) {
        this.totalMatchesWonHome = totalMatchesWonHome;
    }

    @Override
    public int getTotalMatchesDrawnHome() {
        return totalMatchesDrawnHome;
    }

    @Override
    public void setTotalMatchesDrawnHome(int totalMatchesDrawnHome) {
        this.totalMatchesDrawnHome = totalMatchesDrawnHome;
    }

    @Override
    public int getTotalMatchesLostHome() {
        return totalMatchesLostHome;
    }

    @Override
    public void setTotalMatchesLostHome(int totalMatchesLostHome) {
        this.totalMatchesLostHome = totalMatchesLostHome;
    }

    @Override
    public int getTotalGoalsHome() {
        return totalGoalsHome;
    }

    @Override
    public void setTotalGoalsHome(int totalGoalsHome) {
        this.totalGoalsHome = totalGoalsHome;
    }

    @Override
    public int getTotalMissedHome() {
        return totalMissedHome;
    }

    @Override
    public void setTotalMissedHome(int totalMissedHome) {
        this.totalMissedHome = totalMissedHome;
    }

    @Override
    public int getTotalMatchesAway() {
        return totalMatchesAway;
    }

    @Override
    public void setTotalMatchesAway(int totalMatchesAway) {
        this.totalMatchesAway = totalMatchesAway;
    }

    @Override
    public int getTotalMatchesWonAway() {
        return totalMatchesWonAway;
    }

    @Override
    public void setTotalMatchesWonAway(int totalMatchesWonAway) {
        this.totalMatchesWonAway = totalMatchesWonAway;
    }

    @Override
    public int getTotalMatchesDrawnAway() {
        return totalMatchesDrawnAway;
    }

    @Override
    public void setTotalMatchesDrawnAway(int totalMatchesDrawnAway) {
        this.totalMatchesDrawnAway = totalMatchesDrawnAway;
    }

    @Override
    public int getTotalMatchesLostAway() {
        return totalMatchesLostAway;
    }

    @Override
    public void setTotalMatchesLostAway(int totalMatchesLostAway) {
        this.totalMatchesLostAway = totalMatchesLostAway;
    }

    @Override
    public int getTotalGoalsAway() {
        return totalGoalsAway;
    }

    @Override
    public void setTotalGoalsAway(int totalGoalsAway) {
        this.totalGoalsAway = totalGoalsAway;
    }

    @Override
    public int getTotalMissedAway() {
        return totalMissedAway;
    }

    @Override
    public void setTotalMissedAway(int totalMissedAway) {
        this.totalMissedAway = totalMissedAway;
    }

    @Override
    public int getDifferenceGoalsMissed() {
        return differenceGoalsMissed;
    }

    @Override
    public void setDifferenceGoalsMissed(int differenceGoalsMissed) {
        this.differenceGoalsMissed = differenceGoalsMissed;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "BaseTableTeam{" +
                ", teamName='" + teamName + '\'' +
                ", totalMatches=" + totalMatches +
                ", totalMatchesWon=" + totalMatchesWon +
                ", totalMatchesDrawn=" + totalMatchesDrawn +
                ", totalMatchesLost=" + totalMatchesLost +
                ", totalGoals=" + totalGoals +
                ", totalMissed=" + totalMissed +
                ", totalMatchesHome=" + totalMatchesHome +
                ", totalMatchesWonHome=" + totalMatchesWonHome +
                ", totalMatchesDrawnHome=" + totalMatchesDrawnHome +
                ", totalMatchesLostHome=" + totalMatchesLostHome +
                ", totalGoalsHome=" + totalGoalsHome +
                ", totalMissedHome=" + totalMissedHome +
                ", totalMatchesAway=" + totalMatchesAway +
                ", totalMatchesWonAway=" + totalMatchesWonAway +
                ", totalMatchesDrawnAway=" + totalMatchesDrawnAway +
                ", totalMatchesLostAway=" + totalMatchesLostAway +
                ", totalGoalsAway=" + totalGoalsAway +
                ", totalMissedAway=" + totalMissedAway +
                ", differenceGoalsMissed=" + differenceGoalsMissed +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseTableTeam that = (BaseTableTeam) o;
        return totalMatches == that.totalMatches &&
                totalMatchesWon == that.totalMatchesWon &&
                totalMatchesDrawn == that.totalMatchesDrawn &&
                totalMatchesLost == that.totalMatchesLost &&
                totalGoals == that.totalGoals &&
                totalMissed == that.totalMissed &&
                totalMatchesHome == that.totalMatchesHome &&
                totalMatchesWonHome == that.totalMatchesWonHome &&
                totalMatchesDrawnHome == that.totalMatchesDrawnHome &&
                totalMatchesLostHome == that.totalMatchesLostHome &&
                totalGoalsHome == that.totalGoalsHome &&
                totalMissedHome == that.totalMissedHome &&
                totalMatchesAway == that.totalMatchesAway &&
                totalMatchesWonAway == that.totalMatchesWonAway &&
                totalMatchesDrawnAway == that.totalMatchesDrawnAway &&
                totalMatchesLostAway == that.totalMatchesLostAway &&
                totalGoalsAway == that.totalGoalsAway &&
                totalMissedAway == that.totalMissedAway &&
                differenceGoalsMissed == that.differenceGoalsMissed &&
                score == that.score &&
                Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, totalMatches, totalMatchesWon, totalMatchesDrawn, totalMatchesLost, totalGoals, totalMissed, totalMatchesHome, totalMatchesWonHome, totalMatchesDrawnHome, totalMatchesLostHome, totalGoalsHome, totalMissedHome, totalMatchesAway, totalMatchesWonAway, totalMatchesDrawnAway, totalMatchesLostAway, totalGoalsAway, totalMissedAway, differenceGoalsMissed, score);
    }

    @Override
    public int compareTo(TableTeam o) {
        return this.teamName.compareTo(o.getTeamName());
    }

}
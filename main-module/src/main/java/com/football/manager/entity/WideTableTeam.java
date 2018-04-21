package com.football.manager.entity;

public class WideTableTeam implements TableTeam {

    private String wideTableName;

    private String teamName;

    private int totalMatches;
    private int totalMatchesWon;
    private int totalMatchesDrawn;
    private int totalMatchesLost;
    private int totalGoals;
    private int totalMissed;

    private int totalMatchesHome;
    private int totalMatchesWonHome;
    private int totalMatchesDrawnHome;
    private int totalMatchesLostHome;
    private int totalGoalsHome;
    private int totalMissedHome;

    private int totalMatchesAway;
    private int totalMatchesWonAway;
    private int totalMatchesDrawnAway;
    private int totalMatchesLostAway;
    private int totalGoalsAway;
    private int totalMissedAway;

    private int differenceGoalsMissed;
    private int score;

    public WideTableTeam() {
    }

    public String getWideTableName() {
        return wideTableName;
    }

    public void setWideTableName(String wideTableName) {
        this.wideTableName = wideTableName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public int getTotalMatchesWon() {
        return totalMatchesWon;
    }

    public void setTotalMatchesWon(int totalMatchesWon) {
        this.totalMatchesWon = totalMatchesWon;
    }

    public int getTotalMatchesDrawn() {
        return totalMatchesDrawn;
    }

    public void setTotalMatchesDrawn(int totalMatchesDrawn) {
        this.totalMatchesDrawn = totalMatchesDrawn;
    }

    public int getTotalMatchesLost() {
        return totalMatchesLost;
    }

    public void setTotalMatchesLost(int totalMatchesLost) {
        this.totalMatchesLost = totalMatchesLost;
    }

    public int getTotalGoals() {
        return totalGoals;
    }

    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }

    public int getTotalMissed() {
        return totalMissed;
    }

    public void setTotalMissed(int totalMissed) {
        this.totalMissed = totalMissed;
    }

    public int getTotalMatchesHome() {
        return totalMatchesHome;
    }

    public void setTotalMatchesHome(int totalMatchesHome) {
        this.totalMatchesHome = totalMatchesHome;
    }

    public int getTotalMatchesWonHome() {
        return totalMatchesWonHome;
    }

    public void setTotalMatchesWonHome(int totalMatchesWonHome) {
        this.totalMatchesWonHome = totalMatchesWonHome;
    }

    public int getTotalMatchesDrawnHome() {
        return totalMatchesDrawnHome;
    }

    public void setTotalMatchesDrawnHome(int totalMatchesDrawnHome) {
        this.totalMatchesDrawnHome = totalMatchesDrawnHome;
    }

    public int getTotalMatchesLostHome() {
        return totalMatchesLostHome;
    }

    public void setTotalMatchesLostHome(int totalMatchesLostHome) {
        this.totalMatchesLostHome = totalMatchesLostHome;
    }

    public int getTotalGoalsHome() {
        return totalGoalsHome;
    }

    public void setTotalGoalsHome(int totalGoalsHome) {
        this.totalGoalsHome = totalGoalsHome;
    }

    public int getTotalMissedHome() {
        return totalMissedHome;
    }

    public void setTotalMissedHome(int totalMissedHome) {
        this.totalMissedHome = totalMissedHome;
    }

    public int getTotalMatchesAway() {
        return totalMatchesAway;
    }

    public void setTotalMatchesAway(int totalMatchesAway) {
        this.totalMatchesAway = totalMatchesAway;
    }

    public int getTotalMatchesWonAway() {
        return totalMatchesWonAway;
    }

    public void setTotalMatchesWonAway(int totalMatchesWonAway) {
        this.totalMatchesWonAway = totalMatchesWonAway;
    }

    public int getTotalMatchesDrawnAway() {
        return totalMatchesDrawnAway;
    }

    public void setTotalMatchesDrawnAway(int totalMatchesDrawnAway) {
        this.totalMatchesDrawnAway = totalMatchesDrawnAway;
    }

    public int getTotalMatchesLostAway() {
        return totalMatchesLostAway;
    }

    public void setTotalMatchesLostAway(int totalMatchesLostAway) {
        this.totalMatchesLostAway = totalMatchesLostAway;
    }

    public int getTotalGoalsAway() {
        return totalGoalsAway;
    }

    public void setTotalGoalsAway(int totalGoalsAway) {
        this.totalGoalsAway = totalGoalsAway;
    }

    public int getTotalMissedAway() {
        return totalMissedAway;
    }

    public void setTotalMissedAway(int totalMissedAway) {
        this.totalMissedAway = totalMissedAway;
    }

    public int getDifferenceGoalsMissed() {
        return differenceGoalsMissed;
    }

    public void setDifferenceGoalsMissed(int differenceGoalsMissed) {
        this.differenceGoalsMissed = differenceGoalsMissed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "WideTableTeam{" +
                "wideTableName='" + wideTableName + '\'' +
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

}
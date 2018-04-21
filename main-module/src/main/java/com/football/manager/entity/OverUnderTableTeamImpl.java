package com.football.manager.entity;

public class OverUnderTableTeamImpl implements OverUnderTableTeam {

    protected String overUnderTableName;

    protected String teamName;

    protected int totalMatches;
    protected int zeroGoals;
    protected Integer oneGoals;
    protected Integer twoGoals;
    protected Integer threeGoals;
    protected Integer fourGoals;
    protected Integer fiveGoals;
    protected Integer sixGoals;
    protected Integer sevenGoals;
    protected Integer moThenSevenGoals;
    protected float averageGoals;

    public OverUnderTableTeamImpl() {
    }

    public String getOverUnderTableName() {
        return overUnderTableName;
    }

    public void setOverUnderTableName(String overUnderTableName) {
        this.overUnderTableName = overUnderTableName;
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

    public int getZeroGoals() {
        return zeroGoals;
    }

    public void setZeroGoals(int zeroGoals) {
        this.zeroGoals = zeroGoals;
    }

    public Integer getOneGoals() {
        return oneGoals;
    }

    public void setOneGoals(int oneGoals) {
        this.oneGoals = oneGoals;
    }

    public Integer getTwoGoals() {
        return twoGoals;
    }

    public void setTwoGoals(int twoGoals) {
        this.twoGoals = twoGoals;
    }

    public Integer getThreeGoals() {
        return threeGoals;
    }

    public void setThreeGoals(int threeGoals) {
        this.threeGoals = threeGoals;
    }

    public Integer getFourGoals() {
        return fourGoals;
    }

    public void setFourGoals(int fourGoals) {
        this.fourGoals = fourGoals;
    }

    public Integer getFiveGoals() {
        return fiveGoals;
    }

    public void setFiveGoals(int fiveGoals) {
        this.fiveGoals = fiveGoals;
    }

    public Integer getSixGoals() {
        return sixGoals;
    }

    public void setSixGoals(int sixGoals) {
        this.sixGoals = sixGoals;
    }

    public Integer getSevenGoals() {
        return sevenGoals;
    }

    public void setSevenGoals(int sevenGoals) {
        this.sevenGoals = sevenGoals;
    }

    public Integer getMoreThenSevenGoals() {
        return moThenSevenGoals;
    }

    public void setMoreThenSevenGoals(int moThenSevenGoals) {
        this.moThenSevenGoals = moThenSevenGoals;
    }

    public float getAverageGoals() {
        return averageGoals;
    }

    public void setAverageGoals(float averageGoals) {
        this.averageGoals = averageGoals;
    }

    @Override
    public String toString() {
        return "OverUnderTableTeamImpl{" +
                "overUnderTableName='" + overUnderTableName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", totalMatches=" + totalMatches +
                ", zeroGoals=" + zeroGoals +
                ", oneGoals=" + oneGoals +
                ", twoGoals=" + twoGoals +
                ", threeGoals=" + threeGoals +
                ", fourGoals=" + fourGoals +
                ", fiveGoals=" + fiveGoals +
                ", sixGoals=" + sixGoals +
                ", sevenGoals=" + sevenGoals +
                ", moThenSevenGoals=" + moThenSevenGoals +
                ", averageGoals=" + averageGoals +
                '}';
    }

}
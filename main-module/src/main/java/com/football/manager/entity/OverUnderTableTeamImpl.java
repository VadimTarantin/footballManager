package com.football.manager.entity;

import java.util.Objects;

public class OverUnderTableTeamImpl implements OverUnderTableTeam {

    protected String teamName;

    protected int totalMatches;
    protected int zeroGoals;
    protected Integer oneGoal;
    protected Integer twoGoals;
    protected Integer threeGoals;
    protected Integer fourGoals;
    protected Integer fiveGoals;
    protected Integer sixGoals;
    protected Integer sevenGoals;
    protected Integer moreThenSevenGoals;
    protected float averageGoals;

    public OverUnderTableTeamImpl() {
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

    public Integer getOneGoal() {
        return oneGoal;
    }

    public void setOneGoal(int oneGoal) {
        this.oneGoal = oneGoal;
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
        return moreThenSevenGoals;
    }

    public void setMoreThenSevenGoals(int moThenSevenGoals) {
        this.moreThenSevenGoals = moThenSevenGoals;
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
                ", teamName='" + teamName + '\'' +
                ", totalMatches=" + totalMatches +
                ", zeroGoals=" + zeroGoals +
                ", oneGoal=" + oneGoal +
                ", twoGoals=" + twoGoals +
                ", threeGoals=" + threeGoals +
                ", fourGoals=" + fourGoals +
                ", fiveGoals=" + fiveGoals +
                ", sixGoals=" + sixGoals +
                ", sevenGoals=" + sevenGoals +
                ", moreThenSevenGoals=" + moreThenSevenGoals +
                ", averageGoals=" + averageGoals +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OverUnderTableTeamImpl that = (OverUnderTableTeamImpl) o;
        return totalMatches == that.totalMatches &&
                zeroGoals == that.zeroGoals &&
                Float.compare(that.averageGoals, averageGoals) == 0 &&
                Objects.equals(teamName, that.teamName) &&
                Objects.equals(oneGoal, that.oneGoal) &&
                Objects.equals(twoGoals, that.twoGoals) &&
                Objects.equals(threeGoals, that.threeGoals) &&
                Objects.equals(fourGoals, that.fourGoals) &&
                Objects.equals(fiveGoals, that.fiveGoals) &&
                Objects.equals(sixGoals, that.sixGoals) &&
                Objects.equals(sevenGoals, that.sevenGoals) &&
                Objects.equals(moreThenSevenGoals, that.moreThenSevenGoals);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teamName, totalMatches, zeroGoals, oneGoal, twoGoals, threeGoals, fourGoals, fiveGoals, sixGoals, sevenGoals, moreThenSevenGoals, averageGoals);
    }

}
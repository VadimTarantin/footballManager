package com.football.manager.entity;

public interface OverUnderTableTeam extends Comparable<OverUnderTableTeam> {

    String getTeamName();
    void setTeamName(String teamName);

    int getTotalMatches();
    void setTotalMatches(int totalMatches);

    int getZeroGoals();
    void setZeroGoals(int zeroGoals);

    Integer getOneGoal();
    void setOneGoal(Integer oneGoal);

    Integer getTwoGoals();
    void setTwoGoals(Integer twoGoals);

    Integer getThreeGoals();
    void setThreeGoals(Integer threeGoals);

    Integer getFourGoals();
    void setFourGoals(Integer fourGoals);

    Integer getFiveGoals();
    void setFiveGoals(Integer fiveGoals);

    Integer getSixGoals();
    void setSixGoals(Integer sixGoals);

    Integer getSevenGoals();
    void setSevenGoals(Integer sevenGoals);

    Integer getMoreThenSevenGoals();
    void setMoreThenSevenGoals(Integer moreThenSevenGoals);

    float getAverageGoals();
    void setAverageGoals(float averageGoals);

}
package com.football.manager.entity;

public interface OverUnderTableTeam {

    String getOverUnderTableName();
    void setOverUnderTableName(String overUnderTableName);

    String getTeamName();
    void setTeamName(String teamName);

    int getTotalMatches();
    void setTotalMatches(int totalMatches);

    int getZeroGoals();
    void setZeroGoals(int zeroGoals);

    Integer getOneGoals();
    void setOneGoals(int oneGoals);

    Integer getTwoGoals();
    void setTwoGoals(int twoGoals);

    Integer getThreeGoals();
    void setThreeGoals(int threeGoals);

    Integer getFourGoals();
    void setFourGoals(int fourGoals);

    Integer getFiveGoals();
    void setFiveGoals(int fiveGoals);

    Integer getSixGoals();
    void setSixGoals(int sixGoals);

    Integer getSevenGoals();
    void setSevenGoals(int sevenGoals);

    Integer getMoreThenSevenGoals();
    void setMoreThenSevenGoals(int moThenSevenGoals);

    float getAverageGoals();
    void setAverageGoals(float averageGoals);

}
package com.football.manager.entity;

public interface TableTeam {

    String getTeamName();
    void setTeamName(String teamName);

    int getTotalMatches();
    void setTotalMatches(int totalMatches);

    int getTotalMatchesWon();
    void setTotalMatchesWon(int totalMatchesWon);

    int getTotalMatchesDrawn();
    void setTotalMatchesDrawn(int totalMatchesDrawn);

    int getTotalMatchesLost();
    void setTotalMatchesLost(int totalMatchesLost);

    int getTotalGoals();
    void setTotalGoals(int totalGoals);

    int getTotalMissed();
    void setTotalMissed(int totalMissed);

    int getTotalMatchesHome();
    void setTotalMatchesHome(int totalMatchesHome);

    int getTotalMatchesWonHome();
    void setTotalMatchesWonHome(int totalMatchesWonHome);

    int getTotalMatchesDrawnHome();
    void setTotalMatchesDrawnHome(int totalMatchesDrawnHome);

    int getTotalMatchesLostHome();
    void setTotalMatchesLostHome(int totalMatchesLostHome);

    int getTotalGoalsHome();
    void setTotalGoalsHome(int totalGoalsHome);

    int getTotalMissedHome();
    void setTotalMissedHome(int totalMissedHome);

    int getTotalMatchesAway();
    void setTotalMatchesAway(int totalMatchesAway);

    int getTotalMatchesWonAway();
    void setTotalMatchesWonAway(int totalMatchesWonAway);

    int getTotalMatchesDrawnAway();
    void setTotalMatchesDrawnAway(int totalMatchesDrawnAway);

    int getTotalMatchesLostAway();
    void setTotalMatchesLostAway(int totalMatchesLostAway);

    int getTotalGoalsAway();
    void setTotalGoalsAway(int totalGoalsAway);

    int getTotalMissedAway();
    void setTotalMissedAway(int totalMissedAway);

    int getDifferenceGoalsMissed();
    void setDifferenceGoalsMissed(int differenceGoalsMissed);

    int getScore();
    void setScore(int score);

}
package com.football.manager.service.handler;

import com.football.manager.entity.TableTeam;
import com.football.manager.util.ParserUtil;
import org.xml.sax.helpers.DefaultHandler;

public abstract class TableTeamParserHandler extends DefaultHandler {

    protected boolean td = false;
    protected String currentAttribute;

    protected static final String TOTAL_MATCHES = "number total mp";
    protected static final String TOTAL_MATCHES_WON = "number total won total_won";
    protected static final String TOTAL_MATCHES_DRAWN = "number total drawn total_drawn";
    protected static final String TOTAL_MATCHES_LOST = "number total lost total_lost";
    protected static final String TOTAL_GOALS = "number total gf total_gf";
    protected static final String TOTAL_MISSED = "number total ga total_ga";
    protected static final String TOTAL_MATCHES_HOME = "number home mp home_total";
    protected static final String TOTAL_MATCHES_WON_HOME = "number home won home_won";
    protected static final String TOTAL_MATCHES_DRAWN_HOME = "number home drawn home_drawn";
    protected static final String TOTAL_MATCHES_LOST_HOME = "number home lost home_lost";
    protected static final String TOTAL_GOALS_HOME = "number home gf home_gf";
    protected static final String TOTAL_MISSED_HOME = "number home ga home_ga";
    protected static final String TOTAL_MATCHES_AWAY = "number away mp away_total";
    protected static final String TOTAL_MATCHES_WON_AWAY = "number away won away_won";
    protected static final String TOTAL_MATCHES_DRAWN_AWAY = "number away drawn away_drawn";
    protected static final String TOTAL_MATCHES_LOST_AWAY = "number away lost away_lost";
    protected static final String TOTAL_GOALS_AWAY = "number away gf away_gf";
    protected static final String TOTAL_MISSED_AWAY = "number away ga away_ga";
    protected static final String DIFFERENCE_GOALS_MISSED = "number gd";
    protected static final String SCORE = "number points";

    protected void fillField(int value, TableTeam tableTeam) {
        switch (currentAttribute) {
            case TOTAL_MATCHES: tableTeam.setTotalMatches(value);
                break;
            case TOTAL_MATCHES_WON: tableTeam.setTotalMatchesWon(value);
                break;
            case TOTAL_MATCHES_DRAWN: tableTeam.setTotalMatchesDrawn(value);
                break;
            case TOTAL_MATCHES_LOST: tableTeam.setTotalMatchesLost(value);
                break;
            case TOTAL_GOALS: tableTeam.setTotalGoals(value);
                break;
            case TOTAL_MISSED: tableTeam.setTotalMissed(value);
                break;
            case TOTAL_MATCHES_HOME: tableTeam.setTotalMatchesHome(value);
                break;
            case TOTAL_MATCHES_WON_HOME: tableTeam.setTotalMatchesWonHome(value);
                break;
            case TOTAL_MATCHES_DRAWN_HOME: tableTeam.setTotalMatchesDrawnHome(value);
                break;
            case TOTAL_MATCHES_LOST_HOME: tableTeam.setTotalMatchesLostHome(value);
                break;
            case TOTAL_GOALS_HOME: tableTeam.setTotalGoalsHome(value);
                break;
            case TOTAL_MISSED_HOME: tableTeam.setTotalMissedHome(value);
                break;
            case TOTAL_MATCHES_AWAY: tableTeam.setTotalMatchesAway(value);
                break;
            case TOTAL_MATCHES_WON_AWAY: tableTeam.setTotalMatchesWonAway(value);
                break;
            case TOTAL_MATCHES_DRAWN_AWAY: tableTeam.setTotalMatchesDrawnAway(value);
                break;
            case TOTAL_MATCHES_LOST_AWAY: tableTeam.setTotalMatchesLostAway(value);
                break;
            case TOTAL_GOALS_AWAY: tableTeam.setTotalGoalsAway(value);
                break;
            case TOTAL_MISSED_AWAY: tableTeam.setTotalMissedAway(value);
                break;
            case DIFFERENCE_GOALS_MISSED: tableTeam.setDifferenceGoalsMissed(value);
                break;
            case SCORE: tableTeam.setScore(value);
                break;
        }
    }

    protected String decodeToUtf(String src) {
        if (!shouldDecodeToUtf(src)) {
            return src;
        }
        return ParserUtil.decodeToUtf(src);
    }

    protected boolean shouldDecodeToUtf(String src) {
        return ParserUtil.shouldDecodeToUtf(src);
    }

}
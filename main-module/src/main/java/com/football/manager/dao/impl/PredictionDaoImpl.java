package com.football.manager.dao.impl;

import com.football.manager.dao.PredictionDao;
import com.football.manager.entity.Prediction;
import org.springframework.stereotype.Component;

@Component
public class PredictionDaoImpl extends BaseDaoImpl implements PredictionDao {

    private static final String SELECT_PREDICTION_BY_PK = "SELECT COUNT(*) FROM PREDICTIONS WHERE EVENT_ID = ? AND TEAM_HOME_NAME = ? AND TEAM_AWAY_NAME = ?";
    private static final String INSERT_NEW_PREDICTION = "INSERT INTO PREDICTIONS (EVENT_ID, TEAM_HOME_NAME, TEAM_AWAY_NAME,\n" +
            "GOALS_FOR_GAME_FOR_ALL_GAMES_FOR_HOME_TEAM, MISSES_FOR_GAME_FOR_ALL_GAMES_FOR_HOME_TEAM, WONS_FOR_ALL_GAMES_FOR_HOME_TEAM, DRAWNS_FOR_ALL_GAMES_FOR_HOME_TEAM,\n" +
            "LOSTS_FOR_ALL_GAMES_FOR_HOME_TEAM, TOTAL_FOR_MATCH_FOR_ALL_GAMES_FOR_HOME_TEAM,\n" +
            "GAMES_TB_2_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM, GAMES_TM_2_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM, GAMES_TB_1_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM, GAMES_TM_1_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM,\n" +
            "GOALS_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM, MISSES_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM, WONS_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM,\n" +
            "DRAWNS_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM, LOSTS_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM, TOTAL_FOR_MATCH_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM,\n" +
            "\n" +
            "GOALS_FOR_GAME_FOR_ALL_GAMES_FOR_AWAY_TEAM, MISSES_FOR_GAME_FOR_ALL_GAMES_FOR_AWAY_TEAM, WONS_FOR_ALL_GAMES_FOR_AWAY_TEAM, DRAWNS_FOR_ALL_GAMES_FOR_AWAY_TEAM,\n" +
            "LOSTS_FOR_ALL_GAMES_FOR_AWAY_TEAM, TOTAL_FOR_MATCH_FOR_ALL_GAMES_FOR_AWAY_TEAM,\n" +
            "GAMES_TB_2_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM, GAMES_TM_2_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM, GAMES_TB_1_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM, GAMES_TM_1_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM,\n" +
            "GOALS_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM, MISSES_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM, WONS_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM,\n" +
            "DRAWNS_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM, LOSTS_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM, TOTAL_FOR_MATCH_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM\n" +
            ")\n" +
            "VALUES (?, ?, ?,\n" +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,\n" +
            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_PREDICTION = "UPDATE PREDICTIONS\n" +
            "SET GOALS_FOR_GAME_FOR_ALL_GAMES_FOR_HOME_TEAM = ?, MISSES_FOR_GAME_FOR_ALL_GAMES_FOR_HOME_TEAM = ?,\n" +
            "WONS_FOR_ALL_GAMES_FOR_HOME_TEAM = ?, DRAWNS_FOR_ALL_GAMES_FOR_HOME_TEAM = ?,\n" +
            "LOSTS_FOR_ALL_GAMES_FOR_HOME_TEAM = ?, TOTAL_FOR_MATCH_FOR_ALL_GAMES_FOR_HOME_TEAM = ?,\n" +
            "GAMES_TB_2_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM = ?, GAMES_TM_2_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM = ?,\n" +
            "GAMES_TB_1_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM = ?, GAMES_TM_1_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM = ?,\n" +
            "GOALS_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM = ?, MISSES_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM = ?, WONS_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM = ?,\n" +
            "DRAWNS_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM = ?, LOSTS_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM = ?, TOTAL_FOR_MATCH_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM = ?,\n" +
            "\n" +
            "GOALS_FOR_GAME_FOR_ALL_GAMES_FOR_AWAY_TEAM = ?, MISSES_FOR_GAME_FOR_ALL_GAMES_FOR_AWAY_TEAM = ?, WONS_FOR_ALL_GAMES_FOR_AWAY_TEAM = ?,\n" +
            "DRAWNS_FOR_ALL_GAMES_FOR_AWAY_TEAM = ?, LOSTS_FOR_ALL_GAMES_FOR_AWAY_TEAM = ?, TOTAL_FOR_MATCH_FOR_ALL_GAMES_FOR_AWAY_TEAM = ?,\n" +
            "GAMES_TB_2_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM = ?, GAMES_TM_2_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM = ?,\n" +
            "GAMES_TB_1_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM = ?, GAMES_TM_1_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM = ?,\n" +
            "GOALS_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM = ?, MISSES_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM = ?, WONS_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM = ?,\n" +
            "DRAWNS_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM = ?, LOSTS_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM = ?, TOTAL_FOR_MATCH_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM = ?\n" +
            "\n" +
            "WHERE EVENT_ID = ? AND TEAM_HOME_NAME = ? AND TEAM_AWAY_NAME = ?;";

    @Override
    public void add(Prediction prediction) {
        jdbcTemplate.update(INSERT_NEW_PREDICTION, ps -> {
            //pk
            ps.setInt(1, prediction.getEventId());
            ps.setString(2, prediction.getTeamHomeName());
            ps.setString(3, prediction.getTeamAwayName());

            //home team
            ps.setFloat(4, prediction.getGoalsForGameForAllGamesForHomeTeam());
            ps.setFloat(5, prediction.getMissesForGameForAllGamesForHomeTeam());
            ps.setFloat(6, prediction.getWonsForAllGamesForHomeTeam());
            ps.setFloat(7, prediction.getDrawnsForAllGamesForHomeTeam());
            ps.setFloat(8, prediction.getLostsForAllGamesForHomeTeam());
            ps.setFloat(9, prediction.getTotalForMatchForAllGamesForHomeTeam());
            ps.setFloat(10, prediction.getGamesTb2Point5ForAllGamesForHomeTeam());
            ps.setFloat(11, prediction.getGamesTm2Point5ForAllGamesForHomeTeam());
            ps.setFloat(12, prediction.getGamesTb1Point5ForAllGamesForHomeTeam());
            ps.setFloat(13, prediction.getGamesTm1Point5ForAllGamesForHomeTeam());
            ps.setFloat(14, prediction.getGoalsForGameForLastThreeGamesForHomeTeam());
            ps.setFloat(15, prediction.getMissesForGameForLastThreeGamesForHomeTeam());
            ps.setFloat(16, prediction.getWonsForLastThreeGamesForHomeTeam());
            ps.setFloat(17, prediction.getDrawnsForLastThreeGamesForHomeTeam());
            ps.setFloat(19, prediction.getLostsForLastThreeGamesForHomeTeam());
            ps.setFloat(20, prediction.getTotalForMatchForLastThreeGamesForHomeTeam());

            //away team
            ps.setFloat(21, prediction.getGoalsForGameForAllGamesForAwayTeam());
            ps.setFloat(22, prediction.getMissesForGameForAllGamesForAwayTeam());
            ps.setFloat(23, prediction.getWonsForAllGamesForAwayTeam());
            ps.setFloat(24, prediction.getDrawnsForAllGamesForAwayTeam());
            ps.setFloat(25, prediction.getLostsForAllGamesForAwayTeam());
            ps.setFloat(26, prediction.getTotalForMatchForAllGamesForAwayTeam());
            ps.setFloat(27, prediction.getGamesTb2Point5ForAllGamesForAwayTeam());
            ps.setFloat(28, prediction.getGamesTm2Point5ForAllGamesForAwayTeam());
            ps.setFloat(29, prediction.getGamesTb1Point5ForAllGamesForAwayTeam());
            ps.setFloat(30, prediction.getGamesTm1Point5ForAllGamesForAwayTeam());
            ps.setFloat(31, prediction.getGoalsForGameForLastThreeGamesForAwayTeam());
            ps.setFloat(32, prediction.getMissesForGameForLastThreeGamesForAwayTeam());
            ps.setFloat(33, prediction.getWonsForLastThreeGamesForAwayTeam());
            ps.setFloat(34, prediction.getDrawnsForLastThreeGamesForAwayTeam());
            ps.setFloat(35, prediction.getLostsForLastThreeGamesForAwayTeam());
            ps.setFloat(36, prediction.getTotalForMatchForLastThreeGamesForAwayTeam());
        });
    }

    @Override
    public void update(Prediction prediction) {
        jdbcTemplate.update(UPDATE_PREDICTION, ps -> {
            //home team
            ps.setFloat(4, prediction.getGoalsForGameForAllGamesForHomeTeam());
            ps.setFloat(5, prediction.getMissesForGameForAllGamesForHomeTeam());
            ps.setFloat(6, prediction.getWonsForAllGamesForHomeTeam());
            ps.setFloat(7, prediction.getDrawnsForAllGamesForHomeTeam());
            ps.setFloat(8, prediction.getLostsForAllGamesForHomeTeam());
            ps.setFloat(9, prediction.getTotalForMatchForAllGamesForHomeTeam());
            ps.setFloat(10, prediction.getGamesTb2Point5ForAllGamesForHomeTeam());
            ps.setFloat(11, prediction.getGamesTm2Point5ForAllGamesForHomeTeam());
            ps.setFloat(12, prediction.getGamesTb1Point5ForAllGamesForHomeTeam());
            ps.setFloat(13, prediction.getGamesTm1Point5ForAllGamesForHomeTeam());
            ps.setFloat(14, prediction.getGoalsForGameForLastThreeGamesForHomeTeam());
            ps.setFloat(15, prediction.getMissesForGameForLastThreeGamesForHomeTeam());
            ps.setFloat(16, prediction.getWonsForLastThreeGamesForHomeTeam());
            ps.setFloat(17, prediction.getDrawnsForLastThreeGamesForHomeTeam());
            ps.setFloat(19, prediction.getLostsForLastThreeGamesForHomeTeam());
            ps.setFloat(20, prediction.getTotalForMatchForLastThreeGamesForHomeTeam());

            //away team
            ps.setFloat(21, prediction.getGoalsForGameForAllGamesForAwayTeam());
            ps.setFloat(22, prediction.getMissesForGameForAllGamesForAwayTeam());
            ps.setFloat(23, prediction.getWonsForAllGamesForAwayTeam());
            ps.setFloat(24, prediction.getDrawnsForAllGamesForAwayTeam());
            ps.setFloat(25, prediction.getLostsForAllGamesForAwayTeam());
            ps.setFloat(26, prediction.getTotalForMatchForAllGamesForAwayTeam());
            ps.setFloat(27, prediction.getGamesTb2Point5ForAllGamesForAwayTeam());
            ps.setFloat(28, prediction.getGamesTm2Point5ForAllGamesForAwayTeam());
            ps.setFloat(29, prediction.getGamesTb1Point5ForAllGamesForAwayTeam());
            ps.setFloat(30, prediction.getGamesTm1Point5ForAllGamesForAwayTeam());
            ps.setFloat(31, prediction.getGoalsForGameForLastThreeGamesForAwayTeam());
            ps.setFloat(32, prediction.getMissesForGameForLastThreeGamesForAwayTeam());
            ps.setFloat(33, prediction.getWonsForLastThreeGamesForAwayTeam());
            ps.setFloat(34, prediction.getDrawnsForLastThreeGamesForAwayTeam());
            ps.setFloat(35, prediction.getLostsForLastThreeGamesForAwayTeam());
            ps.setFloat(36, prediction.getTotalForMatchForLastThreeGamesForAwayTeam());

            //pk
            ps.setInt(1, prediction.getEventId());
            ps.setString(2, prediction.getTeamHomeName());
            ps.setString(3, prediction.getTeamAwayName());
        });
    }

    @Override
    public boolean exists(Prediction prediction) {
        Integer rows = jdbcTemplate.queryForObject(SELECT_PREDICTION_BY_PK, Integer.class,
                prediction.getEventId(), prediction.getTeamHomeName(), prediction.getTeamAwayName());
        return rows != null && rows > 0;
    }

}
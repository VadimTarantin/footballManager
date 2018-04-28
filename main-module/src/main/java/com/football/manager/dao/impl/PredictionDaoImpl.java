package com.football.manager.dao.impl;

import com.football.manager.dao.PredictionDao;
import com.football.manager.entity.Prediction;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
    private static final String SELECT_ALL_PREDICTIONS = "SELECT EVENT_ID, TEAM_HOME_NAME, TEAM_AWAY_NAME,\n" +
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
            "FROM PREDICTIONS;";

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
            ps.setFloat(18, prediction.getLostsForLastThreeGamesForHomeTeam());
            ps.setFloat(19, prediction.getTotalForMatchForLastThreeGamesForHomeTeam());

            //away team
            ps.setFloat(20, prediction.getGoalsForGameForAllGamesForAwayTeam());
            ps.setFloat(21, prediction.getMissesForGameForAllGamesForAwayTeam());
            ps.setFloat(22, prediction.getWonsForAllGamesForAwayTeam());
            ps.setFloat(23, prediction.getDrawnsForAllGamesForAwayTeam());
            ps.setFloat(24, prediction.getLostsForAllGamesForAwayTeam());
            ps.setFloat(25, prediction.getTotalForMatchForAllGamesForAwayTeam());
            ps.setFloat(26, prediction.getGamesTb2Point5ForAllGamesForAwayTeam());
            ps.setFloat(27, prediction.getGamesTm2Point5ForAllGamesForAwayTeam());
            ps.setFloat(28, prediction.getGamesTb1Point5ForAllGamesForAwayTeam());
            ps.setFloat(29, prediction.getGamesTm1Point5ForAllGamesForAwayTeam());
            ps.setFloat(30, prediction.getGoalsForGameForLastThreeGamesForAwayTeam());
            ps.setFloat(31, prediction.getMissesForGameForLastThreeGamesForAwayTeam());
            ps.setFloat(32, prediction.getWonsForLastThreeGamesForAwayTeam());
            ps.setFloat(33, prediction.getDrawnsForLastThreeGamesForAwayTeam());
            ps.setFloat(34, prediction.getLostsForLastThreeGamesForAwayTeam());
            ps.setFloat(35, prediction.getTotalForMatchForLastThreeGamesForAwayTeam());
        });
    }

    @Override
    public void update(Prediction prediction) {
        jdbcTemplate.update(UPDATE_PREDICTION, ps -> {
            //home team
            ps.setFloat(1, prediction.getGoalsForGameForAllGamesForHomeTeam());
            ps.setFloat(2, prediction.getMissesForGameForAllGamesForHomeTeam());
            ps.setFloat(3, prediction.getWonsForAllGamesForHomeTeam());
            ps.setFloat(4, prediction.getDrawnsForAllGamesForHomeTeam());
            ps.setFloat(5, prediction.getLostsForAllGamesForHomeTeam());
            ps.setFloat(6, prediction.getTotalForMatchForAllGamesForHomeTeam());
            ps.setFloat(7, prediction.getGamesTb2Point5ForAllGamesForHomeTeam());
            ps.setFloat(8, prediction.getGamesTm2Point5ForAllGamesForHomeTeam());
            ps.setFloat(9, prediction.getGamesTb1Point5ForAllGamesForHomeTeam());
            ps.setFloat(10, prediction.getGamesTm1Point5ForAllGamesForHomeTeam());
            ps.setFloat(11, prediction.getGoalsForGameForLastThreeGamesForHomeTeam());
            ps.setFloat(12, prediction.getMissesForGameForLastThreeGamesForHomeTeam());
            ps.setFloat(13, prediction.getWonsForLastThreeGamesForHomeTeam());
            ps.setFloat(14, prediction.getDrawnsForLastThreeGamesForHomeTeam());
            ps.setFloat(15, prediction.getLostsForLastThreeGamesForHomeTeam());
            ps.setFloat(16, prediction.getTotalForMatchForLastThreeGamesForHomeTeam());

            //away team
            ps.setFloat(17, prediction.getGoalsForGameForAllGamesForAwayTeam());
            ps.setFloat(18, prediction.getMissesForGameForAllGamesForAwayTeam());
            ps.setFloat(19, prediction.getWonsForAllGamesForAwayTeam());
            ps.setFloat(20, prediction.getDrawnsForAllGamesForAwayTeam());
            ps.setFloat(21, prediction.getLostsForAllGamesForAwayTeam());
            ps.setFloat(22, prediction.getTotalForMatchForAllGamesForAwayTeam());
            ps.setFloat(23, prediction.getGamesTb2Point5ForAllGamesForAwayTeam());
            ps.setFloat(24, prediction.getGamesTm2Point5ForAllGamesForAwayTeam());
            ps.setFloat(25, prediction.getGamesTb1Point5ForAllGamesForAwayTeam());
            ps.setFloat(26, prediction.getGamesTm1Point5ForAllGamesForAwayTeam());
            ps.setFloat(27, prediction.getGoalsForGameForLastThreeGamesForAwayTeam());
            ps.setFloat(28, prediction.getMissesForGameForLastThreeGamesForAwayTeam());
            ps.setFloat(29, prediction.getWonsForLastThreeGamesForAwayTeam());
            ps.setFloat(30, prediction.getDrawnsForLastThreeGamesForAwayTeam());
            ps.setFloat(31, prediction.getLostsForLastThreeGamesForAwayTeam());
            ps.setFloat(32, prediction.getTotalForMatchForLastThreeGamesForAwayTeam());

            //pk
            ps.setInt(33, prediction.getEventId());
            ps.setString(34, prediction.getTeamHomeName());
            ps.setString(35, prediction.getTeamAwayName());
        });
    }

    @Override
    public boolean exists(Prediction prediction) {
        Integer rows = jdbcTemplate.queryForObject(SELECT_PREDICTION_BY_PK, Integer.class,
                prediction.getEventId(), prediction.getTeamHomeName(), prediction.getTeamAwayName());
        return rows != null && rows > 0;
    }

    @Override
    public List<Prediction> getAll() {
        return jdbcTemplate.query(SELECT_ALL_PREDICTIONS, (rs, rowNum) -> {
            Prediction result = new Prediction();
            fillPrediction(rs, result);
            return result;
        });
    }

    private void fillPrediction(ResultSet rs, Prediction result) throws SQLException {
        //pk
        result.setEventId(rs.getInt("EVENT_ID"));
        result.setTeamHomeName(rs.getString("TEAM_HOME_NAME"));
        result.setTeamAwayName(rs.getString("TEAM_AWAY_NAME"));

        //home
        result.setGoalsForGameForAllGamesForHomeTeam(rs.getFloat("GOALS_FOR_GAME_FOR_ALL_GAMES_FOR_HOME_TEAM"));
        result.setMissesForGameForAllGamesForHomeTeam(rs.getFloat("MISSES_FOR_GAME_FOR_ALL_GAMES_FOR_HOME_TEAM"));
        result.setWonsForAllGamesForHomeTeam(rs.getFloat("WONS_FOR_ALL_GAMES_FOR_HOME_TEAM"));
        result.setDrawnsForAllGamesForHomeTeam(rs.getFloat("DRAWNS_FOR_ALL_GAMES_FOR_HOME_TEAM"));
        result.setLostsForAllGamesForHomeTeam(rs.getFloat("LOSTS_FOR_ALL_GAMES_FOR_HOME_TEAM"));
        result.setTotalForMatchForAllGamesForHomeTeam(rs.getFloat("TOTAL_FOR_MATCH_FOR_ALL_GAMES_FOR_HOME_TEAM"));
        result.setGamesTb2Point5ForAllGamesForHomeTeam(rs.getFloat("GAMES_TB_2_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM"));
        result.setGamesTm2Point5ForAllGamesForHomeTeam(rs.getFloat("GAMES_TM_2_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM"));
        result.setGamesTb1Point5ForAllGamesForHomeTeam(rs.getFloat("GAMES_TB_1_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM"));
        result.setGamesTm1Point5ForAllGamesForHomeTeam(rs.getFloat("GAMES_TM_1_POINT_5_FOR_ALL_GAMES_FOR_HOME_TEAM"));
        result.setGoalsForGameForLastThreeGamesForHomeTeam(rs.getFloat("GOALS_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM"));
        result.setMissesForGameForLastThreeGamesForHomeTeam(rs.getFloat("MISSES_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM"));
        result.setWonsForLastThreeGamesForHomeTeam(rs.getFloat("WONS_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM"));
        result.setDrawnsForLastThreeGamesForHomeTeam(rs.getFloat("DRAWNS_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM"));
        result.setLostsForLastThreeGamesForHomeTeam(rs.getFloat("LOSTS_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM"));
        result.setTotalForMatchForLastThreeGamesForHomeTeam(rs.getFloat("TOTAL_FOR_MATCH_FOR_LAST_THREE_GAMES_FOR_HOME_TEAM"));

        //away
        result.setGoalsForGameForAllGamesForAwayTeam(rs.getFloat("GOALS_FOR_GAME_FOR_ALL_GAMES_FOR_AWAY_TEAM"));
        result.setMissesForGameForAllGamesForAwayTeam(rs.getFloat("MISSES_FOR_GAME_FOR_ALL_GAMES_FOR_AWAY_TEAM"));
        result.setWonsForAllGamesForAwayTeam(rs.getFloat("WONS_FOR_ALL_GAMES_FOR_AWAY_TEAM"));
        result.setDrawnsForAllGamesForAwayTeam(rs.getFloat("DRAWNS_FOR_ALL_GAMES_FOR_AWAY_TEAM"));
        result.setLostsForAllGamesForAwayTeam(rs.getFloat("LOSTS_FOR_ALL_GAMES_FOR_AWAY_TEAM"));
        result.setTotalForMatchForAllGamesForAwayTeam(rs.getFloat("TOTAL_FOR_MATCH_FOR_ALL_GAMES_FOR_AWAY_TEAM"));
        result.setGamesTb2Point5ForAllGamesForAwayTeam(rs.getFloat("GAMES_TB_2_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM"));
        result.setGamesTm2Point5ForAllGamesForAwayTeam(rs.getFloat("GAMES_TM_2_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM"));
        result.setGamesTb1Point5ForAllGamesForAwayTeam(rs.getFloat("GAMES_TB_1_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM"));
        result.setGamesTm1Point5ForAllGamesForAwayTeam(rs.getFloat("GAMES_TM_1_POINT_5_FOR_ALL_GAMES_FOR_AWAY_TEAM"));
        result.setGoalsForGameForLastThreeGamesForAwayTeam(rs.getFloat("GOALS_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM"));
        result.setMissesForGameForLastThreeGamesForAwayTeam(rs.getFloat("MISSES_FOR_GAME_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM"));
        result.setWonsForLastThreeGamesForAwayTeam(rs.getFloat("WONS_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM"));
        result.setDrawnsForLastThreeGamesForAwayTeam(rs.getFloat("DRAWNS_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM"));
        result.setLostsForLastThreeGamesForAwayTeam(rs.getFloat("LOSTS_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM"));
        result.setTotalForMatchForLastThreeGamesForAwayTeam(rs.getFloat("TOTAL_FOR_MATCH_FOR_LAST_THREE_GAMES_FOR_AWAY_TEAM"));
    }

}
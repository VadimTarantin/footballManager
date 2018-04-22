package com.football.manager.dao;

import com.football.manager.entity.Prediction;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class DatabaseCheck {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    private static final String SELECT_ALL = "SELECT t.ID, t.SESSION_ID, t.ROUND_ID, t.COMPETITION_ID, t.TYPE, " +
            "p.NAME PARSER_NAME, e.NAME EVENT_NAME " +
            "FROM TASKS t JOIN PARSERS p ON t.PARSER_ID = p.ID JOIN EVENTS e ON t.EVENT_ID = e.ID;";
    private static final String SELECT_ALL_PREDICTIONS = "SELECT * FROM PREDICTIONS;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseCheck() {
        List<Task> tasks = jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> {
            Task task = new Task();
            task.id = rs.getInt("ID");
            task.sessionId = rs.getInt("SESSION_ID");
            task.roundId = rs.getInt("ROUND_ID");
            task.competitionId = rs.getInt("COMPETITION_ID");
            task.type = rs.getString("TYPE");
            task.parserName = rs.getString("PARSER_NAME");
            task.eventName = rs.getString("EVENT_NAME");
            return task;
        });
        for (Task task : tasks) {
            log.info(task.toString());
        }
        assertTrue(tasks.size() == 6);
    }

    private static class Task {
        private int id;
        private int sessionId;
        private int roundId;
        private int competitionId;
        private String type;
        private String parserName;
        private String eventName;

        @Override
        public String toString() {
            return "Task{" +
                    "id=" + id +
                    ", sessionId=" + sessionId +
                    ", roundId=" + roundId +
                    ", competitionId=" + competitionId +
                    ", type='" + type + '\'' +
                    ", parserName='" + parserName + '\'' +
                    ", eventName='" + eventName + '\'' +
                    '}';
        }

    }

    @Test
    public void testPredictions() {
        List<Prediction> predictions = jdbcTemplate.query(SELECT_ALL_PREDICTIONS, (rs, rowNum) -> {
            Prediction prediction = new Prediction();
            prediction.setId(rs.getInt("ID"));
            prediction.setIdTeamHome(rs.getInt("ID_TEAM_HOME"));
            prediction.setDoesGoalsHome(rs.getFloat("DOES_GOALS_HOME"));
            prediction.setDoesMissedHome(rs.getFloat("DOES_MISSED_HOME"));
            prediction.setVictoriesHomePercents(rs.getFloat("VICTORIES_HOME_PERCENTS"));
            prediction.setDrawnsHomePercents(rs.getFloat("DRAWNS_HOME_PERCENTS"));
            prediction.setLostsHomePercens(rs.getFloat("LOSTS_HOME_PERCENTS"));
            prediction.setIdTeamAway(rs.getInt("ID_TEAM_AWAY"));
            prediction.setDoesGoalsAway(rs.getFloat("DOES_GOALS_AWAY"));
            prediction.setDoesMissedAway(rs.getFloat("DOES_MISSED_AWAY"));
            prediction.setVictoriesAwayPercents(rs.getFloat("VICTORIES_AWAY_PERCENTS"));
            prediction.setDrawnAwayPercents(rs.getFloat("DRAWNS_AWAY_PERCENTS"));
            prediction.setLostsAwayPercents(rs.getFloat("LOSTS_AWAY_PERCENTS"));
            prediction.setEventId(rs.getInt("EVENT_ID"));
            return prediction;
        });
        for (Prediction prediction : predictions) {
           log.info(prediction.toString());
        }
        assertTrue(predictions.size() == 3);
    }

}
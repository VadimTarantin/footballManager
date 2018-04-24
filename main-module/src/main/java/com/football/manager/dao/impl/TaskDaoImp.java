package com.football.manager.dao.impl;

import com.football.manager.dao.TaskDao;
import com.football.manager.dao.exception.TaskDaoException;
import com.football.manager.entity.Task;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class TaskDaoImp extends BaseDaoImpl implements TaskDao {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());
    private static final String INSERT_NEW_TASK = "INSERT INTO TASKS (SESSION_ID, ROUND_ID, COMPETITION_ID, TYPE, PARSER_ID, EVENT_ID) " +
            "VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL = "SELECT ID, SESSION_ID, ROUND_ID, COMPETITION_ID, TYPE, PARSER_ID, EVENT_ID FROM TASKS;";

    @Override
    public void add(Task task) {
        try {
            jdbcTemplate.update(INSERT_NEW_TASK, new Object());
        } catch (Exception e) {
            String errorMessage = String.format("Error during add new task %s", task);
            log.error(errorMessage, e);
            throw new TaskDaoException(errorMessage, e);
        }

    }

    @Override
    public void add(List<Task> tasks) {
        try {
            jdbcTemplate.batchUpdate(INSERT_NEW_TASK, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Task task = tasks.get(i);
                    ps.setInt(1, task.getSessionId());
                    ps.setInt(2, task.getRoundId());
                    ps.setInt(3, task.getCompetitionId());
                    ps.setString(4, task.getType());
                    ps.setInt(5, task.getParserId());
                    ps.setInt(6, task.getEventId());
                }

                @Override
                public int getBatchSize() {
                    return tasks.size();
                }
            });
        } catch (Exception e) {
            String errorMessage = String.format("Error during add new tasks", tasks);
            log.error(errorMessage, e);
            throw new TaskDaoException(errorMessage, e);
        }
    }

    @Override
    public List<Task> getAll() {
        return jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> {
            Task result = new Task();
            result.setId(rs.getInt("ID"));
            result.setSessionId(rs.getInt("SESSION_ID"));
            result.setRoundId(rs.getInt("ROUND_ID"));
            result.setCompetitionId(rs.getInt("COMPETITION_ID"));
            result.setType(rs.getString("COMPETITION_ID"));
            result.setParserId(rs.getInt("PARSER_ID"));
            result.setEventId(rs.getInt("EVENT_ID"));
            return result;
        });
    }

}
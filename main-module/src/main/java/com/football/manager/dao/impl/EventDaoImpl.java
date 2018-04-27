package com.football.manager.dao.impl;

import com.football.manager.dao.EventDao;
import com.football.manager.dao.exception.EventDaoException;
import com.football.manager.dao.exception.NoSuchEntityException;
import com.football.manager.entity.Event;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.List;

@Component
public class EventDaoImpl extends BaseDaoImpl implements EventDao {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());
    private static final String SELECT_BY_NAME = "SELECT ID, NAME FROM EVENTS WHERE NAME = ?;";
    private static final String INSERT_NEW_EVENT = "INSERT INTO EVENTS (NAME) VALUES (?);";
    private static final String SELECT_ALL_EVENTS = "SELECT ID, NAME FROM EVENTS;";

    @Override
    public Integer add(Event event) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement(INSERT_NEW_EVENT, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, event.getName());
                return ps;
            }, keyHolder);
            return keyHolder.getKey().intValue();
        } catch (Exception e) {
            String errorMessage = String.format("Error during add new event %s", event);
            log.error(errorMessage);
            throw new EventDaoException(errorMessage, e);
        }

    }

    @Override
    public Event getEventByName(String name) {
        Event event;
        try {
            event = jdbcTemplate.query(SELECT_BY_NAME, new Object[]{name}, new int[]{Types.VARCHAR}, rs -> {
                if (rs.next()) {
                    return new Event(rs.getInt("ID"), name);
                }
                throw new NoSuchEntityException("Event with name " + name + " does not exist!");
            });
        } catch (NoSuchEntityException e1) {
            log.info("Attempt to select event by not existing name ({})", name);
            throw e1;
        } catch (Exception e2) {
            String errorMessage = String.format("Error while select event by name \"%s\"", name);
            log.error(errorMessage, name, e2);
            throw new EventDaoException(errorMessage, e2);
        }
        return event;
    }

    @Override
    public Event getEventById(int id) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public boolean existsWithSuchName(String name) {
        try {
            getEventByName(name);
            return true;
        } catch (NoSuchEntityException e) {
            return false;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Event> getAll() {
        return jdbcTemplate.query(SELECT_ALL_EVENTS, new RowMapper<Event>() {
            @Override
            public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Event(rs.getInt("ID"), rs.getString("NAME"));
            }
        });
    }

}
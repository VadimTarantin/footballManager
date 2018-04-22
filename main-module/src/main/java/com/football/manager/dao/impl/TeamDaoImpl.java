package com.football.manager.dao.impl;

import com.football.manager.dao.TeamDao;
import com.football.manager.entity.Team;
import org.h2.tools.RunScript;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TeamDaoImpl implements TeamDao {

    private static final Logger log = LoggerFactory.getLogger(TeamDaoImpl.class);
    private static final String SELECT_ALL = "SELECT ID, NAME FROM TEAMS;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Team> getAll() {

        return jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> {
            Team team = new Team();
            team.setId(rs.getInt("ID"));
            team.setName(rs.getString("NAME"));
            return team;
        });
    }

}
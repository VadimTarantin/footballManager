package com.football.manager.dao.impl;

import com.football.manager.dao.TeamDao;
import com.football.manager.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamDaoImpl implements TeamDao {

    private static final String SELECT_ALL = "SELECT ID, NAME FROM TEAMS;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
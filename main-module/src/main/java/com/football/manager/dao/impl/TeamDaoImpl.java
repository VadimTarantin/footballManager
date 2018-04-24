package com.football.manager.dao.impl;

import com.football.manager.dao.TeamDao;
import com.football.manager.entity.Team;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamDaoImpl extends BaseDaoImpl implements TeamDao {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());
    private static final String SELECT_ALL = "SELECT ID, NAME FROM TEAMS;";
    private static final String INSERT_NEW_TEAM = "INSERT INTO TEAMS (ID, NAME) VALUES (?, ?);";

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
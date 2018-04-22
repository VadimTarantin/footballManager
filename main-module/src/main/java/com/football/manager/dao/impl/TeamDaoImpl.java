package com.football.manager.dao.impl;

import com.football.manager.dao.TeamDao;
import com.football.manager.entity.Team;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;
import java.util.Random;

@Repository
public class TeamDaoImpl implements TeamDao {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());
    private static final String SELECT_ALL = "SELECT ID, NAME FROM TEAMS;";
    private static final String INSERT_RANDOM_TEAM = "INSERT INTO TEAMS (ID, NAME) VALUES (?, ?);;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Team> getAll() {
        boolean actualTransactionActive = TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println("TeamDaoImpl, actualTransactionActive=" + actualTransactionActive);

        TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        System.out.println("TeamDaoImpl, TransactionStatus" + status);

        return jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> {
            Team team = new Team();
            team.setId(rs.getInt("ID"));
            team.setName(rs.getString("NAME"));
            return team;
        });
    }

    @Override
    public void addTeam() {
        int id = new Random().nextInt();
        String name = String.valueOf(new Random().nextInt());
        jdbcTemplate.update(INSERT_RANDOM_TEAM, new Object[]{id, name});
    }

}
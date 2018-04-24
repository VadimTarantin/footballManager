package com.football.manager.dao.impl;

import com.football.manager.dao.TeamDao;
import com.football.manager.entity.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class TeamDaoImplTest {

    @Autowired
    private TeamDao teamDao;

    @Test
    public void testGetAllShouldReturnListOfTeams() {
        List<Team> result = teamDao.getAll();

        assertFalse(result.isEmpty());
    }

}
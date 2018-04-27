package com.football.manager.service.domain.impl;

import com.football.manager.dao.TeamDao;
import com.football.manager.entity.Team;
import com.football.manager.service.domain.TeamService;
import com.football.manager.service.domain.exception.ServiceException;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    @Autowired
    private TeamDao teamDao;

    @Override
    @Transactional(readOnly = true)
    public List<Team> getAll() {
        try {
            return teamDao.getAll();
        } catch (Exception e) {
            log.warn("Unexpected exception while getting all teams");
            throw new ServiceException("Cannot get all teams", e);
        }
    }

}
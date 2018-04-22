package com.football.manager.dao;

import com.football.manager.entity.Team;

import java.util.List;

public interface TeamDao {
    List<Team> getAll();
}
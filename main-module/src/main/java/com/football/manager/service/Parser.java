package com.football.manager.service;

import com.football.manager.entity.TableTeam;

import java.util.List;

public interface Parser {
    List<? extends TableTeam> parse(String response);
}
package com.football.manager.service.parser;

import com.football.manager.entity.OverUnderTableTeam;

import java.util.List;

public interface OverUnderParser {
    List<? extends OverUnderTableTeam> parse(String response);
}
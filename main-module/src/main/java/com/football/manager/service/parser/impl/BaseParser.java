package com.football.manager.service.parser.impl;

import com.football.manager.entity.TableTeam;
import com.football.manager.service.parser.Parser;

import java.util.List;

public abstract class BaseParser implements Parser {

    @Override
    public abstract List<? extends TableTeam> parse(String response);

}
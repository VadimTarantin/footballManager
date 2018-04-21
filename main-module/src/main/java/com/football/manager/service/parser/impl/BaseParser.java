package com.football.manager.service.parser.impl;

import com.football.manager.entity.TableTeam;
import com.football.manager.service.parser.Parser;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseParser implements Parser {

    @Value("${tables.parser.start.tag}")
    protected String startTag;
    @Value("${tables.parser.end.tag}")
    protected String endTag;
    @Value("${tables.parser.entities.to.cut}")
    protected List<String> entitiesToCut = new ArrayList<>();

    public void setStartTag(String startTag) {
        this.startTag = startTag;
    }

    public void setEndTag(String endTag) {
        this.endTag = endTag;
    }

    public void setEntitiesToCut(List<String> entitiesToCut) {
        this.entitiesToCut = entitiesToCut;
    }

    @Override
    public abstract List<? extends TableTeam> parse(String response);

}
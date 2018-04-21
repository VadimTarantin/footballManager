package com.football.manager.service.parser.impl;

import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.service.exception.TableParserException;
import com.football.manager.service.parser.OverUnderParser;
import com.football.manager.util.ParserUtil;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseOverUnderTableTeamParser implements OverUnderParser {

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
    public List<? extends OverUnderTableTeam> parse(String response) {
        try {
            String preparedResponse = prepareTable(response);
            return getListTableTeams(preparedResponse);
        } catch (Exception e) {
            throw new TableParserException("Cannot parse response " + response, e);
        }
    }

    protected abstract List<? extends OverUnderTableTeam> getListTableTeams(String preparedResponse) throws Exception;

    protected String prepareTable(String response) {
        String cutTable = cutTable(response);
        String cutEntities = cutEntities(cutTable);
        return fixQuotes(cutEntities);
    }

    protected String cutTable(String response){
        return ParserUtil.cutTable(response, startTag, endTag);
    }

    protected String cutEntities(String content) {
        return ParserUtil.cutEntities(content, entitiesToCut);
    }

    protected String fixQuotes(String content) {
        return ParserUtil.fixQuotes(content);
    }

}
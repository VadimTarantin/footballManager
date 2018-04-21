package com.football.manager.service.parser.impl;

import com.football.manager.entity.TableTeam;
import com.football.manager.service.exception.TableParserException;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTableTeamParser extends BaseParser {

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
    public List<? extends TableTeam> parse(String response) {
        try {
            String preparedResponse = prepareTable(response);
            return getListTableTeams(preparedResponse);
        } catch (Exception e) {
            throw new TableParserException("Cannot parse response " + response, e);
        }
    }

    protected abstract List<? extends TableTeam> getListTableTeams(String preparedResponse) throws Exception;

    protected String prepareTable(String response) {
        String cutTable = cutTable(response);
        String cutEntities = cutEntities(cutTable);
        return fixQuotes(cutEntities);
    }

    protected String cutTable(String response){
        int start = response.indexOf(startTag);
        int end = response.indexOf(endTag);
        String content = response.substring(start, end + endTag.length());
        return cutEntities(content);
    }

    protected String cutEntities(String content) {
        for (String entity : entitiesToCut) {
            content = content.replaceAll(entity, "");
        }
        return content;
    }

    protected String fixQuotes(String content) {
        String result = content.replaceAll("\\\\\"", "\"");
        return result.replaceAll("\\\\/", "/");
    }

}
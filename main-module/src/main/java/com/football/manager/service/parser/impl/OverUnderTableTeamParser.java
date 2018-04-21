package com.football.manager.service.parser.impl;

import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.entity.OverUnderTableTeamImpl;
import com.football.manager.service.handler.OverUnderTableTeamParserHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class OverUnderTableTeamParser extends BaseOverUnderTableTeamParser {

    @Override
    protected List<? extends OverUnderTableTeam> getListTableTeams(String preparedResponse) throws Exception {
        return getListWideTableTeams(preparedResponse);
    }

    private synchronized List<OverUnderTableTeamImpl> getListWideTableTeams(String content) throws Exception {
        List<OverUnderTableTeamImpl> result = new ArrayList<>();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        OverUnderTableTeamParserHandler overUnderTableTeamParserHandler = new OverUnderTableTeamParserHandler();
        saxParser.parse(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), overUnderTableTeamParserHandler);
        result.addAll(overUnderTableTeamParserHandler.getOverUnderTableTeams());
        return result;
    }

}
package com.football.manager.service.parser.impl;

import com.football.manager.entity.TableTeam;
import com.football.manager.entity.WideTableTeam;
import com.football.manager.service.handler.WideTableTeamParserHandler;
import org.springframework.stereotype.Service;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class WideTableTeamTableTeamParser extends BaseTableTeamParser {

    @Override
    protected List<? extends TableTeam> getListTableTeams(String preparedResponse) throws Exception {
        return getListWideTableTeams(preparedResponse);
    }

    private synchronized List<WideTableTeam> getListWideTableTeams(String content) throws Exception {
        List<WideTableTeam> result = new ArrayList<>();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        WideTableTeamParserHandler wideTableTeamParserHandler = new WideTableTeamParserHandler();
        saxParser.parse(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), wideTableTeamParserHandler);
        result.addAll(wideTableTeamParserHandler.getWideTableTeams());
        return result;
    }

}
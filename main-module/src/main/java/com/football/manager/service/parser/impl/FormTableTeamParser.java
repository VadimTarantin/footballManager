package com.football.manager.service.parser.impl;

import com.football.manager.entity.FormTableTeam;
import com.football.manager.entity.TableTeam;
import com.football.manager.service.handler.FormTableTeamParserHandler;
import org.springframework.stereotype.Service;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormTableTeamParser extends BaseTableTeamParser {

    @Override
    protected List<? extends TableTeam> getListTableTeams(String preparedResponse) throws Exception {
        return getListFormTableTeams(preparedResponse);
    }

    private synchronized List<FormTableTeam> getListFormTableTeams(String content) throws Exception {
        List<FormTableTeam> result = new ArrayList<>();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        FormTableTeamParserHandler formTableTeamParserHandler = new FormTableTeamParserHandler();
        saxParser.parse(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), formTableTeamParserHandler);
        result.addAll(formTableTeamParserHandler.getFormTableTeams());
        return result;
    }

}

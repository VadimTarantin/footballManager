package com.football.manager.service.handler;

import com.football.manager.entity.WideTableTeam;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class WideTableTeamParserHandler extends TableTeamParserHandler {

    private String currentAttribute;
    private WideTableTeam wideTableTeam;
    protected List<WideTableTeam> wideTableTeams;

    public List<WideTableTeam> getWideTableTeams() {
        return wideTableTeams;
    }

    @Override
    public void startDocument() throws SAXException {
        wideTableTeams = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("a".equals(qName)) {
            wideTableTeam = new WideTableTeam();
            wideTableTeams.add(wideTableTeam);
            wideTableTeam.setTeamName(decodeToUtf(attributes.getValue("title")));
            return;
        }
        if ("td".equals(qName)) {
            currentAttribute = attributes.getValue("class");
            td = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (td) {
            String value = new String(ch, start, length).trim();
            if (!value.isEmpty()) {
                try {
                    fillField(Integer.valueOf(value), wideTableTeam, currentAttribute);
                } catch (NumberFormatException e) {
                    System.out.println(value + " is not a number!");
                }

            }
            td = false;
        }
    }

}
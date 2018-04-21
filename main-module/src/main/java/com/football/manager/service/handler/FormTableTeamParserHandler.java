package com.football.manager.service.handler;

import com.football.manager.entity.FormTableTeam;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

public class FormTableTeamParserHandler extends TableTeamParserHandler {

    private String currentAttribute;
    private FormTableTeam formTableTeam;
    protected List<FormTableTeam> formTableTeams;

    public List<FormTableTeam> getFormTableTeams() {
        return formTableTeams;
    }

    @Override
    public void startDocument() throws SAXException {
        formTableTeams = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("a".equals(qName)) {
            formTableTeam = new FormTableTeam();
            formTableTeams.add(formTableTeam);
            formTableTeam.setTeamName(decodeToUtf(attributes.getValue("title")));
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
                    fillField(Integer.valueOf(value), formTableTeam, currentAttribute);
                } catch (NumberFormatException e) {
                    System.out.println(value + " is not a number!");
                }

            }
            td = false;
        }
    }

}
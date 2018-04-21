package com.football.manager.service.impl;

import com.football.manager.entity.TableTeam;
import com.football.manager.entity.WideTableTeam;
import com.football.manager.service.exception.WideTableParserException;
import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class WideTableParser extends BaseParser {

    @Override
    public List<? extends TableTeam> parse(String response) {
        String content = cutTable(response);
        try {
            return getListWideTableTeams(content);
        } catch (Exception e) {
            throw new WideTableParserException("Cannot parse response " + response, e);
        }
    }

    private synchronized List<WideTableTeam> getListWideTableTeams(String content) throws Exception {
        List<WideTableTeam> result = new ArrayList<>();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        saxParser.parse(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)), new WideTableParserHandler());
        result.addAll(WideTableParserHandler.wideTableTeams);
        return result;
    }

    private static class WideTableParserHandler extends DefaultHandler {
        private boolean td = false;
        private String currentAttribute;
        private WideTableTeam wideTableTeam;
        private static List<WideTableTeam> wideTableTeams;
        private static final String TOTAL_MATCHES = "number total mp";
        private static final String TOTAL_MATCHES_WON = "number total won total_won";
        private static final String TOTAL_MATCHES_DRAWN = "number total drawn total_drawn";
        private static final String TOTAL_MATCHES_LOST = "number total lost total_lost";
        private static final String TOTAL_GOALS = "number total gf total_gf";
        private static final String TOTAL_MISSED = "number total ga total_ga";
        private static final String TOTAL_MATCHES_HOME = "number home mp home_total";
        private static final String TOTAL_MATCHES_WON_HOME = "number home won home_won";
        private static final String TOTAL_MATCHES_DRAWN_HOME = "number home drawn home_drawn";
        private static final String TOTAL_MATCHES_LOST_HOME = "number home lost home_lost";
        private static final String TOTAL_GOALS_HOME = "number home gf home_gf";
        private static final String TOTAL_MISSED_HOME = "number home ga home_ga";
        private static final String TOTAL_MATCHES_AWAY = "number away mp away_total";
        private static final String TOTAL_MATCHES_WON_AWAY = "number away won away_won";
        private static final String TOTAL_MATCHES_DRAWN_AWAY = "number away drawn away_drawn";
        private static final String TOTAL_MATCHES_LOST_AWAY = "number away lost away_lost";
        private static final String TOTAL_GOALS_AWAY = "number away gf away_gf";
        private static final String TOTAL_MISSED_AWAY = "number away ga away_ga";
        private static final String DIFFERENCE_GOALS_MISSED = "number gd";
        private static final String SCORE = "number points";

        @Override
        public void startDocument() throws SAXException {
            wideTableTeams = new ArrayList<>();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("a".equals(qName)) {
                wideTableTeam = new WideTableTeam();
                wideTableTeams.add(wideTableTeam);
                wideTableTeam.setTeamName(attributes.getValue("title"));
                return;
            }
            if ("td".equals(qName)) {
                currentAttribute = attributes.getValue("class");
                td = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (td) {
                String value = new String(ch, start, length).trim();
                if (!value.isEmpty()) {
                    fillField(Integer.valueOf(value));
                }
                td = false;
            }
        }

        private void fillField(int value) {
            switch (currentAttribute) {
                case TOTAL_MATCHES: wideTableTeam.setTotalMatches(value);
                    break;
                case TOTAL_MATCHES_WON: wideTableTeam.setTotalMatchesWon(value);
                    break;
                case TOTAL_MATCHES_DRAWN: wideTableTeam.setTotalMatchesDrawn(value);
                    break;
                case TOTAL_MATCHES_LOST: wideTableTeam.setTotalMatchesLost(value);
                    break;
                case TOTAL_GOALS: wideTableTeam.setTotalGoals(value);
                    break;
                case TOTAL_MISSED: wideTableTeam.setTotalMissed(value);
                    break;
                case TOTAL_MATCHES_HOME: wideTableTeam.setTotalMatchesHome(value);
                    break;
                case TOTAL_MATCHES_WON_HOME: wideTableTeam.setTotalMatchesWonHome(value);
                    break;
                case TOTAL_MATCHES_DRAWN_HOME: wideTableTeam.setTotalMatchesDrawnHome(value);
                    break;
                case TOTAL_MATCHES_LOST_HOME: wideTableTeam.setTotalMatchesLostHome(value);
                    break;
                case TOTAL_GOALS_HOME: wideTableTeam.setTotalGoalsHome(value);
                    break;
                case TOTAL_MISSED_HOME: wideTableTeam.setTotalMissedHome(value);
                    break;
                case TOTAL_MATCHES_AWAY: wideTableTeam.setTotalMatchesAway(value);
                    break;
                case TOTAL_MATCHES_WON_AWAY: wideTableTeam.setTotalMatchesWonAway(value);
                    break;
                case TOTAL_MATCHES_DRAWN_AWAY: wideTableTeam.setTotalMatchesDrawnAway(value);
                    break;
                case TOTAL_MATCHES_LOST_AWAY: wideTableTeam.setTotalMatchesLostAway(value);
                    break;
                case TOTAL_GOALS_AWAY: wideTableTeam.setTotalGoalsAway(value);
                    break;
                case TOTAL_MISSED_AWAY: wideTableTeam.setTotalMissedAway(value);
                    break;
                case DIFFERENCE_GOALS_MISSED: wideTableTeam.setDifferenceGoalsMissed(value);
                    break;
                case SCORE: wideTableTeam.setScore(value);
                    break;
            }
        }
    }

}
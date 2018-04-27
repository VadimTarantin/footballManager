package com.football.manager.service.handler;

import com.football.manager.entity.OverUnderTableTeamImpl;
import com.football.manager.util.ParserUtil;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class OverUnderTableTeamParserHandler extends DefaultHandler {

    private boolean a = false;
    private boolean td = false;
    private String currentAttribute;

    protected static final String TOTAL_MATCHES = "number mp";
    protected static final String ZERO_GOALS = "number zero-goals";
    protected static final String SOME_AMOUNT_GOALS = "number";
    protected static final String AVERAGE_AMOUNT_GOALS = "number avg-goals";

    private OverUnderTableTeamImpl overUnderTableTeamImpl;
    private List<OverUnderTableTeamImpl> overUnderTableTeamImpls;

    public List<OverUnderTableTeamImpl> getOverUnderTableTeams() {
        return overUnderTableTeamImpls;
    }

    @Override
    public void startDocument() throws SAXException {
        overUnderTableTeamImpls = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("a".equals(qName)) {
            a = true;
        }
        if ("td".equals(qName)) {
            currentAttribute = attributes.getValue("class");
            td = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (a) {
            overUnderTableTeamImpl = new OverUnderTableTeamImpl();
            overUnderTableTeamImpls.add(overUnderTableTeamImpl);
            overUnderTableTeamImpl.setTeamName(decodeToUtf(new String(ch, start, length)));
            a = false;
        } else if (td) {
            String value = new String(ch, start, length).trim();
            if (!value.isEmpty()) {
                try {
                    fillField(Integer.valueOf(value));
                } catch (NumberFormatException e) {
                    try {
                        tryFillAverage(value);
                    } catch (NumberFormatException e1) {
                        System.out.println(value + " is not a number!");
                    }
                }
            }
            td = false;
        }
    }

    private void fillField(int value) {
        switch (currentAttribute) {
            case TOTAL_MATCHES:
                overUnderTableTeamImpl.setTotalMatches(value);
                break;
            case ZERO_GOALS:
                overUnderTableTeamImpl.setZeroGoals(value);
                break;
            case AVERAGE_AMOUNT_GOALS:
                overUnderTableTeamImpl.setAverageGoals(value);
                break;
            case SOME_AMOUNT_GOALS:
                processNumberClass(value);
                break;
        }
    }

    private void processNumberClass(int value) {
        if (overUnderTableTeamImpl.getOneGoal() == null) {
            overUnderTableTeamImpl.setOneGoal(value);
        } else if (overUnderTableTeamImpl.getTwoGoals() == null) {
            overUnderTableTeamImpl.setTwoGoals(value);
        } else if (overUnderTableTeamImpl.getThreeGoals() == null) {
            overUnderTableTeamImpl.setThreeGoals(value);
        } else if (overUnderTableTeamImpl.getFourGoals() == null) {
            overUnderTableTeamImpl.setFourGoals(value);
        } else if (overUnderTableTeamImpl.getFiveGoals() == null) {
            overUnderTableTeamImpl.setFiveGoals(value);
        } else if (overUnderTableTeamImpl.getSixGoals() == null) {
            overUnderTableTeamImpl.setSixGoals(value);
        } else if (overUnderTableTeamImpl.getSevenGoals() == null) {
            overUnderTableTeamImpl.setSevenGoals(value);
        } else if (overUnderTableTeamImpl.getMoreThenSevenGoals() == null) {
            overUnderTableTeamImpl.setMoreThenSevenGoals(value);
        }
    }

    private void tryFillAverage(String value) {
        if (AVERAGE_AMOUNT_GOALS.equals(currentAttribute)) {
            overUnderTableTeamImpl.setAverageGoals(Float.valueOf(value));
        }
    }

    protected String decodeToUtf(String src) {
        if (!shouldDecodeToUtf(src)) {
            return src;
        }
        return ParserUtil.decodeToUtf(src);
    }

    protected boolean shouldDecodeToUtf(String src) {
        return ParserUtil.shouldDecodeToUtf(src);
    }

}
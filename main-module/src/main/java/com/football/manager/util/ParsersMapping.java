package com.football.manager.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ParsersMapping {

    WIDE_TABLE_TEAM(1, "competition_wide_table"),
    FORM_TABLE_TEAM(2, "competition_form_table"),
    OVER_UNDER_TABLE_TEAM(3, "competition_overunder_table");

    private Integer parserId;
    private String type;

    ParsersMapping(Integer parserId, String type) {
        this.parserId = parserId;
        this.type = type;
    }

    public static Map<Integer, String> getParsersMapping() {
        Map<Integer, String> result = new HashMap<>();
        ParsersMapping[] parsersMappings = ParsersMapping.values();
        for (ParsersMapping parsersMapping : parsersMappings) {
            result.put(parsersMapping.parserId, parsersMapping.type);
        }
        return result;
    }

    public static String getType(Integer id) {
        ParsersMapping[] parsersMappings = ParsersMapping.values();
        for (ParsersMapping parsersMapping : parsersMappings) {
            if (parsersMapping.parserId.equals(id)) {
                return parsersMapping.type;
            }
        }
        return null;
    }

    public static List<Integer> getParserIds() {
        List<Integer> result = new ArrayList<>();
        ParsersMapping[] parsersMappings = ParsersMapping.values();
        for (ParsersMapping parsersMapping : parsersMappings) {
            result.add(parsersMapping.parserId);
        }
        return result;
    }

    public Integer getParserId() {
        return parserId;
    }

    public String getType() {
        return type;
    }

}
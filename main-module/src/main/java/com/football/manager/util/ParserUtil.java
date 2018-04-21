package com.football.manager.util;

import java.util.List;

public class ParserUtil {

    public static String cutTable(String content, String start, String end) {
        int from = content.indexOf(start);
        int to = content.indexOf(end);
        return content.substring(from, to + end.length());
    }

    public static String cutEntities(String content, List<String> entitiesToCut) {
        for (String entity : entitiesToCut) {
            content = content.replaceAll(entity, "");
        }
        return content;
    }

    public static String fixQuotes(String content) {
        String result = content.replaceAll("\\\\\"", "\"");
        return result.replaceAll("\\\\/", "/");
    }

    public static boolean shouldDecodeToUtf(String src) {
        return src.contains("\\u");
    }

    public static String decodeToUtf(String src) {
        StringBuilder result = new StringBuilder();

        String[] worlds = src.split(" ");

        for (String world : worlds) {
            String[] letters = world.split("\\\\u");
            for (int i = 1; i < letters.length; i++) {
                String letter = letters[i];
                int symCode = Integer.valueOf(letter, 16);
                char currentChar = (char) symCode;
                result.append(currentChar);
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

}
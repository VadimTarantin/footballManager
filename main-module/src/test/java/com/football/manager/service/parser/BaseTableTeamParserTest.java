package com.football.manager.service.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BaseTableTeamParserTest {

    protected String getResponse(String fileName) throws Exception {
        File updateWideTable = new File(this.getClass().getClassLoader().getResource(fileName).getFile());
        BufferedReader reader = new BufferedReader(new FileReader(updateWideTable));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

}
package com.football.manager.service.parser;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class OverUnderTeamParserTest extends BaseTableTeamParserTest {

    @Value("${over.under.table.team.parser.test.file.name}")
    private String fileName;

    @Autowired
    @Qualifier(value = "overUnderTableTeamParser")
    private Parser parser;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Test
    public void testFormTableParser() throws Exception {

    }

}
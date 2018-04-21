package com.football.manager.service.parser;

import com.football.manager.entity.OverUnderTableTeam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OverUnderTableTeamParserTest extends BaseTableTeamParserTest {

    @Value("${over.under.table.team.parser.test.file.name}")
    private String fileName;

    @Autowired
    @Qualifier(value = "overUnderTableTeamParser")
    private OverUnderParser parser;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Test
    public void testFormTableParser() throws Exception {
        List<? extends OverUnderTableTeam> overUnderTableTeams = parser.parse(getResponse(fileName));

        for (OverUnderTableTeam overUnderTableTeam : overUnderTableTeams) {
            System.out.println(overUnderTableTeam);
        }

        assertEquals(overUnderTableTeams.size(), 24);
    }

}
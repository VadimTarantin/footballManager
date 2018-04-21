package com.football.manager.service.parser;

import com.football.manager.entity.TableTeam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FormTableTeamParserTest extends BaseTableTeamParserTest {

    @Value("${form.table.team.parser.test.file.name}")
    private String fileName;

    @Autowired
    @Qualifier(value = "formTableTeamParser")
    private Parser parser;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Test
    public void testFormTableParser() throws Exception {
        List<? extends TableTeam> formTableTeams = parser.parse(getResponse(fileName));

        for (TableTeam wideTableTeam : formTableTeams) {
            System.out.println(wideTableTeam);
        }

        assertEquals(formTableTeams.size(), 24);
    }

}
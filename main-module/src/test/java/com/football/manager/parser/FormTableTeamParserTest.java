package com.football.manager.parser;

import com.football.manager.entity.TableTeam;
import com.football.manager.service.parser.Parser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
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
    public void testWideTableParser() throws Exception {
        List<? extends TableTeam> formTableTeams = parser.parse(getResponse(fileName));

        for (TableTeam wideTableTeam : formTableTeams) {
            System.out.println(wideTableTeam);
        }

        assertEquals(formTableTeams.size(), 24);
    }

}
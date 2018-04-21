package com.football.manager.service.parser;

import com.football.manager.entity.TableTeam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class WideTableTeamParserTest extends BaseTableTeamParserTest {

    @Value("${wide.table.team.parser.test.file.name}")
    private String fileName;

    @Autowired
    @Qualifier(value = "wideTableTeamParser")
    private Parser parser;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Test
    public void testWideTableParser() throws Exception {
        List<? extends TableTeam> wideTableTeams = parser.parse(getResponse(fileName));

        for (TableTeam wideTableTeam : wideTableTeams) {
            System.out.println(wideTableTeam);
        }

        assertEquals(wideTableTeams.size(), 24);
    }

}
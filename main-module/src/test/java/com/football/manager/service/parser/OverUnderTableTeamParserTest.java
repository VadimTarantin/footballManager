package com.football.manager.service.parser;

import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.util.SystemUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OverUnderTableTeamParserTest extends BaseTableTeamParserTest {

    private static final Logger log = LoggerFactory.getLogger(SystemUtil.getCurrentClass());

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
            log.info(overUnderTableTeam.toString());
        }

        assertEquals(overUnderTableTeams.size(), 24);
    }

}
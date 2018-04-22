package com.football.manager.service.parser;

import com.football.manager.entity.TableTeam;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static org.junit.Assert.*;

public class WideTableTeamParserTest extends BaseTableTeamParserTest {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

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
            log.info(wideTableTeam.toString());
        }

        assertEquals(wideTableTeams.size(), 24);
    }

}
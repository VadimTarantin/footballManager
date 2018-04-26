package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.CrawledTablesDto;
import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.service.parser.BaseTableTeamParserTest;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.Assert.assertFalse;

public class ParserManagerTest extends BaseTableTeamParserTest {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    @Value("${wide.table.team.parser.test.file.name}")
    private String wideTableFileName;
    @Value("${form.table.team.parser.test.file.name}")
    private String formTableFileName;
    @Value("${over.under.table.team.parser.test.file.name}")
    private String overUnderFileName;

    @Autowired
    private ParserManager parserManager;

    @Test(timeout = 2000)
    public void testParserManager() throws Exception {
        String wideTableResponse = getResponse(wideTableFileName);
        String formTableResponse = getResponse(formTableFileName);
        String overUnderTableResponse = getResponse(overUnderFileName);

        ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos = new ArrayBlockingQueue<>(10);
        ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos = new ArrayBlockingQueue<>(10);
        crawledTablesDtos.put(new CrawledTablesDto(wideTableResponse, formTableResponse, overUnderTableResponse));

        parserManager.crawledTablesDtos = crawledTablesDtos;
        parserManager.parsedTablesDtos = parsedTablesDtos;

        Thread processor = new Thread(parserManager);
        processor.start();
//        processor.join();
        Thread.sleep(1000L);

        for (ParsedTablesDto parsedTablesDto : parsedTablesDtos) {
            log.info("parsedTablesDto: {}", parsedTablesDtos);
        }

        assertFalse(parsedTablesDtos.isEmpty());
    }

}
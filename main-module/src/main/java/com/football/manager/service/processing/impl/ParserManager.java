package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.CrawledTablesDto;
import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;

public class ParserManager extends BaseProcessor {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    private ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos;
    private ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos;

    public ParserManager(ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos, ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos) {
        this.crawledTablesDtos = crawledTablesDtos;
        this.parsedTablesDtos = parsedTablesDtos;
    }

    @Override
    protected void doWork() throws InterruptedException {
        //CrawledTablesDto -> ParsedTablesDto
    }

    @Override
    protected void logInfo(String message, Object p0) {
        log.info(message, p0);
    }

    @Override
    protected void logInfo(String message, Object p0, Object p1) {
        log.info(message, p0, p1);
    }

}
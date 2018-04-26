package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.CrawledTablesDto;
import com.football.manager.dto.input.ParsedTablesDto;
import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.entity.TableTeam;
import com.football.manager.service.exception.ParserException;
import com.football.manager.service.parser.OverUnderParser;
import com.football.manager.service.parser.Parser;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ParserManager extends BaseProcessor {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    private ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos;
    private ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos;

    private Parser wideTableTeamParser;
    private Parser formTableTeamParser;
    private OverUnderParser overUnderTableTeamParser;

    public ParserManager(ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos,
                         ArrayBlockingQueue<ParsedTablesDto> parsedTablesDtos,
                         Parser wideTableTeamParser,
                         Parser formTableTeamParser,
                         OverUnderParser overUnderTableTeamParser) {
        this.crawledTablesDtos = crawledTablesDtos;
        this.parsedTablesDtos = parsedTablesDtos;
        this.wideTableTeamParser = wideTableTeamParser;
        this.formTableTeamParser = formTableTeamParser;
        this.overUnderTableTeamParser = overUnderTableTeamParser;
    }

    @Override
    protected void doWork() throws InterruptedException {
        CrawledTablesDto crawledTablesDto = null;
        try {
            crawledTablesDto = crawledTablesDtos.poll(TIMEOUT, TimeUnit.MILLISECONDS);
            ParsedTablesDto parsedTablesDto = createParsedTablesDto(crawledTablesDto);
            parsedTablesDtos.offer(parsedTablesDto, TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (ParserException e) {
            log.warn("Exception during parsing CrawledTablesDto: {}", crawledTablesDto, e);
        }
    }

    private ParsedTablesDto createParsedTablesDto(CrawledTablesDto crawledTablesDto) {
        List<? extends TableTeam> wideTables = wideTableTeamParser.parse(crawledTablesDto.getWideTableResponse());
        List<? extends TableTeam> formTables = formTableTeamParser.parse(crawledTablesDto.getFormTableResponse());
        List<? extends OverUnderTableTeam> overUnderTable = overUnderTableTeamParser.parse(crawledTablesDto.getOverUnderTableResponse());
        return new ParsedTablesDto(wideTables, formTables, overUnderTable);
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
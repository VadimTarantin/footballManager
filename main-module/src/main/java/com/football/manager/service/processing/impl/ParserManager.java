package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.CrawledTablesDto;
import com.football.manager.dto.input.ParsedTablesDto;

import java.util.concurrent.ArrayBlockingQueue;

public class ParserManager extends BaseProcessor {

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

}
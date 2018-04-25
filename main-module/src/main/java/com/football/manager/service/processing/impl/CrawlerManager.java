package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.BusinessTaskDto;
import com.football.manager.dto.input.CrawledTablesDto;

import java.util.concurrent.ArrayBlockingQueue;

public class CrawlerManager extends BaseProcessor {

    private ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos;
    private ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos;

    public CrawlerManager(ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos,
                          ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos) {
        this.businessTaskDtos = businessTaskDtos;
        this.crawledTablesDtos = crawledTablesDtos;
    }

    @Override
    protected void doWork() throws InterruptedException {
        //BusinessTaskTdo -> CrawledTablesDto
    }

}
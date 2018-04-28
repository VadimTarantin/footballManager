package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.BusinessTaskDto;
import com.football.manager.dto.input.CrawledTablesDto;
import com.football.manager.service.crawler.Crawler;
import com.football.manager.service.crawler.CrawlerException;
import com.football.manager.util.SystemUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class CrawlerManager extends BaseProcessor {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos;
    ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos;
    private Crawler crawler;

    public CrawlerManager(ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos,
                          ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos,
                          Crawler crawler) {
        this.businessTaskDtos = businessTaskDtos;
        this.crawledTablesDtos = crawledTablesDtos;
        this.crawler = crawler;
    }

    @Override
    protected void doWork() throws InterruptedException {
        BusinessTaskDto businessTaskDto = null;
        try {
            businessTaskDto = businessTaskDtos.poll(TIMEOUT, TimeUnit.MILLISECONDS);
            if (businessTaskDto == null) {
                String message = String.format("Queue was empty during waiting time=%s so work will be stopped", TIMEOUT);
                log.info(message);
                throw new InterruptedException(message);
            }
            CrawledTablesDto crawledTablesDto = createCrawledTablesDto(businessTaskDto);
            boolean offerIsSuccess = crawledTablesDtos.offer(crawledTablesDto, TIMEOUT, TimeUnit.MILLISECONDS);
            if (offerIsSuccess) {
                log.info("CrawledTablesDto with eventId={} was created successful", crawledTablesDto.getEventId());
            } else {
                log.warn("CrawledTablesDto with eventId={} cannot put in queue to processing because queue is full",
                        crawledTablesDto.getEventId());
            }
        } catch (CrawlerException e) {
            log.warn("Exception during crawling BusinessTaskDto: {}", businessTaskDto, e);
        }
    }

    private CrawledTablesDto createCrawledTablesDto(BusinessTaskDto businessTaskDto) {
        String wide = crawler.get(businessTaskDto.getTaskForWideTable());
        String form = crawler.get(businessTaskDto.getTaskForFormTable());
        String overUnder = crawler.get(businessTaskDto.getTaskForOverUnderTable());
        if (StringUtils.isAnyBlank(wide, form, overUnder)) {
            String errorMessage = String.format("Error during receiving tables. Wide: %s, form: %s, overUnder: %s",
                    wide, form, overUnder);
            throw new CrawlerException(errorMessage);
        }
        return new CrawledTablesDto(wide, form, overUnder, businessTaskDto.getEventId());
    }

    @Override
    protected void logInfo(String message, Object p0) {
        log.info(message, p0);
    }

    @Override
    protected void logInfo(String message) {
        log.info(message);
    }

}
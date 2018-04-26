package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.BusinessTaskDto;
import com.football.manager.dto.input.CrawledTablesDto;
import com.football.manager.entity.Task;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.Assert.assertFalse;

@Ignore
public class CrawlerManagerTest extends BaseManagerTest {

    @Autowired
    private CrawlerManager crawlerManager;

    @Test(timeout = 5000L)
    public void testCrawlerManager() throws InterruptedException {
        ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos = new ArrayBlockingQueue<>(10);
        ArrayBlockingQueue<CrawledTablesDto> crawledTablesDtos = new ArrayBlockingQueue<>(10);
        businessTaskDtos.put(createBusinessTaskDto());

        crawlerManager.businessTaskDtos = businessTaskDtos;
        crawlerManager.crawledTablesDtos = crawledTablesDtos;

        Thread processor = new Thread(crawlerManager);
        processor.start();
//        processor.join();
        Thread.sleep(2000);

        for (CrawledTablesDto crawledTablesDto : crawledTablesDtos) {
            log.info("crawledTablesDto: {}", crawledTablesDto);
        }

        assertFalse(crawledTablesDtos.isEmpty());
    }

    private BusinessTaskDto createBusinessTaskDto() {
        Task wide = new Task();
        wide.setId(1);
        wide.setSessionId(14218);
        wide.setRoundId(42070);
        wide.setCompetitionId(70);
        wide.setType("competition_wide_table");
        wide.setParserId(1);
        wide.setEventId(1);

        Task form = new Task();
        form.setId(2);
        form.setSessionId(14218);
        form.setRoundId(42070);
        form.setCompetitionId(70);
        form.setType("competition_form_table");
        form.setParserId(2);
        form.setEventId(1);

        Task overUnder = new Task();
        overUnder.setId(3);
        overUnder.setSessionId(14218);
        overUnder.setRoundId(42070);
        overUnder.setCompetitionId(70);
        overUnder.setType("competition_overunder_table");
        overUnder.setParserId(3);
        overUnder.setEventId(1);

        return new BusinessTaskDto(wide, form, overUnder);
    }

}
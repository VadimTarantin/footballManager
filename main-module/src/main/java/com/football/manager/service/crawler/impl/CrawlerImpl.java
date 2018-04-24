package com.football.manager.service.crawler.impl;

import com.football.manager.entity.Task;
import com.football.manager.service.crawler.Crawler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CrawlerImpl implements Crawler {

    @Value("${url.pattern}")
    private String urlPattern;

    @Override
    public String get(Task task) {
        String result = null;

        return result;
    }

}
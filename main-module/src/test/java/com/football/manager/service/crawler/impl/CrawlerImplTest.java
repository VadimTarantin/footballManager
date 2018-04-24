package com.football.manager.service.crawler.impl;

import com.football.manager.dao.TaskDao;
import com.football.manager.entity.Task;
import com.football.manager.service.crawler.Crawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class CrawlerImplTest {

    @Autowired
    private Crawler crawler;

    @Autowired
    private TaskDao taskDao;

    @Test
    public void testCrawler() {
        List<Task> tasks = taskDao.getAll();
//        List<String> result = new ArrayList<>();
//
//        for (Task task : tasks) {
//            result.add(crawler.get(task));
//        }

        String result = crawler.get(tasks.get(0));
        System.out.println(result);
    }

}
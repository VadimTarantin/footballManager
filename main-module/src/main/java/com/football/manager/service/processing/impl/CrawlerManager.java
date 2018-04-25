package com.football.manager.service.processing.impl;

import com.football.manager.entity.Task;

import java.util.concurrent.ArrayBlockingQueue;

public class CrawlerManager implements Runnable {

    private ArrayBlockingQueue<Task> tasks;
    private ArrayBlockingQueue<String> wideAndFormResponse;
    private ArrayBlockingQueue<String> OverUnderResponse;

    public CrawlerManager(ArrayBlockingQueue<Task> tasks,
                          ArrayBlockingQueue<String> wideAndFormResponse,
                          ArrayBlockingQueue<String> overUnderResponse) {
        this.tasks = tasks;
        this.wideAndFormResponse = wideAndFormResponse;
        OverUnderResponse = overUnderResponse;
    }

    @Override
    public void run() {
        //tasks -> wideAndFormResponse and OverUnderResponse
    }

}
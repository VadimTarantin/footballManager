package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.BusinessTaskDto;
import com.football.manager.entity.Task;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class TaskProcessingManager extends BaseProcessor {

    private List<Task> tasks;
    private ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos;

    public TaskProcessingManager(List<Task> tasks,
                                 ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos) {
        this.tasks = tasks;
        this.businessTaskDtos = businessTaskDtos;
    }

    @Override
    protected void init() {
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                log.info("Interrupt during init method. Will be break.");
                break;
            }

            synchronized (tasks) {
                if (!tasks.isEmpty()) {
                    break;
                }
            }
        }
    }

    @Override
    protected void doWork() throws InterruptedException {
        //tasks -> BusinessTaskTdo
    }

}
package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.BusinessTaskDto;
import com.football.manager.entity.Task;

import java.util.concurrent.ArrayBlockingQueue;

public class TaskProcessingManager extends BaseProcessor {

    private ArrayBlockingQueue<Task> tasks;
    private ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos;

    public TaskProcessingManager(ArrayBlockingQueue<Task> tasks,
                                 ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos) {
        this.tasks = tasks;
        this.businessTaskDtos = businessTaskDtos;
    }

    @Override
    protected void doWork() throws InterruptedException {
        //tasks -> BusinessTaskTdo
    }

}
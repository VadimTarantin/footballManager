package com.football.manager.service.processing.impl;

import com.football.manager.dto.input.BusinessTaskDto;
import com.football.manager.entity.Task;

import java.util.concurrent.ArrayBlockingQueue;

public class TaskProcessingManager implements Runnable {

    private ArrayBlockingQueue<Task> tasks;
    private ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos;

    public TaskProcessingManager(ArrayBlockingQueue<Task> tasks,
                                 ArrayBlockingQueue<BusinessTaskDto> businessTaskDtos) {
        this.tasks = tasks;
        this.businessTaskDtos = businessTaskDtos;
    }

    @Override
    public void run() {
        //tasks -> BusinessTaskTdo
    }

}
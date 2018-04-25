package com.football.manager.service.processing.impl;

import com.football.manager.dao.TaskDao;
import com.football.manager.entity.Task;

import java.util.concurrent.ArrayBlockingQueue;

public class TaskGettingManager implements Runnable {

    private TaskDao taskDao;
    private ArrayBlockingQueue<Task> tasks;

    public TaskGettingManager(TaskDao taskDao,
                              ArrayBlockingQueue<Task> tasks) {
        this.taskDao = taskDao;
        this.tasks = tasks;
    }

    @Override
    public void run() {
        //get from taskDao -> tasks
    }

}
package com.football.manager.service.processing.impl;

import com.football.manager.dao.TaskDao;
import com.football.manager.entity.Task;

import java.util.List;

public class TaskGettingManager extends BaseProcessor {

    private TaskDao taskDao;
    List<Task> tasks;

    public TaskGettingManager(TaskDao taskDao,
                              List<Task> tasks) {
        this.taskDao = taskDao;
        this.tasks = tasks;
    }

    @Override
    protected void doWork() throws InterruptedException {
        synchronized (tasks) {
            tasks.addAll(taskDao.getAll());
        }
        throw new InterruptedException("Getting tasks from database is done");
    }

}
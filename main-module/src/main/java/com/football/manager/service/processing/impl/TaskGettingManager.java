package com.football.manager.service.processing.impl;

import com.football.manager.dao.TaskDao;
import com.football.manager.entity.Task;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TaskGettingManager extends BaseProcessor {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

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

    @Override
    protected void logInfo(String message, Object p0) {
        log.info(message, p0);
    }

    @Override
    protected void logInfo(String message) {
        log.info(message);
    }

}
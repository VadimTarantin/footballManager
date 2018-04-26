package com.football.manager.service.processing.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class TaskGettingManagerTest extends BaseManagerTest {

    @Autowired
    private TaskGettingManager taskGettingManager;

    @Test(timeout = 2000L)
    public void testGetAllTaskFromDatabaseWhenQueueMoreThenTasksInDatabase() throws InterruptedException {
        taskGettingManager.tasks = new ArrayList<>(10);

        Thread getterFromDatabase = new Thread(taskGettingManager);
        getterFromDatabase.start();
        getterFromDatabase.join();
        Assert.assertFalse(taskGettingManager.tasks.isEmpty());
    }

}
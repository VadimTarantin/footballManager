package com.football.manager.service.processing.impl;

import com.football.manager.dao.TaskDao;
import com.football.manager.dto.input.BusinessTaskDto;
import com.football.manager.entity.Task;
import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import static org.junit.Assert.assertFalse;

public class TaskProcessingManagerTest extends BaseManagerTest {

    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    @Autowired
    private TaskProcessingManager taskProcessingManager;

    @Autowired
    private TaskDao taskDao;

    @Test(timeout = 2000)
    public void testTaskProcessingManagerShouldCreateBusinessTask() throws InterruptedException {
        ArrayBlockingQueue<BusinessTaskDto> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        List<Task> tasks = taskDao.getAll();

        taskProcessingManager.tasks = tasks;
        taskProcessingManager.businessTaskDtos =arrayBlockingQueue;

        Thread processorTasks = new Thread(taskProcessingManager);
        processorTasks.start();
        processorTasks.join();

        for (BusinessTaskDto businessTaskDto : arrayBlockingQueue) {
            log.info("businessTaskDto: {}", businessTaskDto);
        }

        assertFalse(arrayBlockingQueue.isEmpty());
    }

}

package com.football.manager.dao.impl;

import com.football.manager.dao.TaskDao;
import com.football.manager.entity.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class TaskDaoImplTest {

    @Autowired
    private TaskDao taskDao;

    @Test
    public void testTaskDaoWhenGetAllShouldReturnAllTasks() {
        List<Task> tasks = taskDao.getAll();

        assertThat(tasks.size(), is(6));

        Task task = tasks.get(0);
        assertNotNull(task.getId());
        assertFalse(task.getSessionId() == 0);
        assertFalse(task.getRoundId() == 0);
        assertFalse(task.getCompetitionId() == 0);
        assertNotNull(task.getType());
        assertFalse(task.getParserId() == 0);
        assertFalse(task.getEventId() == 0);
    }

}
package com.football.manager.service.domain.impl;

import com.football.manager.dto.input.InputDataForTaskFromForm;
import com.football.manager.service.domain.TaskService;
import com.football.manager.service.domain.exception.TaskServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class TaskServiceImpTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void testAddNotExistingTaskShouldOk() {
        InputDataForTaskFromForm inputDataForTaskFromForm = new InputDataForTaskFromForm();
        inputDataForTaskFromForm.setEventName("Abcd");
        inputDataForTaskFromForm.setSessionId(10);
        inputDataForTaskFromForm.setRoundId(20);
        inputDataForTaskFromForm.setCompetitionId(30);
        taskService.addTask(inputDataForTaskFromForm);
    }

    @Test(expected = TaskServiceException.class)
    public void testAddExistingTaskShouldException() {
        InputDataForTaskFromForm inputDataForTaskFromForm = new InputDataForTaskFromForm();
        inputDataForTaskFromForm.setEventName("England championship");
        inputDataForTaskFromForm.setSessionId(10);
        inputDataForTaskFromForm.setRoundId(20);
        inputDataForTaskFromForm.setCompetitionId(30);
        taskService.addTask(inputDataForTaskFromForm);
    }

}
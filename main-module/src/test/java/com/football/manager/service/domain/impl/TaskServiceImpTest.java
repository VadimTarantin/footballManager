package com.football.manager.service.domain.impl;

import com.football.manager.dto.input.InputDataForTaskFromForm;
import com.football.manager.service.domain.exception.TaskServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class TaskServiceImpTest {

    private static final String NON_EXISTING = "Not existing";
    private static final String EXISTING = "England championship";

    @Autowired
    private TaskServiceImp taskServiceImp;

    public void setUp() {
    }

    @Test
    public void testAddNotExistingTaskShouldSuccess() {
        InputDataForTaskFromForm inputDataForTaskFromForm = new InputDataForTaskFromForm();
        inputDataForTaskFromForm.setEventName(NON_EXISTING);
        inputDataForTaskFromForm.setSessionId(10);
        inputDataForTaskFromForm.setRoundId(20);
        inputDataForTaskFromForm.setCompetitionId(30);
        taskServiceImp.addTask(inputDataForTaskFromForm);
    }

    @Test(expected = TaskServiceException.class)
    public void testAddExistingTaskShouldException() {
        InputDataForTaskFromForm inputDataForTaskFromForm = new InputDataForTaskFromForm();
        inputDataForTaskFromForm.setEventName(EXISTING);
        inputDataForTaskFromForm.setSessionId(10);
        inputDataForTaskFromForm.setRoundId(20);
        inputDataForTaskFromForm.setCompetitionId(30);
        taskServiceImp.addTask(inputDataForTaskFromForm);
    }

}
package com.football.manager.service.domain;

import com.football.manager.dto.input.InputDataForTaskFromForm;
import com.football.manager.entity.Task;

import java.util.List;

public interface TaskService {
    void addTask(InputDataForTaskFromForm inputData);
    List<Task> getAll();
}
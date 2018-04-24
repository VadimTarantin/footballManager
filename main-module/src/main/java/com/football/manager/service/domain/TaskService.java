package com.football.manager.service.domain;

import com.football.manager.dto.input.InputDataForTaskFromForm;

public interface TaskService {
    void addTask(InputDataForTaskFromForm inputData);
}
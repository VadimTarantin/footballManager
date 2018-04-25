package com.football.manager.dto.input;

import com.football.manager.entity.Task;

public class BusinessTaskDto {

    private Task taskForWideTable;
    private Task taskForFormTable;
    private Task taskForOverUnderTable;

    public BusinessTaskDto(Task taskForWideTable, Task taskForFormTable, Task taskForOverUnderTable) {
        this.taskForWideTable = taskForWideTable;
        this.taskForFormTable = taskForFormTable;
        this.taskForOverUnderTable = taskForOverUnderTable;
    }

    public Task getTaskForWideTable() {
        return taskForWideTable;
    }

    public Task getTaskForFormTable() {
        return taskForFormTable;
    }

    public Task getTaskForOverUnderTable() {
        return taskForOverUnderTable;
    }

}
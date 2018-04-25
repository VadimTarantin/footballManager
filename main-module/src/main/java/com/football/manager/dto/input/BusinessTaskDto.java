package com.football.manager.dto.input;

import com.football.manager.entity.Task;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessTaskDto that = (BusinessTaskDto) o;
        return Objects.equals(taskForWideTable, that.taskForWideTable) &&
                Objects.equals(taskForFormTable, that.taskForFormTable) &&
                Objects.equals(taskForOverUnderTable, that.taskForOverUnderTable);
    }

    @Override
    public int hashCode() {

        return Objects.hash(taskForWideTable, taskForFormTable, taskForOverUnderTable);
    }

    @Override
    public String toString() {
        return "BusinessTaskDto{" +
                "taskForWideTable=" + taskForWideTable +
                ", taskForFormTable=" + taskForFormTable +
                ", taskForOverUnderTable=" + taskForOverUnderTable +
                '}';
    }
}
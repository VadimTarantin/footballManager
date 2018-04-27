package com.football.manager.dto.input;

import com.football.manager.entity.Task;

import java.util.Objects;

public class BusinessTaskDto {

    private int eventId;
    private Task taskForWideTable;
    private Task taskForFormTable;
    private Task taskForOverUnderTable;

    public BusinessTaskDto(Task taskForWideTable, Task taskForFormTable, Task taskForOverUnderTable, int eventId) {
        this.taskForWideTable = taskForWideTable;
        this.taskForFormTable = taskForFormTable;
        this.taskForOverUnderTable = taskForOverUnderTable;
        this.eventId = eventId;
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

    public int getEventId() {
        return eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessTaskDto that = (BusinessTaskDto) o;
        return eventId == that.eventId &&
                Objects.equals(taskForWideTable, that.taskForWideTable) &&
                Objects.equals(taskForFormTable, that.taskForFormTable) &&
                Objects.equals(taskForOverUnderTable, that.taskForOverUnderTable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, taskForWideTable, taskForFormTable, taskForOverUnderTable);
    }

    @Override
    public String toString() {
        return "BusinessTaskDto{" +
                "eventId=" + eventId +
                ", taskForWideTable=" + taskForWideTable +
                ", taskForFormTable=" + taskForFormTable +
                ", taskForOverUnderTable=" + taskForOverUnderTable +
                '}';
    }

}
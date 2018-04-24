package com.football.manager.dao;

import com.football.manager.entity.Task;

import java.util.List;

public interface TaskDao {
    void add(Task task);
    void add(List<Task> tasks);
}
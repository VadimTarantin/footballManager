package com.football.manager.dao;

import com.football.manager.entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface TaskDao {
    void add(Task task);
    void add(List<Task> tasks);
    List<Task> getAll();
    Task extractTask(ResultSet rs) throws SQLException;
}
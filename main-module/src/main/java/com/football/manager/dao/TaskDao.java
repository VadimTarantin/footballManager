package com.football.manager.dao;

import com.football.manager.entity.Task;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface TaskDao {
    void add(Task task);
    void add(List<Task> tasks);
    List<Task> getAll();
    DataSource getDataSource();
    Task extractTask(ResultSet rs) throws SQLException;
}
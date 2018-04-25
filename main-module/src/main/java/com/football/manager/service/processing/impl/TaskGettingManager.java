package com.football.manager.service.processing.impl;

import com.football.manager.dao.TaskDao;
import com.football.manager.dao.impl.TaskDaoImp;
import com.football.manager.entity.Task;
import com.football.manager.util.SystemUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TaskGettingManager extends BaseProcessor {

    private TaskDao taskDao;
    private ArrayBlockingQueue<Task> tasks;

    public TaskGettingManager(TaskDao taskDao,
                              ArrayBlockingQueue<Task> tasks) {
        this.taskDao = taskDao;
        this.tasks = tasks;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void doWork() throws InterruptedException {
        DataSource dataSource = taskDao.getDataSource();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setReadOnly(true);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(TaskDaoImp.SELECT_ALL);
            while(resultSet.next()) {
                Task result = taskDao.extractTask(resultSet);
                tasks.offer(result, TIMEOUT, TimeUnit.MILLISECONDS);
            }
            throw new InterruptedException("Work with database was ended");
        } catch (SQLException e) {
            String errorMessage = "Exception during work with database";
            log.warn(errorMessage, e);
            throw new InterruptedException(errorMessage);
        } finally {
            SystemUtil.closeQuietlyConnection(connection);
        }
    }

}
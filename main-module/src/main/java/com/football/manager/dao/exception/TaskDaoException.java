package com.football.manager.dao.exception;

public class TaskDaoException extends DaoException {

    public TaskDaoException(String message) {
        super(message);
    }

    public TaskDaoException(String message, Throwable cause) {
        super(message, cause);
    }

}
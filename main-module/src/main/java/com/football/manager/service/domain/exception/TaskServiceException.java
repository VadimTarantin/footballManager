package com.football.manager.service.domain.exception;

public class TaskServiceException extends ServiceException {

    public TaskServiceException(String message) {
        super(message);
    }

    public TaskServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
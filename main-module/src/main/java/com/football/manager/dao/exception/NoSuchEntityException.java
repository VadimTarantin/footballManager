package com.football.manager.dao.exception;

public class NoSuchEntityException extends DaoException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public NoSuchEntityException(String message, Throwable cause) {
        super(message, cause);
    }

}
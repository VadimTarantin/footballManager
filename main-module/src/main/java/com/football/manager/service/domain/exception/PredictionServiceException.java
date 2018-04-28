package com.football.manager.service.domain.exception;

public class PredictionServiceException extends ServiceException {

    public PredictionServiceException(String message) {
        super(message);
    }

    public PredictionServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
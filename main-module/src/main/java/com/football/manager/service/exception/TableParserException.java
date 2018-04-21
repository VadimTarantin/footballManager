package com.football.manager.service.exception;

public class TableParserException extends ParserException {

    public TableParserException(String message) {
        super(message);
    }

    public TableParserException(String message, Throwable cause) {
        super(message, cause);
    }

}
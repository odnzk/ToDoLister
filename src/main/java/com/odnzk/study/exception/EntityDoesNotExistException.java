package com.odnzk.study.exception;

public class EntityDoesNotExistException extends RuntimeException {

    public EntityDoesNotExistException() {
        super();
    }

    public EntityDoesNotExistException(String message) {
        super(message);
    }

    public EntityDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}

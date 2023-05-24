package com.odnzk.study.exception;

public class ConvertingExceptionException extends RuntimeException {

    public ConvertingExceptionException() {
        super();
    }

    public ConvertingExceptionException(String message) {
        super(message);
    }

    public ConvertingExceptionException(String message, Throwable cause) {
        super(message, cause);
    }
}

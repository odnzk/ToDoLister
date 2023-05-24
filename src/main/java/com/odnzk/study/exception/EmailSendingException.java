package com.odnzk.study.exception;

public class EmailSendingException extends RuntimeException {

    public EmailSendingException() {
        super();
    }

    public EmailSendingException(String message) {
        super(message);
    }

    public EmailSendingException(String message, Throwable cause) {
        super(message, cause);
    }
}

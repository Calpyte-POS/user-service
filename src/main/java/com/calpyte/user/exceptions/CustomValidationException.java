package com.calpyte.user.exceptions;

import org.springframework.http.HttpStatus;

public class CustomValidationException extends RuntimeException{

    private String message;

    private String errorcode;

    public CustomValidationException(String message, HttpStatus httpStatusCode) {
        super(message);
        this.message = message;
        this.errorcode = httpStatusCode.toString();

    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorcode;
    }
}

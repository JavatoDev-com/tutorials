package com.javatodev.api.exception;

public class JavatoDevGlobalException extends RuntimeException {

    private Long code;

    public JavatoDevGlobalException (String message, Long code) {
        super(message);
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

}

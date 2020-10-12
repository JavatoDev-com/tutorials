package com.javatodev.api.exception;

import com.javatodev.api.exception.config.GlobalErrorCode;

public class EntityNotFoundException extends JavatoDevGlobalException {

    public EntityNotFoundException(){
        super("exception.user.not.found", GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }

    public EntityNotFoundException(String message, Long code) {
        super(message, code);
    }

}

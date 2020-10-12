package com.javatodev.api.exception.config;

import com.javatodev.api.exception.JavatoDevGlobalException;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    //Global Exception Handler for JavatoDevGlobalException.
    @ExceptionHandler(JavatoDevGlobalException.class)
    protected ResponseEntity handleGlobalException (JavatoDevGlobalException e, Locale locale) {
        return ResponseEntity
            .badRequest()
            .body(ErrorResponse.builder().code(e.getCode()).message(messageSource.getMessage(e.getMessage(),null, locale)).build());
    }


    @ExceptionHandler({Exception.class})
    protected ResponseEntity handleException(Exception e, Locale locale) {
        return ResponseEntity
            .badRequest()
            .body("Exception occured inside API "+e);
    }

}

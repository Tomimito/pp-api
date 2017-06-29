package com.parionspotes.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Thomas on 28/06/2017.
 */
@ControllerAdvice
@Component
public class ExceptionHandlingController {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Data integrity violation")
    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public void error() {
        // Nothing to do
    }
}

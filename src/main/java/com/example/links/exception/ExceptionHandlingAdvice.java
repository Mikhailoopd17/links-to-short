package com.example.links.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;


@ControllerAdvice
public class ExceptionHandlingAdvice {
    private final Logger log = Logger.getLogger(ExceptionHandlingAdvice.class);

    public ExceptionHandlingAdvice() {
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage handleBadRequestException(UserExceptions.RestException e) {
        log.error("Error: " + e.getMessage());
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage(), e.getLocalizedMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ErrorMessage handleNotAllowedException(HttpRequestMethodNotSupportedException e) {
        log.error("Error: " + e.getMessage());
        return new ErrorMessage(HttpStatus.NOT_FOUND.value(), "Page not found! Check link or try later!");
    }

}

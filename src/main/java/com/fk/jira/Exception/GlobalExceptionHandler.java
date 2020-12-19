package com.fk.jira.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseWrapper> resourceNotFoundException(ResourceNotFoundException e, WebRequest request){
        return new ResponseEntity<>(new ResponseWrapper(e.getCode(), e.getReason(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}

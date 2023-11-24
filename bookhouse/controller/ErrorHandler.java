package com.example.bookhouse.controller;

import com.example.bookhouse.exception.NotFoundException;
import com.example.bookhouse.model.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    private Exception exception;

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle(NotFoundException exception){
        return new ExceptionResponse(exception.getMessage());
    }
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ExceptionResponse handle(Exception exception) {
//        log.error(exception.getMessage());
//        return new ExceptionResponse("UNEXPECTED_EXCEPTION");
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handle(Exception exception){
        log.error(exception.getMessage());
        return new ExceptionResponse("VALIDATION_EXCEPTION");

    }
}




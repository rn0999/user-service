package com.rn.userservice.controller;


import com.rn.userservice.response.ExceptionResponse;
import com.rn.userservice.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class UserServiceControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(), ex.getMessage(), "Please enter a valid user id");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}

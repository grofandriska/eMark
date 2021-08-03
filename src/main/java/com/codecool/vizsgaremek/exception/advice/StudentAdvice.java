package com.codecool.vizsgaremek.exception.advice;

import com.codecool.vizsgaremek.exception.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class StudentAdvice {

    @ResponseBody
    @ExceptionHandler(StudentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String studentNotFoundHandler(StudentException ex) {
        return ex.getMessage();
    }
}

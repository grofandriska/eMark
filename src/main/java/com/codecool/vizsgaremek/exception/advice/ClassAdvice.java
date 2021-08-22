package com.codecool.vizsgaremek.exception.advice;

import com.codecool.vizsgaremek.exception.ClassException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ClassAdvice {

    @ResponseBody
    @ExceptionHandler(ClassException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    String classNotFound(ClassException exception){
        return exception.getMessage();
    }
}

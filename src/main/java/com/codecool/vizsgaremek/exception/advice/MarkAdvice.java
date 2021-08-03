package com.codecool.vizsgaremek.exception.advice;

import com.codecool.vizsgaremek.exception.MarkException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


public class MarkAdvice {

    @ResponseBody
    @ExceptionHandler(MarkException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String MarkNotFound(MarkException exception){
        return exception.getMessage();
    }
}

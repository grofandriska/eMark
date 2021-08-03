package com.codecool.vizsgaremek.exception.advice;


import com.codecool.vizsgaremek.exception.TeacherException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class TeacherAdvice {

    @ResponseBody
    @ExceptionHandler(TeacherException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String teacherNotFoundHandler(TeacherException ex) {
        return ex.getMessage();
    }
}

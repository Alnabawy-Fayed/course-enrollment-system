package com.example.courseenrollmentsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class WrongPassword extends RuntimeException{
    public WrongPassword(String message){
        super(message);
    }
}

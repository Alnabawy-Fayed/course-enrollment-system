package com.example.courseenrollmentsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.IM_USED)
public class ThisEmailIsUsedBefore extends RuntimeException{
    public ThisEmailIsUsedBefore(String message){
        super(message);
    }

}

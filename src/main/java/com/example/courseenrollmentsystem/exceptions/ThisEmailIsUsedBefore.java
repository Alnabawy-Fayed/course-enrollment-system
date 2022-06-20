package com.example.courseenrollmentsystem.exceptions;

public class ThisEmailIsUsedBefore extends RuntimeException{
    public ThisEmailIsUsedBefore(String message){
        super(message);
    }

}

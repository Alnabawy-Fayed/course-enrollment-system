package com.example.courseenrollmentsystem.exceptions;

public class WrongPassword extends RuntimeException{
    public WrongPassword(String message){
        super(message);
    }
}

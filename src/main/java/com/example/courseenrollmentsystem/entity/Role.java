package com.example.courseenrollmentsystem.entity;

public enum Role {
    USER,ADMIN;
    public String getRole(){
        return this.name();
    }
}

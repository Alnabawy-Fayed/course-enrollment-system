package com.example.courseenrollmentsystem.controller;

import com.example.courseenrollmentsystem.entity.Student;
import com.example.courseenrollmentsystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    @Autowired
    private  RegistrationService registrationService;
    @PostMapping("/register")
    public void register(@RequestBody Student student){
        registrationService.register(student);
    }
}

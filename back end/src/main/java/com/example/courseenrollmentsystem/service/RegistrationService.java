package com.example.courseenrollmentsystem.service;

import com.example.courseenrollmentsystem.dto.RegistrationRequest;
import com.example.courseenrollmentsystem.entity.Student;

public interface RegistrationService {
     void register(RegistrationRequest request);
}

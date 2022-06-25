package com.example.courseenrollmentsystem.service;

import com.example.courseenrollmentsystem.dao.StudentRepository;
import com.example.courseenrollmentsystem.dto.RegistrationRequest;
import com.example.courseenrollmentsystem.entity.Student;
import com.example.courseenrollmentsystem.exceptions.ThisEmailIsUsedBefore;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@AllArgsConstructor
@Transactional
public class RegistrationServiceImpl implements RegistrationService{
    private StudentRepository studentRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void register(RegistrationRequest request) {
        String email = request.getEmail();
        Student studentDB = studentRepository.findByEmail(email);
        if(studentDB != null)
            throw new ThisEmailIsUsedBefore("this email is used before");
        String password = request.getPassword();
        String endcodedPassword = bCryptPasswordEncoder.encode(password);
        request.setPassword(endcodedPassword);
        Student student = new Student(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword());
        studentRepository.save(student);

    }
}

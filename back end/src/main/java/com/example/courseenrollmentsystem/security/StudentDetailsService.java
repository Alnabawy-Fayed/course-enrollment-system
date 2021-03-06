
package com.example.courseenrollmentsystem.security;

import com.example.courseenrollmentsystem.dao.StudentRepository;
import com.example.courseenrollmentsystem.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;
    @ExceptionHandler(UsernameNotFoundException.class)
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(name);

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(student.getRole());
        return new StudentDetails(student.getFirstName(),student.getEmail(),student.getPassword(), Collections.singleton(authority)) ;
    }
}

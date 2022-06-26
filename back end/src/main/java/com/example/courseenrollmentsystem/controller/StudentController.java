package com.example.courseenrollmentsystem.controller;

import com.example.courseenrollmentsystem.dto.SubscriptionRequest;
import com.example.courseenrollmentsystem.entity.Course;
import com.example.courseenrollmentsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private CourseService courseService;
    @GetMapping("/courses/{id}")
    public List<Course> getMyCourses(@PathVariable("id") long id){
        return courseService.getMyCourses(id);
    }
    @PostMapping("/subscribe")
    public void enrol(@RequestBody SubscriptionRequest request){
        courseService.subscribe(request.getStudentId(),request.getCourseId());
    }
    @PostMapping("/unsubscribe")
    public void unEnrol(@RequestBody SubscriptionRequest request){
        courseService.unSubscribe(request.getStudentId(),request.getCourseId());
    }

}

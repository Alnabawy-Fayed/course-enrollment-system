package com.example.courseenrollmentsystem.controller;

import com.example.courseenrollmentsystem.dao.CategoryRepository;
import com.example.courseenrollmentsystem.entity.Category;
import com.example.courseenrollmentsystem.entity.Course;
import com.example.courseenrollmentsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private CourseService courseService;
    @Autowired
    CategoryRepository categoryRepository;
    @PostMapping("/course")
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }
    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable("id") long id){
        courseService.deleteCourse(id);
    }
    @PostMapping("/category")
    public void addCategory(@RequestBody Category category){
        categoryRepository.save(category);
    }
}

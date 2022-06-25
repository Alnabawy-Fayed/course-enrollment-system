package com.example.courseenrollmentsystem.controller;

import com.example.courseenrollmentsystem.dao.CategoryRepository;
import com.example.courseenrollmentsystem.dao.TeacherRepository;
import com.example.courseenrollmentsystem.entity.Category;
import com.example.courseenrollmentsystem.entity.Course;
import com.example.courseenrollmentsystem.entity.Teacher;
import com.example.courseenrollmentsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherRepository teacherRepository;
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
    @PostMapping("/teacher")
    @Transactional
    public void addTeacher(@RequestBody Teacher teacher){
        teacherRepository.save(teacher);
    }

    @PostMapping("/teacher/{id}")
    @Transactional
    public void deleteTeacher(@PathVariable("id") long id){
        teacherRepository.deleteById(id);
    }
}

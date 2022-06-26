package com.example.courseenrollmentsystem.service;

import com.example.courseenrollmentsystem.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    void addCourse(Course course);
    void deleteCourse(Long id);
    void subscribe(Long studentId,Long courseId);
    void unSubscribe(Long studentId, Long courseId);
    List<Course> getMyCourses(Long id);
}

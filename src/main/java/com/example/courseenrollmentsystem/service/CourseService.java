package com.example.courseenrollmentsystem.service;

import com.example.courseenrollmentsystem.entity.Course;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    void deleteCourse(long id);
    void subscribe(long studentId,long courseId);
    void unSubscribe(long studentId, long courseId);
    List<Course> getMyCourses(long id);
}

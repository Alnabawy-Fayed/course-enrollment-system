package com.example.courseenrollmentsystem.service;

import com.example.courseenrollmentsystem.dao.CourseRepository;
import com.example.courseenrollmentsystem.dao.StudentCourseRepo;
import com.example.courseenrollmentsystem.dao.StudentRepository;
import com.example.courseenrollmentsystem.entity.Course;
import com.example.courseenrollmentsystem.entity.Student;
import com.example.courseenrollmentsystem.entity.StudentCourse;
import com.example.courseenrollmentsystem.entity.StudentCoursePK;
import com.example.courseenrollmentsystem.exceptions.CourseNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService{
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private StudentCourseRepo studentCourseRepo;
    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.findById(id).orElseThrow(() -> new CourseNotFound("this course is not found"));
        courseRepository.deleteById(id);
    }

    @Override
    public void subscribe(Long studentId, Long courseId) {
        StudentCourse studentCourse = new StudentCourse(new StudentCoursePK(studentId,courseId));
        studentCourseRepo.save(studentCourse);

    }

    @Override
    public void unSubscribe(Long studentId, Long courseId) {
        studentCourseRepo.deleteById(studentId,courseId);
    }

    @Override
    public List<Course> getMyCourses(Long id) {
        return  courseRepository.findAllCourses(id);
    }
}

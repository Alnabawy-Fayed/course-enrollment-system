package com.example.courseenrollmentsystem.service;

import com.example.courseenrollmentsystem.dao.CourseRepository;
import com.example.courseenrollmentsystem.dao.StudentRepository;
import com.example.courseenrollmentsystem.entity.Course;
import com.example.courseenrollmentsystem.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService{
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void subscribe(long studentId, long courseId) {
        Student student = studentRepository.findById(studentId);
        Course course = courseRepository.findById(courseId);
        student.getCourses().add(course);
        studentRepository.save(student);

    }

    @Override
    public void unSubscribe(long studentId, long courseId) {
        Student student = studentRepository.findById(studentId);
        List<Course> courses = student.getCourses();
        for(Course course : courses){
            if(course.getId() == courseId){
                courses.remove(course);
                break;
            }
            studentRepository.save(student);
        }
    }

    @Override
    public List<Course> getMyCourses(long id) {
        Student student = studentRepository.findById(id);
        return student.getCourses();
    }
}

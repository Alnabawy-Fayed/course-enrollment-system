package com.example.courseenrollmentsystem.dao;

import com.example.courseenrollmentsystem.entity.Course;
import com.example.courseenrollmentsystem.entity.StudentCourse;
import com.example.courseenrollmentsystem.entity.StudentCoursePK;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface StudentCourseRepo extends JpaRepository<StudentCourse, StudentCoursePK> {

    @Modifying
    @Query(value = "update student_course set is_active = 0 where (student_id = ?1 and course_id = ?2)",nativeQuery = true)
    void deleteById(Long studentId,Long courseId);

}

package com.example.courseenrollmentsystem.dao;

import com.example.courseenrollmentsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    void deleteById(Long id);
    Optional<Course> findById(Long id);
}

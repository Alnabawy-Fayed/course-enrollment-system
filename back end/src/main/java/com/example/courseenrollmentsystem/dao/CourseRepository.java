package com.example.courseenrollmentsystem.dao;

import com.example.courseenrollmentsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    void deleteById(long id);

    @Query()
    Course findById(long id);
}

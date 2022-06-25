package com.example.courseenrollmentsystem.dao;

import com.example.courseenrollmentsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}

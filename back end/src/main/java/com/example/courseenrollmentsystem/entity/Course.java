package com.example.courseenrollmentsystem.entity;

import com.example.courseenrollmentsystem.dao.CategoryRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_at")
    private String start;

    @Column(name = "end_at")
    private String end;

    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "price")
    private double price;

    @JoinColumn(name = "category_id")
    private long categoryId;

    @JoinColumn(name = "teacher_id")
    private long teacherId;


    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();


    public Course(String name, String start, String end, String courseCode, double price,long teacherId, long categoryId) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.courseCode = courseCode;
        this.price = price;
        this.teacherId = teacherId;
        this.categoryId = categoryId;
    }
}

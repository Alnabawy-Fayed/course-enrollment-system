package com.example.courseenrollmentsystem.entity;

import com.example.courseenrollmentsystem.dao.CategoryRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "course")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private Instant startAt;

    private Instant endAt;

    @Column(name = "course_code")
    private String code;


    private Double price;

    @JoinColumn(name = "category_id")
    private Long categoryId;

    @JoinColumn(name = "teacher_id")
    private Long teacherId;


    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();


    public Course(String name, Instant start, Instant end, String code, Double price,Long teacherId, Long categoryId) {
        this.name = name;
        this.startAt = start;
        this.endAt = end;
        this.code = code;
        this.price = price;
        this.teacherId = teacherId;
        this.categoryId = categoryId;
    }
}

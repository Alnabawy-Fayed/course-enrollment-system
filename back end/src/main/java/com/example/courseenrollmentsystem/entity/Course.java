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
import java.util.Date;
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


    private String startAt;

    private String endAt;

    @Column(name = "course_code")
    private String code;


    private Double price;

    @JoinColumn(name = "category_id")
    private Long categoryId;

    @JoinColumn(name = "teacher_id")
    private Long teacherId;

    public Course(String name, String  start, String  end, String code, Double price, Long teacherId, Long categoryId) {
        this.name = name;
        this.startAt = start;
        this.endAt = end;
        this.code = code;
        this.price = price;
        this.teacherId = teacherId;
        this.categoryId = categoryId;
    }
    public Course(Long id,String name, String start, String end, String code, Double price,Long teacherId, Long categoryId) {
        this.id = id;
        this.name = name;
        this.startAt = start;
        this.endAt = end;
        this.code = code;
        this.price = price;
        this.teacherId = teacherId;
        this.categoryId = categoryId;
    }
}

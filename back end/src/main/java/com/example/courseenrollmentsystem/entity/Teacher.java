package com.example.courseenrollmentsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private String email;

//    @OneToMany(mappedBy = "teacher")
//    List<Course> courses = new ArrayList<>();

    public Teacher(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

package com.example.courseenrollmentsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role  = Role.USER.name();

    @ManyToMany(fetch = FetchType.EAGER,cascade =CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "id")})
    List<Course> courses = new ArrayList<>();

    public Student(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }
}

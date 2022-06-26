package com.example.courseenrollmentsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "student_course")
public class StudentCourse implements Serializable {
   @EmbeddedId
   StudentCoursePK id;
    private boolean isActive = Boolean.TRUE;
    @CreationTimestamp
    private Date subscriptionDate;
    @UpdateTimestamp
    private Date lastUpdate;
    public StudentCourse(StudentCoursePK id){
        this.id = id;
    }
}

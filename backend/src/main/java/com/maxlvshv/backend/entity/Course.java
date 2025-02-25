package com.maxlvshv.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private Department department;
//
//    @ManyToMany
//    @JoinTable(
//            name = "student_course",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id")
//    )
//    private List<Student> students;

    private LocalDateTime createdAt = LocalDateTime.now();
}

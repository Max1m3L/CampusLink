package com.maxlvshv.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String message;
    private String status = "Рассмотрение";
    private LocalDateTime createdAt = LocalDateTime.now();

    public void setJob(Job job) {
        this.job = job;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

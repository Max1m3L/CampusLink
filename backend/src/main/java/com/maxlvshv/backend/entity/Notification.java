package com.maxlvshv.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;

    private String message;
    private boolean isRead = false;

    private LocalDateTime createdAt = LocalDateTime.now();
}

package com.maxlvshv.backend.repository;

import com.maxlvshv.backend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
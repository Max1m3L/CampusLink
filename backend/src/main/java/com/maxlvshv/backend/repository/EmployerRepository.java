package com.maxlvshv.backend.repository;

import com.maxlvshv.backend.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
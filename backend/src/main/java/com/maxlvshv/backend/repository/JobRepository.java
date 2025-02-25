package com.maxlvshv.backend.repository;

import com.maxlvshv.backend.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByTitleContainingAndType(String title, String type);
    List<Job> findByTitleContaining(String title);
    List<Job> findByType(String type);

    @Query("SELECT DISTINCT j.type FROM Job j")
    List<String> findDistinctTypes();
}
package com.maxlvshv.backend.repository;

import com.maxlvshv.backend.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
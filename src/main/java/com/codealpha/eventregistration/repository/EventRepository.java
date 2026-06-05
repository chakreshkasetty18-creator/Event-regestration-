package com.codealpha.eventregistration.repository;

import com.codealpha.eventregistration.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    boolean existsByEventNameAndEventDate(String eventName, LocalDate eventDate);
    List<Event> findByEventName(String eventName);
    List<Event> findByEventDate(LocalDate eventDate);
}

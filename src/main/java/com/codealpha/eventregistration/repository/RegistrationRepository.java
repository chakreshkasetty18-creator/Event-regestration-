package com.codealpha.eventregistration.repository;

import com.codealpha.eventregistration.entity.Event;
import com.codealpha.eventregistration.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    boolean existsByEmailAndEvent(String email, Event event);
}

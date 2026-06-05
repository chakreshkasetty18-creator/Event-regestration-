package com.codealpha.eventregistration.controller;

import com.codealpha.eventregistration.entity.Registration;
import com.codealpha.eventregistration.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/event/{eventId}")
    public Registration registerUser(
            @PathVariable Long eventId,
            @Valid @RequestBody Registration registration) {

        return registrationService.registerUser(eventId, registration);
    }

    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }

    @GetMapping("/{id}")
    public Registration getRegistrationById(@PathVariable Long id) {
        return registrationService.getRegistrationById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return "Registration deleted successfully";
    }
}

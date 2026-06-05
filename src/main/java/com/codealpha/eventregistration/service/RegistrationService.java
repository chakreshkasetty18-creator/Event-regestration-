package com.codealpha.eventregistration.service;

import com.codealpha.eventregistration.entity.Event;
import com.codealpha.eventregistration.entity.Registration;
import com.codealpha.eventregistration.repository.EventRepository;
import com.codealpha.eventregistration.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private RegistrationRepository registrationRepository;
    public Registration registerUser(Long id,Registration registration){
        Event event=eventService.getEventById(id);
        if(!event.isBookingsOpen()){
            throw new RuntimeException("Bookings are closed");
        }
        if(event.getSlotsAvailable()==0){
            throw new RuntimeException("Sorry,seats are not available");
        }
        if(registrationRepository.existsByEmailAndEvent(registration.getEmail(), event)){
            throw new RuntimeException("Already registered");
        }
        registration.setEvent(event);
        event.setSlotsAvailable(event.getSlotsAvailable()-1);
        eventRepository.save(event);
       return registrationRepository.save(registration);
    }
    public List<Registration> getAllRegistrations(){
        return registrationRepository.findAll();
    }
    public Registration getRegistrationById(Long id){
        return registrationRepository.findById(id).orElseThrow(() -> new RuntimeException("Registration does not exist"));
    }
    public void  deleteRegistration(Long registrationId){
        Registration registration=getRegistrationById(registrationId);
        Event event=registration.getEvent();
        event.setSlotsAvailable(event.getSlotsAvailable()+1);
        eventRepository.save(event);
        registrationRepository.deleteById(registrationId);
    }
}

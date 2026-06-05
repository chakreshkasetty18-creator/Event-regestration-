package com.codealpha.eventregistration.service;


import com.codealpha.eventregistration.entity.Event;
import com.codealpha.eventregistration.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    public Event createEvent(Event event){
        if((eventRepository.existsByEventNameAndEventDate(event.getEventName(),event.getEventDate()))){
            throw new RuntimeException("Event Already Exists");
        }
        event.setSlotsAvailable(event.getCapacity());
        event.setBookingsOpen(true);
        return eventRepository.save(event);
    }
    public Event getEventById(Long id){
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }
    public List<Event> getEventsByName(String eventName){
        return eventRepository.findByEventName(eventName);
    }
    public List<Event> getEventsByDate(LocalDate eventDate){
        return eventRepository.findByEventDate(eventDate);
    }
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }
    public void deleteEvent(Long id){
        eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event Not Found"));
        eventRepository.deleteById(id);
    }
    public Event closeBookings(Long id){
        Event event=getEventById(id);
        event.setBookingsOpen(false);
        return eventRepository.save(event);
    }

}

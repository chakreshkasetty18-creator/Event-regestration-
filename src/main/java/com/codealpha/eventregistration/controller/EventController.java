package com.codealpha.eventregistration.controller;

import com.codealpha.eventregistration.entity.Event;
import com.codealpha.eventregistration.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;
    @PostMapping
    public Event createEvent(@Valid @RequestBody Event event){
        return eventService.createEvent(event);
    }
    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id){
        return eventService.getEventById(id);
    }
    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }
    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable Long id){
        eventService.deleteEvent(id);
    }
    @GetMapping("/name/{eventName}")
    public List<Event> getEventsByName(@PathVariable String eventName){
        return eventService.getEventsByName(eventName);
    }
    @GetMapping("/date/{eventDate}")
    public List<Event> getEventsByDate(@PathVariable LocalDate eventDate){
        return eventService.getEventsByDate(eventDate);
    }

}

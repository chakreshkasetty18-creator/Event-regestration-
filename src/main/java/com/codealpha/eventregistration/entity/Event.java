package com.codealpha.eventregistration.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String eventName;
    @NotNull
    private LocalDate eventDate;
    private boolean bookingsOpen;
    @Positive
    private int capacity;
    @PositiveOrZero
    private int slotsAvailable;

    public Event(){

    }
    public Long getId(){

        return id;
    }
    public String getEventName(){
        return eventName;
    }
    public void setEventName(String eventName){
        this.eventName=eventName;
    }
    public LocalDate getEventDate(){
        return eventDate;
    }
    public void setEventDate(LocalDate eventDate){
        this.eventDate=eventDate;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
    public int getSlotsAvailable(){
        return slotsAvailable;
    }
    public void setSlotsAvailable(int slotsAvailable) {
        this.slotsAvailable = slotsAvailable;
    }
    public boolean isBookingsOpen(){
        return bookingsOpen;
    }
    public void setBookingsOpen(boolean bookingsOpen){
        this.bookingsOpen=bookingsOpen;
    }
}

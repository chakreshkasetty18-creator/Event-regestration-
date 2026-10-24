# Regestration Management system

## Overview

Event Registration System is a backend application developed using Spring Boot and MySQL as part of the CodeAlpha Backend Development Internship.

The system allows users to create events, register for events, view registrations, cancel registrations, and manage event availability through REST APIs.

## Technologies Used

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Postman
* Git & GitHub

## Features

### Event Management

* Create Event
* Get Event By ID
* Get All Events
* Search Events By Name
* Search Events By Date
* Delete Event

### Registration Management

* Register User for Event
* Prevent Duplicate Registrations
* View Registration Details
* View All Registrations
* Cancel Registration
* Automatic Slot Management

## API Endpoints

### Event APIs

| Method | Endpoint                 |
| ------ | ------------------------ |
| POST   | /events                  |
| GET    | /events                  |
| GET    | /events/{id}             |
| GET    | /events/name/{eventName} |
| GET    | /events/date/{eventDate} |
| DELETE | /events/{id}             |

### Registration APIs

| Method | Endpoint                       |
| ------ | ------------------------------ |
| POST   | /registrations/event/{eventId} |
| GET    | /registrations                 |
| GET    | /registrations/{id}            |
| DELETE | /registrations/{id}            |

## Database Entities

### Event

* id
* eventName
* eventDate
* bookingsOpen
* capacity
* slotsAvailable

### Registration

* id
* name
* email
* event

## Project Structure

* Controller Layer
* Service Layer
* Repository Layer
* Entity Layer
* MySQL Database

## Author

Duvvuru Chaitanya Kumar

CodeAlpha Backend Development Internship Project

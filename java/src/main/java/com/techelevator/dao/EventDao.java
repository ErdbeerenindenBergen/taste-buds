package com.techelevator.dao;

import com.techelevator.model.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EventDao {

    List<Event> findAll();

    Event getEventById(int eventId);

    Event getEventByName(String eventName);

    Event getEventByDate(LocalDate eventDate);

    Event getEventByOrganizerId(int eventOrganizerId);

    boolean create(String eventName, LocalDate eventDate);
}

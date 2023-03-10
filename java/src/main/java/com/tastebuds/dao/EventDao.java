package com.tastebuds.dao;

import com.tastebuds.model.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventDao {

    List<Event> findAll();

    int findIdByEventName(String eventName);

    Event getEventById(int eventId);

    Event getEventByName(String eventName);

    Event getEventByDate(LocalDate eventDate);

    Event getEventByOrganizerId(int eventOrganizerId);

    Event create(Event event);
}

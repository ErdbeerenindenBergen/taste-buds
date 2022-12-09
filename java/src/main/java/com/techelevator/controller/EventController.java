package com.techelevator.controller;

import com.techelevator.dao.EventDao;
import com.techelevator.model.Event;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")

@RequestMapping("event")
public class EventController {

    EventDao eventDao;

    public EventController(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    //Works in postman
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Event> getAllEvents(){ return eventDao.findAll();
    }

    //works? just getting back '1' , need to create an event to see?
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/{eventId}", method = RequestMethod.GET)
    public Event getEventById(@PathVariable int eventId) {
        return eventDao.getEventById(eventId);
    }

    //error
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/eventName", method = RequestMethod.GET)
    public Event getEventByName(@PathVariable String eventName) {
        return eventDao.getEventByName(eventName);
    }

}

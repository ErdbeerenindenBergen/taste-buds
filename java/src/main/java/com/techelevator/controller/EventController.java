package com.techelevator.controller;

import com.techelevator.security.jwt.TokenProvider;
import java.security.Principal;

import com.techelevator.dao.EventDao;
import com.techelevator.model.Event;
import com.techelevator.model.Invitation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("event")
public class EventController {

    private final TokenProvider tokenProvider;
    private final EventDao eventDao;

    public EventController(TokenProvider tokenProvider, EventDao eventDao) {
        this.tokenProvider = tokenProvider;
        this.eventDao = eventDao;
    }

    //Works in postman
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Event> getAllEvents(){ return eventDao.findAll();}

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

    //this works from frontend but will not work for me in Postman -KB
    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public Event createEvent(@RequestBody Event event) {return eventDao.create(event);}

}

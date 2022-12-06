package com.techelevator.controller;

import com.techelevator.dao.EventDao;
import com.techelevator.model.Event;
import com.techelevator.model.EventInvitation;
import com.techelevator.model.EventRestaurant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("isAuthenticated()")

@RequestMapping("event")
public class EventController {

    EventDao eventDao;

    public EventController(EventDao eventDao) {
        this.eventDao = eventDao;
    }

}

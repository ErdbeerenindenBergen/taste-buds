package com.techelevator.controller;

import com.techelevator.dao.EventRestaurantDao;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")

@RequestMapping("event")
public class EventRestaurantController {

    EventRestaurantDao eventRestaurantDao;

    public EventRestaurantController(EventRestaurantDao eventRestaurantDao) {
        this.eventRestaurantDao = eventRestaurantDao;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/{eventId}/restaurant/{restaurantId}", method = RequestMethod.POST)
    public boolean createEventRestaurant(@PathVariable("restaurantId") String yelpRestaurantId, @PathVariable("eventId")int eventId) {
        return eventRestaurantDao.createEventRestaurant(yelpRestaurantId, eventId);
    }

}

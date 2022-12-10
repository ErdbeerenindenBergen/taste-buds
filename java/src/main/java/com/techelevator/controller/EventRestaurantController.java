package com.techelevator.controller;

import com.techelevator.dao.EventRestaurantDao;
import com.techelevator.model.Business;
import com.techelevator.model.EventRestaurant;
import com.techelevator.services.IYelpBusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@PreAuthorize("isAuthenticated()")

@RequestMapping("event")
public class EventRestaurantController {

    private EventRestaurantDao eventRestaurantDao;
    private IYelpBusinessService yelpRestaurantService;

    public EventRestaurantController(EventRestaurantDao eventRestaurantDao, IYelpBusinessService yelpRestaurantService) {
        this.eventRestaurantDao = eventRestaurantDao;
        this.yelpRestaurantService = yelpRestaurantService;
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/{eventId}/restaurant/{restaurantId}", method = RequestMethod.POST)
    public boolean createEventRestaurant(@PathVariable("restaurantId") String yelpRestaurantId, @PathVariable("eventId") int eventId) {
        return eventRestaurantDao.createEventRestaurant(yelpRestaurantId, eventId);
    }

    //may not need this method, call method below this one to get all information from API
//    @PreAuthorize("hasRole('ROLE_USER')")
//    @RequestMapping(path = "/{eventId}/restaurant", method = RequestMethod.GET)
//    public List<EventRestaurant> getEventRestaurantsByEventId(@PathVariable("eventId") int eventId) {
//        return eventRestaurantDao.getEventRestaurantsByEventId(eventId);
//    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/find/{eventId}", method = RequestMethod.GET)
    public List<Business> getBusinessesByEventId(@PathVariable("eventId") int eventId) {
        List<EventRestaurant> eventRestaurants = eventRestaurantDao.getEventRestaurantsByEventId(eventId);
        return yelpRestaurantService.getBusinessesByYelpRestaurantId(eventRestaurants);
    }



}

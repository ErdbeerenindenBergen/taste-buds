package com.techelevator.controller;

import com.techelevator.dao.EventRestaurantDao;
import com.techelevator.model.Business;
import com.techelevator.model.EventRestaurant;
import com.techelevator.security.jwt.TokenProvider;
import com.techelevator.services.IYelpBusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@PreAuthorize("isAuthenticated()")

@RequestMapping("event")
public class EventRestaurantController {

    private EventRestaurantDao eventRestaurantDao;
    private IYelpBusinessService yelpRestaurantService;
    private TokenProvider tokenProvider;

    public EventRestaurantController(EventRestaurantDao eventRestaurantDao, IYelpBusinessService yelpRestaurantService, TokenProvider tokenProvider) {
        this.eventRestaurantDao = eventRestaurantDao;
        this.yelpRestaurantService = yelpRestaurantService;
        this.tokenProvider = tokenProvider;
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/restaurant/create", method = RequestMethod.POST)
    public boolean createEventRestaurant(@RequestBody EventRestaurant eventRestaurant) {
        return eventRestaurantDao.createEventRestaurant(eventRestaurant);
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/restaurant/{yelpRestaurantId}/{eventId}", method = RequestMethod.GET)
    public EventRestaurant getEventRestaurantById(@PathVariable("yelpRestaurantId") String yelpRestaurantId, @PathVariable("eventId") int eventId) {
        return eventRestaurantDao.getEventRestaurantById(yelpRestaurantId, eventId);
    }

    //may not need this method, call method below this one to get all information from API
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/{eventId}/restaurant", method = RequestMethod.GET)
    public List<EventRestaurant> getEventRestaurantsByEventId(@PathVariable("eventId") int eventId) {
        return eventRestaurantDao.getEventRestaurantsByEventId(eventId);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/{eventId}/ranked-restaurants", method = RequestMethod.GET)
    public List<Business> getRestaurantRankedListByEventId(@PathVariable("eventId") int eventId) {
        List<EventRestaurant> eventRestaurants = eventRestaurantDao.getRestaurantRankedListByEventId(eventId);
        return yelpRestaurantService.getBusinessesByYelpRestaurantId(eventRestaurants);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/find/{eventId}", method = RequestMethod.GET)
    public List<Business> getBusinessesByEventId(@PathVariable("eventId") int eventId) {
        List<EventRestaurant> eventRestaurants = eventRestaurantDao.getEventRestaurantsByEventId(eventId);
        return yelpRestaurantService.getBusinessesByYelpRestaurantId(eventRestaurants);
    }



}

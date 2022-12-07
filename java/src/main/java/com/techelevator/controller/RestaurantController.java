package com.techelevator.controller;

import com.techelevator.model.Restaurant;
import com.techelevator.services.IYelpRestaurantService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RestaurantController {

    private IYelpRestaurantService yelpRestaurantService;

    public RestaurantController(IYelpRestaurantService yelpRestaurantService) {
        this.yelpRestaurantService = yelpRestaurantService;
    }

    @RequestMapping(path="/viewRestaurants/{location}", method = RequestMethod.GET)
    public Restaurant[] getRestaurants(@PathVariable String location) {return yelpRestaurantService.getRestaurants(location);}
}

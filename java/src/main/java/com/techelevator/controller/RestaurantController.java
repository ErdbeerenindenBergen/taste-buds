package com.techelevator.controller;

import com.techelevator.model.Businesses;
import com.techelevator.services.IYelpRestaurantService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RestaurantController {

    private IYelpRestaurantService yelpRestaurantService;

    public RestaurantController(IYelpRestaurantService yelpRestaurantService) {
        this.yelpRestaurantService = yelpRestaurantService;
    }

    @RequestMapping(path="/find/{location}", method = RequestMethod.GET)
    public Businesses getBusinesses(@PathVariable String location) {return yelpRestaurantService.getBusinesses(location);}
}

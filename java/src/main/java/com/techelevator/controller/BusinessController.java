package com.techelevator.controller;

import com.techelevator.model.Business;
import com.techelevator.model.Businesses;
import com.techelevator.services.IYelpBusinessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BusinessController {

    private IYelpBusinessService yelpRestaurantService;

    public BusinessController(IYelpBusinessService yelpRestaurantService) {
        this.yelpRestaurantService = yelpRestaurantService;
    }

    @RequestMapping(path="/find/{location}", method = RequestMethod.GET)
    public List<Business> getBusinesses(@PathVariable String location) {return yelpRestaurantService.getBusinesses(location);}
}

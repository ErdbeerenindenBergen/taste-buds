package com.techelevator.services;

import com.techelevator.model.Business;
import com.techelevator.model.Businesses;
import com.techelevator.model.EventRestaurant;

import java.util.List;

public interface IYelpBusinessService {
    public List<Business> getBusinesses(String location);

    public List<Business> getBusinessesByYelpRestaurantId(List<EventRestaurant> eventRestaurants);
}

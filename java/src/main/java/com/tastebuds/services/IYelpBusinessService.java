package com.tastebuds.services;

import com.tastebuds.model.Business;
import com.tastebuds.model.EventRestaurant;

import java.util.List;

public interface IYelpBusinessService {
    public List<Business> getBusinesses(String location);

    public List<Business> getBusinessesByYelpRestaurantId(List<EventRestaurant> eventRestaurants);
}

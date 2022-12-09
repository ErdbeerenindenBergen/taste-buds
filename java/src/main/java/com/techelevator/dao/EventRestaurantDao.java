package com.techelevator.dao;

import com.techelevator.model.EventRestaurant;

import java.util.List;

public interface EventRestaurantDao {

    boolean createEventRestaurant(String yelpRestaurantId, int eventId);

    List<EventRestaurant> getRestaurantsByEventId(int eventId);

}

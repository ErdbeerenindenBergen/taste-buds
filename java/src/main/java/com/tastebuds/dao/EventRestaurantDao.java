package com.tastebuds.dao;

import com.tastebuds.model.EventRestaurant;

import java.util.List;

public interface EventRestaurantDao {

    boolean createEventRestaurant(EventRestaurant eventRestaurant);

    List<EventRestaurant> getEventRestaurantsByEventId(int eventId);

    List<EventRestaurant> getRestaurantRankedListByEventId(int eventId);

    EventRestaurant getEventRestaurantById(String yelpRestaurantId, int eventId);
}

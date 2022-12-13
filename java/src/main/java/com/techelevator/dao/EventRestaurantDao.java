package com.techelevator.dao;

import com.techelevator.model.EventRestaurant;

import java.util.List;

public interface EventRestaurantDao {

    boolean createEventRestaurant(EventRestaurant eventRestaurant);

    List<EventRestaurant> getEventRestaurantsByEventId(int eventId);

    List<EventRestaurant> getRestaurantRankedListByEventId(int eventId);

}

package com.techelevator.services;

import com.techelevator.model.Restaurant;

import java.util.List;

public interface IYelpRestaurantService {
    Restaurant[] getRestaurants(String location);
}

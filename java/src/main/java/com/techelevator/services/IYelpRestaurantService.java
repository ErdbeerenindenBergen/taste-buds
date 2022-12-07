package com.techelevator.services;

import com.techelevator.model.Businesses;

public interface IYelpRestaurantService {
    Businesses getBusinesses(String location);
}

package com.techelevator.services;

import com.techelevator.model.Businesses;

public interface IYelpBusinessService {
    Businesses getBusinesses(String location);
}

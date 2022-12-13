package com.techelevator.dao;

import com.techelevator.model.Vote;
import com.techelevator.model.EventRestaurant;

public interface VoteDao {

    public EventRestaurant updateEventRestaurantVoteCount(Vote vote);

    public void updateEventRestaurant(EventRestaurant eventRestaurant);

}

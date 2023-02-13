package com.tastebuds.dao;

import com.tastebuds.model.Vote;
import com.tastebuds.model.EventRestaurant;

public interface VoteDao {

    public EventRestaurant updateEventRestaurantVoteCount(Vote vote);

    public void updateEventRestaurant(EventRestaurant eventRestaurant);

}

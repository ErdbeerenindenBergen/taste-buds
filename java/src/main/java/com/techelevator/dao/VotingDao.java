package com.techelevator.dao;

import com.techelevator.model.Voting;

import java.time.LocalDate;
import java.time.LocalTime;



public interface VotingDao {

    Voting createVoting(String restaurantName, int thumbsUp, int thumbsDown, LocalDate decisionDate, LocalTime decisionTime);


}

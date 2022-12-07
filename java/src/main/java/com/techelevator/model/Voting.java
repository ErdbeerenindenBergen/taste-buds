package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//Are we doing a ranking system?

public class Voting {

    private String restaurantName;
    private int thumbsUp;
    private int thumbsDown;
    private LocalDate decisionDate;
    private LocalTime decisionTime;

    public Voting(String restaurantName, int thumbsUp, int thumbsDown, LocalDate decisionDate, LocalTime decisionTime) {
        this.restaurantName = restaurantName;
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
        this.decisionDate = decisionDate;
        this.decisionTime = decisionTime;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getThumbsUp() {
        return thumbsUp;
    }

    public void incrementThumbsUp() {
        thumbsUp++;
    }

    public int getThumbsDown() {
        return thumbsDown;
    }

    public void incrementThumbsDown() {
        thumbsDown++;
    }

    public LocalDate getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(LocalDate decisionDate) {
        this.decisionDate = decisionDate;
    }

    public LocalTime getDecisionTime() {
        return decisionTime;
    }

    public void setDecisionTime(LocalTime decisionTime) {
        this.decisionTime = decisionTime;
    }
}

package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Voting {

    private String restaurantId;
    private int thumbsUp;
    private int thumbsDown;
    private LocalDate decisionDate;
    private LocalTime decisionTime;

    public Voting(String restaurantName, int thumbsUp, int thumbsDown, LocalDate decisionDate, LocalTime decisionTime) {
        this.restaurantId = restaurantName;
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
        this.decisionDate = decisionDate;
        this.decisionTime = decisionTime;
    }

    public String getRestaurantName() {
        return restaurantId;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantId = restaurantName;
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

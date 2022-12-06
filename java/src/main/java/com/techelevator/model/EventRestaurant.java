package com.techelevator.model;

import javax.validation.constraints.NotNull;

public class EventRestaurant {

    @NotNull
    private String yelpRestaurantId;
    @NotNull
    private int eventId;
    @NotNull
    private int voteCount;

    public EventRestaurant(String yelpRestaurantId, int eventId, int voteCount) {
        this.yelpRestaurantId = yelpRestaurantId;
        this.eventId = eventId;
        this.voteCount = voteCount;
    }

    public String getYelpRestaurantId() {
        return yelpRestaurantId;
    }

    public void setYelpRestaurantId(String yelpRestaurantId) {
        this.yelpRestaurantId = yelpRestaurantId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}

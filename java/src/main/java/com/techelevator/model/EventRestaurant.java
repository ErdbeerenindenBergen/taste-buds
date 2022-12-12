package com.techelevator.model;

public class EventRestaurant {
    private int eventId;
    private int voteCount;
    private String yelpRestaurantId;

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

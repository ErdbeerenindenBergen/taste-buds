package com.techelevator.model;

public class Vote {

    //two booleans in case some restaurants are not voted on
    //if isApproved is true, tally is incremented by 1
    //if isApproved is false, nothing happens
//    private boolean isApproved;

    //if isRejected is true, tally is decremented by 1
    //if isRejected is false, nothing happens
//    private boolean isRejected;

    private String yelpRestaurantId;
    private int eventId;
    private int voteCount;

    public Vote() {
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
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
}

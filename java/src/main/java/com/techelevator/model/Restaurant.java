package com.techelevator.model;

public class Restaurant {

    private String restaurantName;
    private String restaurantType;
    private String restaurantAddress;
    private String hoursOfOperation;
    private int stars;
    private String phoneNumber;
    private boolean hasTakeout;
    private boolean hasDelivery;
    private boolean isOpen;
    private String thumbnailImageURL;


    public Restaurant(String restaurantName, String restaurantType, String restaurantAddress, String hoursOfOperation, int stars, String phoneNumber, boolean hasTakeout, boolean hasDelivery, boolean isOpen, String thumbnailImageURL) {
        this.restaurantName = restaurantName;
        this.restaurantType = restaurantType;
        this.restaurantAddress = restaurantAddress;
        this.hoursOfOperation = hoursOfOperation;
        this.stars = stars;
        this.phoneNumber = phoneNumber;
        this.hasTakeout = hasTakeout;
        this.hasDelivery = hasDelivery;
        this.isOpen = isOpen;
        this.thumbnailImageURL = thumbnailImageURL;
    }
    public Restaurant(){}

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantType() {
        return restaurantType;
    }

    public void setRestaurantType(String restaurantType) {
        this.restaurantType = restaurantType;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getHoursOfOperation() {
        return hoursOfOperation;
    }

    public void setHoursOfOperation(String hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isHasTakeout() {
        return hasTakeout;
    }

    public void setHasTakeout(boolean hasTakeout) {
        this.hasTakeout = hasTakeout;
    }

    public boolean isHasDelivery() {
        return hasDelivery;
    }

    public void setHasDelivery(boolean hasDelivery) {
        this.hasDelivery = hasDelivery;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getThumbnailImageURL() {
        return thumbnailImageURL;
    }

    public void setThumbnailImageURL(String thumbnailImageURL) {
        this.thumbnailImageURL = thumbnailImageURL;
    }
}

package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Business {

    @JsonIgnoreProperties(ignoreUnknown = true)

    @JsonProperty("name")
    private String restaurantName;
//    private String restaurantType;
    @JsonProperty("stringAddress")
    private String restaurantAddress;
    @JsonProperty("id")
    private String id;
//    private String hoursOfOperation;
    @JsonProperty("rating")
    private double stars;
    @JsonProperty("phone")
    private String phoneNumber;
//    private boolean hasTakeout;
//    private boolean hasDelivery;
    @JsonProperty("is_closed")
    private boolean isClosed;
    @JsonProperty("image_url")
    private String thumbnailImageURL;
    private String url;


    public Business(String restaurantName, String restaurantAddress, int stars, String phoneNumber, boolean isClosed, String thumbnailImageURL) {
        this.restaurantName = restaurantName;
//        this.restaurantType = restaurantType;
        this.restaurantAddress = restaurantAddress;
//        this.hoursOfOperation = hoursOfOperation;
        this.stars = stars;
        this.phoneNumber = phoneNumber;
//        this.hasTakeout = hasTakeout;
//        this.hasDelivery = hasDelivery;
        this.isClosed = isClosed;
        this.thumbnailImageURL = thumbnailImageURL;
    }
    public Business(){}

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

//    public String getRestaurantType() {
//        return restaurantType;
//    }
//
//    public void setRestaurantType(String restaurantType) {
//        this.restaurantType = restaurantType;
//    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

//    public String getHoursOfOperation() {
//        return hoursOfOperation;
//    }
//
//    public void setHoursOfOperation(String hoursOfOperation) {
//        this.hoursOfOperation = hoursOfOperation;
//    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public boolean isHasTakeout() {
//        return hasTakeout;
//    }
//
//    public void setHasTakeout(boolean hasTakeout) {
//        this.hasTakeout = hasTakeout;
//    }
//
//    public boolean isHasDelivery() {
//        return hasDelivery;
//    }
//
//    public void setHasDelivery(boolean hasDelivery) {
//        this.hasDelivery = hasDelivery;
//    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public String getThumbnailImageURL() {
        return thumbnailImageURL;
    }

    public void setThumbnailImageURL(String thumbnailImageURL) {
        this.thumbnailImageURL = thumbnailImageURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String restaurantWebsite) {
        this.url = restaurantWebsite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}

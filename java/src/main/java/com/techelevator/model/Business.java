package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Business {

    @JsonIgnoreProperties(ignoreUnknown = true)

    @JsonProperty("name")
    private String restaurantName;
    @JsonProperty("stringAddress")
    private String restaurantAddress;
    @JsonProperty("id")
    private String id;
    @JsonProperty("rating")
    private double stars;
    @JsonProperty("phone")
    private String phoneNumber;
    @JsonProperty("is_closed")
    private boolean isClosed;
    @JsonProperty("image_url")
    private String thumbnailImageURL;
    private String url;


    public Business(String restaurantName, String restaurantAddress, int stars, String phoneNumber, boolean isClosed, String thumbnailImageURL) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.stars = stars;
        this.phoneNumber = phoneNumber;
        this.isClosed = isClosed;
        this.thumbnailImageURL = thumbnailImageURL;
    }
    public Business(){}

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return this.restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public double getStars() {
        return this.stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public void setClosed(boolean closed) {
        this.isClosed = closed;
    }

    public String getThumbnailImageURL() {
        return this.thumbnailImageURL;
    }

    public void setThumbnailImageURL(String thumbnailImageURL) {
        this.thumbnailImageURL = thumbnailImageURL;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String restaurantWebsite) {
        this.url = restaurantWebsite;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Business {

    @JsonIgnoreProperties(ignoreUnknown = true)

    @JsonProperty("name")
    private String restaurantName;
    @JsonProperty("id")
    private String id;
    @JsonProperty("rating")
    private double stars;
    @JsonProperty("phone")
    private String phoneNumber;
    @JsonProperty("display_phone")
    private String displayPhoneNumber;
    @JsonProperty("is_closed")
    private boolean isClosed;
    @JsonProperty("image_url")
    private String thumbnailImageURL;
    private String url;
    private BusinessLocation location;
    private List<BusinessCategories> categories;
    private BusinessCoordinates coordinates;

    public Business(String restaurantName, int stars, String phoneNumber, boolean isClosed, String thumbnailImageURL) {
        this.restaurantName = restaurantName;
        this.stars = stars;
        this.phoneNumber = phoneNumber;
        this.isClosed = isClosed;
        this.thumbnailImageURL = thumbnailImageURL;
    }
    public Business(){}

    public String getDisplayPhoneNumber() {
        return displayPhoneNumber;
    }

    public void setDisplayPhoneNumber(String displayPhoneNumber) {
        this.displayPhoneNumber = displayPhoneNumber;
    }

    public BusinessLocation getLocation() {
        return location;
    }

    public List<BusinessCategories> getCategories() {
        return categories;
    }

    public void setCategories(List<BusinessCategories> categories) {
        this.categories = categories;
    }

    public void setLocation(BusinessLocation location) {
        this.location = location;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
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

    public BusinessCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(BusinessCoordinates coordinates) {
        this.coordinates = coordinates;
    }
}

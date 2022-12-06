package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    private int eventId;
    private String eventName;
    private String eventCity;
    private String eventState;
    private int zipcode;
    private String userLatitude;
    private String userLongitude;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private int eventOrganizerId;
    private LocalDate deadlineDate;
    private LocalTime deadlineTime;

    public Event(int eventId, String eventName, String eventCity, String eventState, int zipcode, LocalDate eventDate, LocalTime eventTime, int eventOrganizerId) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventCity = eventCity;
        this.eventState = eventState;
        this.zipcode = zipcode;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventOrganizerId = eventOrganizerId;
    }

    public Event(){}

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventCity() {
        return eventCity;
    }

    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    public String getEventState() {
        return eventState;
    }

    public void setEventState(String eventState) {
        this.eventState = eventState;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(String userLatitude) {
        this.userLatitude = userLatitude;
    }

    public String getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(String userLongitude) {
        this.userLongitude = userLongitude;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public int getEventOrganizerId() {
        return eventOrganizerId;
    }

    public void setEventOrganizerId(int eventOrganizerId) {
        this.eventOrganizerId = eventOrganizerId;
    }

    public LocalDate getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public LocalTime getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(LocalTime deadlineTime) {
        this.deadlineTime = deadlineTime;
    }
}

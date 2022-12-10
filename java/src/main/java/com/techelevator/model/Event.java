package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    private Integer eventId;
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

    public Event(String eventName, LocalDate eventDate, LocalTime eventTime, int eventOrganizerId, LocalDate deadlineDate, LocalTime deadlineTime) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventOrganizerId = eventOrganizerId;
        this.deadlineDate = deadlineDate;
        this.deadlineTime = deadlineTime;
    }

    public Event(){}

    public int getEventId() {
        return this.eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventCity() {
        return this.eventCity;
    }

    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    public String getEventState() {
        return this.eventState;
    }

    public void setEventState(String eventState) {
        this.eventState = eventState;
    }

    public int getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getUserLatitude() {
        return this.userLatitude;
    }

    public void setUserLatitude(String userLatitude) {
        this.userLatitude = userLatitude;
    }

    public String getUserLongitude() {
        return this.userLongitude;
    }

    public void setUserLongitude(String userLongitude) {
        this.userLongitude = userLongitude;
    }

    public LocalDate getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return this.eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public int getEventOrganizerId() {
        return this.eventOrganizerId;
    }

    public void setEventOrganizerId(int eventOrganizerId) {
        this.eventOrganizerId = eventOrganizerId;
    }

    public LocalDate getDeadlineDate() {
        return this.deadlineDate;
    }

    public void setDeadlineDate(LocalDate deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public LocalTime getDeadlineTime() {
        return this.deadlineTime;
    }

    public void setDeadlineTime(LocalTime deadlineTime) {
        this.deadlineTime = deadlineTime;
    }
}

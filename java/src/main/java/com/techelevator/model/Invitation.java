package com.techelevator.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Invitation {

    private int invitationId;
    private String location;
    private String zipCode;
    private Date decisionDate;
    private Time decisionTime;
    private List<String> guestList;
    private List<String> restaurantOptions;
    private String uniqueInvitationLink;
    private String emailAddress;

    public Invitation(int invitationId, String location, String zipCode, Date decisionDate, Time decisionTime,
                      List<String> guestList, List<String> restaurantOptions, String uniqueInvitationLink, String emailAddress) {
        this.invitationId = invitationId;
        this.location = location;
        this.zipCode = zipCode;
        this.decisionDate = decisionDate;
        this.decisionTime = decisionTime;
        this.guestList = guestList;
        this.restaurantOptions = restaurantOptions;
        this.uniqueInvitationLink = uniqueInvitationLink;

    }

    public Invitation() {}

    public int getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(int inviteId) {
        this.invitationId = inviteId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    public Time getDecisionTime() {
        return decisionTime;
    }

    public void setDecisionTime(Time decisionTime) {
        this.decisionTime = decisionTime;
    }

    public List<String> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<String> guestList) {
        this.guestList = guestList;
    }

    public List<String> getRestaurantOptions() {
        return restaurantOptions;
    }

    public void setRestaurantOptions(List<String> restaurantOptions) {
        this.restaurantOptions = restaurantOptions;
    }

    public String getUniqueInvitationLink() {
        return uniqueInvitationLink;
    }

    public void setUniqueInvitationLink(String uniqueInvitationLink) {
        this.uniqueInvitationLink = uniqueInvitationLink;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}

package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Invitation {

    private String inviter; //Do I want to make this 'int senderId/inviterId? If so, change in InvitationDao as well
    private int inviteId;
    private String location;
    private String zipCode;
    private LocalDate decisionDate;
    private LocalTime decisionTime;
    private List<String> guestList;
    private List<String> restaurantOptions;
    private String uniqueInvitationLink;
    private String emailAddress;

    public Invitation(String inviter, int inviteId, String location, String zipCode, LocalDate decisionDate, LocalTime decisionTime,
                      List<String> guestList, List<String> restaurantOptions, String uniqueInvitationLink, String emailAddress) {
        this.inviter = inviter;
        this.inviteId = inviteId;
        this.location = location;
        this.zipCode = zipCode;
        this.decisionDate = decisionDate;
        this.decisionTime = decisionTime;
        this.guestList = guestList;
        this.restaurantOptions = restaurantOptions;
        this.uniqueInvitationLink = uniqueInvitationLink;
        this.emailAddress = emailAddress;
    }

    public Invitation() {}

    public String getInviter() {
        return inviter;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
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

    public LocalDate getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(LocalDate decisionDate) {
        this.decisionDate = decisionDate;
    }

    public LocalTime getDecisionTime() {
        return decisionTime;
    }

    public void setDecisionTime(LocalTime decisionTime) {
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

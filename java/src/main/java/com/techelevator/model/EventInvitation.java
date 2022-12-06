package com.techelevator.model;

import javax.validation.constraints.NotNull;

public class EventInvitation {

    @NotNull
    private int invitationId;
    @NotNull
    private int eventId;
    @NotNull
    private boolean hasVoted;
    private String username;
    private String recipientEmailAddress;

    public EventInvitation(int eventId, boolean hasVoted, String username, String recipientEmailAddress) {
        this.eventId = eventId;
        this.hasVoted = hasVoted;
        this.username = username;
        this.recipientEmailAddress = recipientEmailAddress;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRecipientEmailAddress() {
        return recipientEmailAddress;
    }

    public void setRecipientEmailAddress(String recipientEmailAddress) {
        this.recipientEmailAddress = recipientEmailAddress;
    }
}

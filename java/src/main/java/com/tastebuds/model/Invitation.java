package com.tastebuds.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class Invitation {

    private int invitationId;
    private int eventId;
    private String emailAddress;
    private boolean hasVoted;

    public Invitation(int invitationId, int eventId, String emailAddress, boolean hasVoted) {
        this.invitationId = invitationId;
        this.eventId = eventId;
        this.emailAddress = emailAddress;
        this.hasVoted = hasVoted;
    }

    public Invitation() {
    }

    public int getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(int invitationId) {
        this.invitationId = invitationId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}

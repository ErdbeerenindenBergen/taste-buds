package com.techelevator.dao;

import com.techelevator.model.Invitation;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface InvitationDao {

    List<Invitation> findAll();

    Invitation getInvitationByUniqueLink(String uniqueInvitationLink);

    void updateInvitation(Invitation invitation);

    void deleteInvitation(Invitation invitation);

    Invitation createInvitation(String inviter, String location, String zipCode, LocalDate decisionDate, LocalTime decisionTime, List<String> guestList,
                                List<String> restaurantOptions, String uniqueInvitationLink, String emailAddress); //Don't think this needs all this?

    Invitation getInvitationByInviter(String inviter);

    Invitation getInvitationByInviteId(int inviteId);

    List<Invitation> getAllInvitationsByInviter(String inviter);

}

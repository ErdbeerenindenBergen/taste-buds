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

    boolean createInvitation(Invitation invitation); //??

    Invitation getInvitationByInviter(String inviter);

    Invitation getInvitationByInviteId(int inviteId);

    List<Invitation> getAllInvitationsByInviter(String inviter);

}

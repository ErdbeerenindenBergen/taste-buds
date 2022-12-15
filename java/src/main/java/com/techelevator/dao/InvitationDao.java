package com.techelevator.dao;

import com.techelevator.model.Invitation;

import java.util.List;

public interface InvitationDao {

    List<Invitation> findAll();

    Invitation createInvitation(Invitation invitation);

    Invitation getInvitationByInvitationId(Integer invitationId);

    Invitation getInvitationByUserId(int userId);

    void updateHasVoted(int invitationId);

}

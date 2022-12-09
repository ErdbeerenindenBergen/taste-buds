package com.techelevator.dao;

import com.techelevator.model.Invitation;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface InvitationDao {

    List<Invitation> findAll();

    boolean createInvitation(Invitation invitation);

    Invitation getInvitationByInvitationId(int invitationId);

    Invitation getInvitationByUserId(int userId);

}

package com.techelevator.controller;

import com.techelevator.dao.EventDao;
import com.techelevator.dao.InvitationDao;
import com.techelevator.model.Event;
import com.techelevator.model.EventRestaurant;
import com.techelevator.model.Invitation;
import com.techelevator.model.Vote;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")

@RequestMapping("invitation")
public class InvitationController {

    private final InvitationDao invitationDao;
    private final TokenProvider tokenProvider;

    public InvitationController(TokenProvider tokenProvider, InvitationDao invitationDao) {
        this.tokenProvider = tokenProvider;
        this.invitationDao = invitationDao;
    }

    //Looks to work in postman
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Invitation> getAllInvitations() {
        return invitationDao.findAll();
    }

    //Just getting '1' back? may need to create an invitation to really check?
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/{invitationId}", method = RequestMethod.GET)
    public Invitation getInvitationByInvitationId(@PathVariable int invitationId) {
        return invitationDao.getInvitationByInvitationId(invitationId);
    }

    //Just getting '1' back? may need to create an invitation to really check? (AGAIN)
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/UserInvites/{userId}", method = RequestMethod.GET)
    public Invitation getInvitationByUserId(@PathVariable int userId) {
        return invitationDao.getInvitationByUserId(userId);
    }

    //Still need to figure out sql for this, but I'm pretty sure this is how it should look here
    //Thanks for all this awesome work! I think I fixed this in the back.
    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public Invitation createInvitation(@RequestBody Invitation invitation) {
        return invitationDao.createInvitation(invitation);
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "/vote-submitted/{invitationId}", method = RequestMethod.PUT)
    public void updateHasVoted(@PathVariable int invitationId) {
        invitationDao.updateHasVoted(invitationId);
    }

}

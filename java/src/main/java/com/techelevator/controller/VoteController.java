package com.techelevator.controller;

import com.techelevator.dao.VoteDao;
import com.techelevator.model.EventRestaurant;
import com.techelevator.model.Vote;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")

@RequestMapping("vote")
public class VoteController {

    private final VoteDao voteDao;
    private final TokenProvider tokenProvider;

    public VoteController(TokenProvider tokenProvider, VoteDao voteDao) {
        this.tokenProvider = tokenProvider;
        this.voteDao = voteDao;
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public void submitVote(@Valid @RequestBody Vote vote) {
        EventRestaurant eventRestaurant = voteDao.updateEventRestaurantVoteCount(vote);
        voteDao.updateEventRestaurant(eventRestaurant);
    }

}

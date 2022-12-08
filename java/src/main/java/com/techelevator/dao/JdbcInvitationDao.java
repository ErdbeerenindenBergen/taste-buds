package com.techelevator.dao;

import com.techelevator.model.Invitation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInvitationDao implements InvitationDao  {

    private final JdbcTemplate jdbcTemplate;

    public JdbcInvitationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Invitation> findAll() {
        List<Invitation> invitations = new ArrayList<>();
        String sql = "select * from event_invitation";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Invitation invitation = mapRowToInvitations(results);
            invitations.add(invitation);
        }
        return invitations;
    }

    @Override
    public Invitation getInvitationByUniqueLink(String uniqueInvitationLink) {
        return null;
    }

    @Override
    public void updateInvitation(Invitation invitation) {

    }

    @Override
    public void deleteInvitation(Invitation invitation) {

    }

    @Override
    public boolean createInvitation(Invitation invitation) {
        return false;
    }

    @Override
    public Invitation getInvitationByInviter(String inviter) {
        return null;
    }

    @Override
    public Invitation getInvitationByInviteId(int inviteId) {
        return null;
    }

    @Override
    public List<Invitation> getAllInvitationsByInviter(String inviter) {
        return null;
    }

    //TODO Update database for rows needed?
    private Invitation mapRowToInvitations(SqlRowSet rs) {
        Invitation invitation = new Invitation();
        invitation.setInviter(rs.getString(""));

        return invitation;

    }
}

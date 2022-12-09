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
        String sql = "select * from event_invitation;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Invitation invitation = mapRowToInvitations(results);
            invitations.add(invitation);
        }
        return invitations;
    }

    @Override //Bane of my existence
    public boolean createInvitation(Invitation invitation) {
        String sql = "INSERT INTO public.event_invitation" +
                "(invitation_id, event_id, email_address, has_voted)\n" +
                "VALUES (?, ?, ?, ?);";
        return jdbcTemplate.update(sql, invitation) == 1;

        
    }

    @Override
    public Invitation getInvitationByInvitationId(int invitationId) {
        String sql = "SELECT event_invitation.invitation_id, event_invitation.event_id, event_invitation.email_address, event_invitation.has_voted,\n" +
                "tb_event.event_name, tb_event.response_deadline_date,\n" +
                "tb_event.response_deadline_time, tb_event.event_zipcode, tb_event.event_city, tb_event.event_state\n" +
                "FROM event_invitation\n" +
                "JOIN tb_event \n" +
                "ON event_invitation.event_id = tb_event.event_id\n" +
                "WHERE invitation_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, invitationId);

        if (results.next()) {
            return mapRowToInvitations(results);
        } else {
            return null;
        }
    }

    @Override
    public Invitation getInvitationByUserId(int userId) {
        String sql = "SELECT event_invitation.invitation_id, event_invitation.event_id, event_invitation.email_address, event_invitation.has_voted, \n" +
                "tb_event.event_name, tb_event.event_city, tb_event.event_state, tb_event.event_zipcode, tb_event.response_deadline_date, tb_event.response_deadline_time\n" +
                "FROM event_invitation\n" +
                "INNER JOIN tb_event\n" +
                "ON event_invitation.event_id = tb_event.event_id\n" +
                "INNER JOIN tb_user\n" +
                "ON tb_event.event_organizer_id = tb_user.user_id\n" +
                "WHERE tb_user.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            return mapRowToInvitations(results);
        } else {
            return null;
        }
    }

    //TODO
    private Invitation mapRowToInvitations(SqlRowSet rs) {
        Invitation invitation = new Invitation();
        invitation.setInvitationId(rs.getInt("invitation_id"));
        invitation.setLocation(rs.getString("event_city, event_state")); // <--- ??
        invitation.setZipCode(rs.getString("event_zipcode"));
        invitation.setDecisionDate(rs.getDate("decision_date"));
        invitation.setDecisionTime(rs.getTime("decision_time"));


        return invitation;

    }
}

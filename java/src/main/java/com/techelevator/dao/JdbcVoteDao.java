package com.techelevator.dao;

import com.techelevator.model.EventRestaurant;
import com.techelevator.model.Vote;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcVoteDao implements VoteDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcVoteDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public EventRestaurant updateEventRestaurantVoteCount(Vote vote) {
        String sql = "SELECT * FROM event_restaurant WHERE yelp_restaurant_id = ? AND event_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, vote.getYelpRestaurantId(), vote.getEventId());
        if (results.next()) {
            EventRestaurant eventRestaurant = mapRowToEventRestaurant(results);
            int newVoteCount = eventRestaurant.getVoteCount() + vote.getVoteCount();
            eventRestaurant.setVoteCount(newVoteCount);
            return eventRestaurant;
        } else {
            return null;
        }
    }

    @Override
    public void updateEventRestaurant(EventRestaurant eventRestaurant) {
        String sql = " UPDATE public.event_restaurant " +
                " SET vote_count=? " +
                " WHERE yelp_restaurant_id = ? AND event_id = ? ;";
        jdbcTemplate.update(sql, eventRestaurant.getVoteCount(), eventRestaurant.getYelpRestaurantId(), eventRestaurant.getEventId());
    }

    private EventRestaurant mapRowToEventRestaurant(SqlRowSet rs) {
        EventRestaurant eventRestaurant = new EventRestaurant();
        eventRestaurant.setYelpRestaurantId(rs.getString("yelp_restaurant_id"));
        eventRestaurant.setEventId(rs.getInt("event_id"));
        eventRestaurant.setVoteCount(rs.getInt("vote_count"));
        return eventRestaurant;
    }
}

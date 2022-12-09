package com.techelevator.dao;

import com.techelevator.model.EventRestaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcEventRestaurantDao implements EventRestaurantDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEventRestaurantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createEventRestaurant(String yelpRestaurantId, int eventId) {
        String insertEventSql = "INSERT INTO event_restaurant(\n" +
                "\tyelp_restaurant_id, event_id, vote_count)\n" +
                "\tVALUES (?, ?, 0);";
        return jdbcTemplate.update(insertEventSql, yelpRestaurantId, eventId) == 1;
    }

    @Override
    public List<EventRestaurant> getRestaurantsByEventId(int eventId) {
        return null;
    }

    private EventRestaurant mapRowToEventRestaurant(SqlRowSet rs) {
        EventRestaurant eventRestaurant = new EventRestaurant();
        eventRestaurant.setYelpRestaurantId(rs.getString("yelp_restaurant_id"));
        eventRestaurant.setEventId(rs.getInt("event_id"));
        eventRestaurant.setVoteCount(rs.getInt("vote_count"));
        return eventRestaurant;
    }
}
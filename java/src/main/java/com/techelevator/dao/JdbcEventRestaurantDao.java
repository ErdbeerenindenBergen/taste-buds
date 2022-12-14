package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.EventRestaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEventRestaurantDao implements EventRestaurantDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEventRestaurantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean createEventRestaurant(EventRestaurant eventRestaurant) {
        String insertEventSql = "INSERT INTO event_restaurant( " +
                " yelp_restaurant_id, event_id, vote_count) " +
                " VALUES (?, ?, ?);";
        return jdbcTemplate.update(insertEventSql, eventRestaurant.getYelpRestaurantId(), eventRestaurant.getEventId(), eventRestaurant.getVoteCount()) == 1;
    }

    @Override
    public List<EventRestaurant> getEventRestaurantsByEventId(int eventId) {
        List<EventRestaurant> eventRestaurants = new ArrayList<>();
        String sql = "SELECT * FROM event_restaurant WHERE event_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventId);
        while (results.next()) {
            EventRestaurant eventRestaurant = mapRowToEventRestaurant(results);
            eventRestaurants.add(eventRestaurant);
        } return eventRestaurants;
    }
//    SELECT yelp_restaurant_id, COUNT(invitation_id), vote_count AS votes
//    FROM public.event_restaurant
//    JOIN event_invitation ON event_restaurant.event_id = event_invitation.event_id
//    GROUP BY yelp_restaurant_id, vote_count
//    ORDER BY votes DESC;

    @Override
    public List<EventRestaurant> getRestaurantRankedListByEventId(int eventId) {
        List<EventRestaurant> eventRestaurants = new ArrayList<>();
        String sql = " SELECT yelp_restaurant_id, event_id, vote_count " +
                " FROM event_restaurant " +
                " WHERE event_id = ? " +
                " ORDER BY vote_count DESC; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventId);
        while (results.next()) {
            EventRestaurant eventRestaurant = mapRowToEventRestaurant(results);
            eventRestaurants.add(eventRestaurant);
        }  return eventRestaurants;
    }

    private EventRestaurant mapRowToEventRestaurant(SqlRowSet rs) {
        EventRestaurant eventRestaurant = new EventRestaurant();
        eventRestaurant.setYelpRestaurantId(rs.getString("yelp_restaurant_id"));
        eventRestaurant.setEventId(rs.getInt("event_id"));
        eventRestaurant.setVoteCount(rs.getInt("vote_count"));
        return eventRestaurant;
    }
}

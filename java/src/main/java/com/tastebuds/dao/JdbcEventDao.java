package com.tastebuds.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tastebuds.model.Event;

@Component
public class JdbcEventDao implements EventDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEventDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM tb_event\n" +
                "ORDER BY event_id DESC;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Event event = mapRowToEvent(results);
            events.add(event);
        }
        return events;
    }

    @Override
    public int findIdByEventName(String eventName) {
        if (eventName == null) throw new IllegalArgumentException("Event name cannot be null");

        int eventId;
        try {
            eventId = jdbcTemplate.queryForObject("select event_id from tb_event where event_name = ?", int.class, eventName);
        } catch (EmptyResultDataAccessException e) {
            throw new UsernameNotFoundException("Event " + eventName + " was not found.");
        }
        return eventId;
    }

    @Override
    public Event getEventById(int eventId) {
        String sql = "SELECT * FROM tb_event WHERE event_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventId);
        if (results.next()) {
            return mapRowToEvent(results);
        } else {
            return null;
        }
    }

    @Override
    public Event getEventByName(String eventName){
        String sql = "SELECT * FROM tb_event WHERE event_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventName);
        if (results.next()) {
            return mapRowToEvent(results);
        } else {
            return null;
        }
    }

    @Override
    public Event getEventByDate(LocalDate eventDate) {
        String sql = "SELECT * FROM tb_event WHERE event_date = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventDate);
        if (results.next()) {
            return mapRowToEvent(results);
        } else {
            return null;
        }
    }

    @Override
    public Event getEventByOrganizerId(int eventOrganizerId) {
        String sql = "SELECT * FROM tb_event WHERE event_organizer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, eventOrganizerId);
        if (results.next()) {
            return mapRowToEvent(results);
        } else {
            return null;
        }
    }
//    @Override
//    public Integer create(Event event, int userId) {
//        String sql = "INSERT INTO tb_event (event_name, event_date, event_time, event_organizer_id, " +
//        " response_deadline_date, response_deadline_time) VALUES (?, ?, ?, ?, ?, ?) RETURNING event_id;";
//        Integer eventId = jdbcTemplate.queryForObject(sql, Integer.class, event.getEventName(), event.getEventDate(),
//                event.getEventTime(), userId, event.getDeadlineDate(), event.getDeadlineTime());
//            return eventId;
//    }

    @Override
    public Event create(Event event) {
        String sql = "INSERT INTO tb_event (event_name, event_date, event_time, event_organizer_id, response_deadline_date, response_deadline_time) " +
                " VALUES (?, ?, ?, ?, ?, ?) RETURNING event_id;";
        Integer eventId = jdbcTemplate.queryForObject(sql, Integer.class, event.getEventName(), event.getEventDate(),
                event.getEventTime(), event.getEventOrganizerId(), event.getDeadlineDate(), event.getDeadlineTime());
        return getEventById(eventId);
    }

    private Event mapRowToEvent(SqlRowSet rs) {
        Event event = new Event();
        event.setEventId(rs.getInt("event_id"));
        event.setEventName(rs.getString("event_name"));
        event.setEventCity(rs.getString("event_city"));
        event.setZipcode(rs.getInt("event_zipcode"));
        event.setEventState(rs.getString("event_state"));
        event.setUserLatitude(rs.getString("event_user_latitude"));
        event.setUserLongitude(rs.getString("event_user_longitude"));
        event.setEventDate(rs.getDate("event_date").toLocalDate());
        event.setEventTime(rs.getTime("event_time").toLocalTime());
        event.setEventOrganizerId(rs.getInt("event_organizer_id"));
        event.setDeadlineDate(rs.getDate("response_deadline_date").toLocalDate());
        event.setDeadlineTime(rs.getTime("response_deadline_time").toLocalTime());
        return event;
    }
}

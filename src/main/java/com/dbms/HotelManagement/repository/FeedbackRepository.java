package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.Feedback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class FeedbackRepository {
    private final JdbcTemplate jdbcTemplate;

    public FeedbackRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Feedback> getAllFeedback() {
        String sql = "SELECT * FROM Feedback";
        List<Feedback> allFeedback = jdbcTemplate.query(sql, new Object[]{}, FeedbackMapper());
        return allFeedback;
    }

    public void addFeedback(UUID feedbackID, String reviews, String suggestions, String date, String time, UUID customerID){
        String sql = "INSERT INTO Feedback(feedbackID, review, suggestions, date, time, customerID) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(feedbackID.toString(), reviews, suggestions, date, time, customerID.toString());
    }

    private RowMapper<Feedback> FeedbackMapper() {
        return (resultSet, i) -> {
            return new Feedback(
                    UUID.fromString(resultSet.getString("feedbackID")),
                    resultSet.getString("reviews"),
                    resultSet.getString("suggestions"),
                    resultSet.getString("date"),
                    resultSet.getString("time"),
                    UUID.fromString(resultSet.getString("customerID"))
            );
        };
    }
}

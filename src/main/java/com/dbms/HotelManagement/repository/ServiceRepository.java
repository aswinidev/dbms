package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ServiceRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int addService(String serviceName, boolean availability, float price, UUID headedBy) {
        String sql = "INSERT INTO Service(serviceName, availability, price, headedBy) VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(sql, serviceName, availability, price, headedBy.toString());
    }

    public Service getServiceByName(String serviceName){
        String sql = "SELECT * FROM Service WHERE serviceName = ?";

        return jdbcTemplate.queryForObject(sql, new Object[] { serviceName }, new BeanPropertyRowMapper<>(Service.class));

    }

    public List<Service> getAllService(){
        String sql = "Select * FROM Service";
        try{
           return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Service.class));
        }
        catch ( Exception e){
            System.out.println(e);
            return new ArrayList<Service>();
        }
    }

    public int updateAvailabilty(String serviceName, boolean availability){
        String sql = "UPDATE Service availablity = ? WHERE serviceName = ?";

        return jdbcTemplate.update(sql, availability, serviceName);
    }

    public int updatePrice(String serviceName, int price){
        String sql = "UPDATE Service price = ? WHERE serviceName = ?";

        return jdbcTemplate.update(sql, price, serviceName);
    }

    public int updateHeadedBy(String serviceName, UUID headedBy){
        String sql = "UPDATE Service headedBy = ? WHERE serviceName = ?";

        return jdbcTemplate.update(sql, headedBy.toString(), serviceName);
    }

    public int deleteService(String serviceName){
        String sql = "DELETE FROM Service WHERE serviceName = ?";
        return jdbcTemplate.update(sql);
    }
}

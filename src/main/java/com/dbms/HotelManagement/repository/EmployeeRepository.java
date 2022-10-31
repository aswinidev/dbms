package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int registerEmployee(UUID empID, String currHouseNo, String currPincode, String currCity, String currState, String maritalStatus, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, UUID superID){
        String sql = "INSERT INTO Employee(empID, currHouseNo, currPincode, currCity, currState, maritalStatus, panCard, accountNo, IFSCCode, bankName, userID, deptName, superID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, empID.toString(), currHouseNo, currPincode, currCity, currState, maritalStatus, panCard, accountNo, IFSCCode, bankName, userID, deptName, superID);
    }

    public Employee getEmployee(String userID){
        String sql = "Select * from Employee where userID = ?";

        Employee e = jdbcTemplate.queryForObject(sql, new Object[] {userID}, new BeanPropertyRowMapper<>(Employee.class));
        return e;

    }
}

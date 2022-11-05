package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

//    public int registerEmployee(UUID empID, String currHouseNo, String currPincode, String currCity, String currState, String maritalStatus, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, UUID superID){
//        String sql = "INSERT INTO Employee(empID, currHouseNo, currPincode, currCity, currState, maritalStatus, panCard, accountNo, IFSCCode, bankName, userID, deptName, superID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        return jdbcTemplate.update(sql, empID.toString(), currHouseNo, currPincode, currCity, currState, maritalStatus, panCard, accountNo, IFSCCode, bankName, userID, deptName, superID);
//    }

    public Employee getEmployee(String userID){
        String sql = "Select * from Employee where userID = ?";
        try{
            Employee e = jdbcTemplate.queryForObject(sql, new Object[] {userID}, new BeanPropertyRowMapper<>(Employee.class));
            return e;
        }
        catch (Exception e){
            System.out.println(e);
            return new Employee();
        }

    }

    public List<Employee> getAllEmployee() {
        String sql = "SELECT * FROM Employee";
        List<Employee> allEmployees= jdbcTemplate.query(sql, new Object[]{}, EmployeeMapper());
        return allEmployees;
    }

    public void addEmployee(UUID empID, String houseNo, String pincode, String city, String state, String maritalStatus, int salary, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, UUID superID){
        String sql = "INSERT INTO Employee(empID, currHouseNo, currPincode, currCity, currState, maritalStatus, salary, panCard, accountNo, IFSCCode, bankName, userID, deptName, superID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, empID.toString(), houseNo, pincode, city, state, maritalStatus, salary, panCard, accountNo, IFSCCode, bankName, userID.toString(), deptName, superID.toString());
    }

    private RowMapper<Employee> EmployeeMapper() {
        return (resultSet, i) -> {
            return new Employee(
                    UUID.fromString(resultSet.getString("empID")),
                    resultSet.getString("currHouseNo"),
                    resultSet.getString("currPincode"),
                    resultSet.getString("currCity"),
                    resultSet.getString("currState"),
                    resultSet.getString("maritalStatus"),
                    resultSet.getInt("salary"),
                    resultSet.getString("panCard"),
                    resultSet.getString("accountNo"),
                    resultSet.getString("IFSCCode"),
                    resultSet.getString("bankName"),
                    UUID.fromString(resultSet.getString("userID")),
                    resultSet.getString("deptName"),
                    UUID.fromString(resultSet.getString("superID"))
            );
        };
    }
}
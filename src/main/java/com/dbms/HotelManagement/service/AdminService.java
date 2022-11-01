package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.Employee;
import com.dbms.HotelManagement.model.Feedback;
import com.dbms.HotelManagement.repository.EmployeeRepository;
import com.dbms.HotelManagement.repository.FeedbackRepository;
import com.dbms.HotelManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public AdminService(UserRepository userRepository, EmployeeRepository employeeRepository, FeedbackRepository feedbackRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.feedbackRepository = feedbackRepository;
    }

    public void removeUser(String pEmail) {
        userRepository.removeUser(pEmail);
    }

    public void addEmployee(Employee employee){
//        UUID empID, String houseNo, String pincode, String city, String state, String maritalStatus, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, UUID superID
        employeeRepository.addEmployee(employee.getEmpID(), employee.getCurrHouseNo(), employee.getCurrPincode(), employee.getCurrCity(), employee.getCurrState(), employee.getMaritalStatus(), employee.getPanCard(), employee.getAccountNo(), employee.getIFSCCode(), employee.getBankName(), employee.getUserID(), employee.getDeptName(), employee.getSuperID());
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getAllEmployee();
    }

    public List<Feedback> getFeedback() {
        return feedbackRepository.getAllFeedback();
    }
//    public List<Employee> getCustomers() {
//        return employeeRepository.getAllCustomer();
//    }
}

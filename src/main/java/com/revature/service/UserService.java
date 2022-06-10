package com.revature.service;

import com.revature.dao.RequestDao;
import com.revature.dao.UserDao;
import com.revature.models.Employee;
import com.revature.models.Request;

import java.util.ArrayList;
import java.util.Objects;

public class UserService {
    UserDao uDao = new UserDao();
    RequestDao rDao = new RequestDao();

    /**
     * Accesses the DAO checks if a valid user exists, and if so, returns a valid employee.
     * @param username
     * @param password
     * @return A valid employee, or null
     */
    public Employee authEmployee(String username, String password){
        Employee employee = uDao.getEmployeeByUsername(username);

        if(employee!=null && Objects.equals(employee.getUsername(), username) && Objects.equals(employee.getPassword(), password)){
            return employee;
        } else{
            return null;
        }
    }

    /**
     * Accesses the DAO and returns a list of pending requests belong to the employeeID.
     * @param employeeID
     * @return A list of requests, may be empty.
     */
    public ArrayList<Request> getPendingRequestsByUserID(Integer employeeID) {
        return rDao.getPendingRequestsByUserID(employeeID);
    }
    /**
     * Accesses the DAO and returns a list of all requests belonging to the employeeID.
     * @param employeeID
     * @return A list of requests, may be empty.
     */
    public ArrayList<Request> getAllRequestsByUserID(Integer employeeID) {
        return rDao.getAllRequestsByUserID(employeeID);
    }
    /**
     * Accesses the DAO and returns a list of approved and denied requests belonging to the employeeID.
     * @param employeeID
     * @return A list of requests, may be empty.
     */
    public ArrayList<Request> getPastRequestsByUserID(int employeeID) {
        return rDao.getPastRequestsByUserID(employeeID);
    }
}

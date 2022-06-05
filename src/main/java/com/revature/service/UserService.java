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
    public Employee authEmployee(String username, String password){
        Employee employee = uDao.getEmployeeByUsername(username);

        if(employee!=null && Objects.equals(employee.getUsername(), username) && Objects.equals(employee.getPassword(), password)){
            return employee;
        } else{
            return null;
        }
    }

    public ArrayList<Request> getPendingRequestsByUserID(Integer employeeID) {
        return rDao.getPendingRequestsByUserID(employeeID);
    }

    public ArrayList<Request> getAllRequestsByUserID(Integer employeeID) {
        return rDao.getAllRequestsByUserID(employeeID);
    }
}

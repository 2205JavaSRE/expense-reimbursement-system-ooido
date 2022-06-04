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
        System.out.println("Service: " + employee);
//        System.out.println("service:" + employee.getUsername() + " " + employee.getPassword());
//        System.out.println("service:" + username + " " + password);
//        if(employee == null){
//            System.out.println("employee is null");
//        }
//        if(Objects.equals(employee.getUsername(), username)){
//            System.out.println("username is same");
//        }
//        if(Objects.equals(employee.getPassword(), password)){
//            System.out.println("password is same");
//        }
        if(employee!=null && Objects.equals(employee.getUsername(), username) && Objects.equals(employee.getPassword(), password)){
            //System.out.println("true");
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

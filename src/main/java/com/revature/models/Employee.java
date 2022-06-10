package com.revature.models;

import java.util.ArrayList;

/**
 * The employee class. Includes a boolean field for finance managers.
 */
public class Employee {
    private String username;
    private String password;
    private Integer employeeID;
    private boolean isManager;

    private ArrayList<Request> requests;

    public Employee(){}

    public Employee(String username, String password, Integer employeeID, boolean isManager) {
        this.username = username;
        this.password = password;
        this.employeeID = employeeID;
        this.isManager = isManager;
    }

    public Employee(String username, String password, Integer employeeID, boolean isManager, ArrayList<Request> requests) {
        this.username = username;
        this.password = password;
        this.employeeID = employeeID;
        this.isManager = isManager;
        this.requests = requests;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public boolean isManager() {
        return isManager;
    }
    public void setManager(boolean manager) {
        isManager = manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeID=" + employeeID +
                ", isManager=" + isManager +
                ", requests=" + requests +
                '}';
    }
}

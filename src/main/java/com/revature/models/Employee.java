package com.revature.models;

public class Employee {
    private String username;
    private String password;
    private String employeeID;

    public Employee(){}
    public Employee(String username, String password, String employeeID) {
        this.username = username;
        this.password = password;
        this.employeeID = employeeID;
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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeID='" + employeeID + '\'' +
                '}';
    }
}

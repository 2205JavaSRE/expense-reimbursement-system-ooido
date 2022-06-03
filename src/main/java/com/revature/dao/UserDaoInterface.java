package com.revature.dao;

import com.revature.models.Employee;

import java.util.ArrayList;

public interface UserDaoInterface {

    public void insertEmployee(Employee employee);
    public Employee getEmployeeByUsername(String username);
    public ArrayList<Employee> getAllEmployees();
    public boolean existsByName(String username);

}

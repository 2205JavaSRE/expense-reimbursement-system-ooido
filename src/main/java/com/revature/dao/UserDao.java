package com.revature.dao;

import com.revature.models.Employee;
import com.revature.utils.ConnectionFactory;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao implements UserDaoInterface{
    @Override
    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO project1.customers (username, pass) VALUES (?,?)";

        Connection connection = ConnectionFactory.getConnection();

        //try with resources, can be used with anything that implements AutoClosable, e.g. a connection.
        try(PreparedStatement ps = connection.prepareStatement(sql)){ //connection will be closed after we are done!

            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getPassword());
            //ps.setBoolean(3, false);
            //System.out.println("oh shit: " + user.getUsername() + user.getPassword());
            ps.execute(); //We use execute when we DONT expect anything back
            //ps.executeQuery(); //WE use use we DO expect something back!

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        String sql = "select * from project1.Employees a left join project1.Managers b using(user_id) where username = ?";
        //select * from project1.Employees a left join project1.Managers b using(user_id) where username = ?;
        //select * from ((select user_id,username,pass from Employees) union (select user_id,username,pass from Customers)) as dt where username = 'testEmployee1';
        Connection connection = ConnectionFactory.getConnection();
        Employee employee = null;

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();


            if(rs.next()){
                Integer userID = rs.getInt("user_id");
                String password = rs.getString("password");
                boolean isManager = rs.getBoolean("is_manager");
                //user = new Customer(userID, username, password);
                /*if(!authorized){*/
                employee = new Employee(username, password, userID, isManager);
                //} else {
                 //   user = new Employee(userID, username, password, authorized);
                //}
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public ArrayList<Employee> getAllEmployees() {
        String sql = "select * from project1.Customers";
        Connection connection = ConnectionFactory.getConnection();
        ArrayList<Employee> employees = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //long userID, String username, String password

                Employee p = new Employee(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("user_id"),
                        rs.getBoolean("is_manager")
                );
                employees.add(p);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public boolean existsByName(String username) {
        String sql = "select username from ((select username from Employees) union (select username from Customers)) as dt where username = ?";
        //(select username from Employees) intersect (select username from Customers);
        Connection connection = ConnectionFactory.getConnection();
        Employee user = null;
        boolean exists = false;

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            if(rs.isBeforeFirst()){
                exists = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return exists;
    }
}

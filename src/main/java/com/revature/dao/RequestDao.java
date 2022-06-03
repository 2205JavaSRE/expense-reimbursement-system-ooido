package com.revature.dao;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.models.RequestType;
import com.revature.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequestDao implements RequestDaoInterface{
    @Override
    public void insertRequest(Request request) {
        String sql = "INSERT INTO project1.requests (user_id, status, amount, type) VALUES (?,?,?,?)";

        Connection connection = ConnectionFactory.getConnection();

        //try with resources, can be used with anything that implements AutoClosable, e.g. a connection.
        try(PreparedStatement ps = connection.prepareStatement(sql)){ //connection will be closed after we are done!

            ps.setInt(1, request.getEmployeeID());
            ps.setInt(2, 0);
            ps.setDouble(3, request.getAmount());
            ps.setInt(4, request.getRequestType().ordinal());
            //ps.setBoolean(3, false);
            //System.out.println("oh shit: " + user.getUsername() + user.getPassword());
            ps.execute(); //We use execute when we DONT expect anything back
            //ps.executeQuery(); //WE use use we DO expect something back!

        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRequestStatus(Request request) {
        //update project1.Requests set status = ? where request_id = ?;
        String sql = "update project1.Requests set status = ? where request_id = ?";

        Connection connection = ConnectionFactory.getConnection();

        //try with resources, can be used with anything that implements AutoClosable, e.g. a connection.
        try(PreparedStatement ps = connection.prepareStatement(sql)){ //connection will be closed after we are done!

            ps.setInt(1, request.getRequestStatus().ordinal());
            ps.setInt(2, request.getRequestID());

            ps.execute();


        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Request getRequestByID(int requestID) {
        String sql = "select * from project1.Requests where request_id = ?";
        //select * from project1.Employees a left join project1.Managers b using(user_id) where username = ?;
        //select * from ((select user_id,username,pass from Employees) union (select user_id,username,pass from Customers)) as dt where username = 'testEmployee1';
        Connection connection = ConnectionFactory.getConnection();
        Request request = null;

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,requestID);
            ResultSet rs = ps.executeQuery();


            if(rs.next()){
                int employeeID = rs.getInt("user_id");
                RequestStatus requestStatus = RequestStatus.fromOrdinal(rs.getInt("status"));
                double amount = rs.getDouble("amount");
                RequestType requestType = RequestType.fromOrdinal(rs.getInt("type"));
                request = new Request(requestID, employeeID, requestStatus, amount, requestType);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return request;
    }

    @Override
    public ArrayList<Request> getPastRequestsByUserID(int userID) {
        return null;
    }

    @Override
    public ArrayList<Request> getPendingRequestsByUserID(int userID) {
        return null;
    }

    @Override
    public ArrayList<Request> getPastRequests() {
        return null;
    }

    @Override
    public ArrayList<Request> getPendingRequests() {
        return null;
    }
}

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


        try(PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, request.getEmployeeID());
            ps.setInt(2, 0);
            ps.setDouble(3, request.getAmount());
            ps.setInt(4, request.getRequestType().ordinal());
            ps.execute();


        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRequestStatus(Request request) {

        String sql = "update project1.Requests set status = ? where request_id = ?";

        Connection connection = ConnectionFactory.getConnection();

        try(PreparedStatement ps = connection.prepareStatement(sql)){

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
    public ArrayList<Request> getAllRequestsByUserID(int userID) {

        String sql = "select * from project1.Requests where user_id = ?";
        Connection connection = ConnectionFactory.getConnection();

        ArrayList<Request> requests = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int requestID = rs.getInt("request_id");
                int employeeID = rs.getInt("user_id");
                RequestStatus requestStatus = RequestStatus.fromOrdinal(rs.getInt("status"));
                double amount = rs.getDouble("amount");
                RequestType requestType = RequestType.fromOrdinal(rs.getInt("type"));
                requests.add(new Request(requestID, employeeID, requestStatus, amount, requestType));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return requests;
    }

    @Override
    public ArrayList<Request> getPendingRequestsByUserID(int userID) {

        String sql = "select * from project1.Requests where user_id = ? and status = ?";
        Connection connection = ConnectionFactory.getConnection();

        ArrayList<Request> requests = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, userID);
            ps.setInt(2, RequestStatus.PENDING.ordinal());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int requestID = rs.getInt("request_id");
                int employeeID = rs.getInt("user_id");
                RequestStatus requestStatus = RequestStatus.fromOrdinal(rs.getInt("status"));
                double amount = rs.getDouble("amount");
                RequestType requestType = RequestType.fromOrdinal(rs.getInt("type"));
                requests.add(new Request(requestID, employeeID, requestStatus, amount, requestType));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return requests;

    }

    @Override
    public ArrayList<Request> getAllRequests() {
        String sql = "select * from project1.Requests";
        Connection connection = ConnectionFactory.getConnection();

        ArrayList<Request> requests = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int requestID = rs.getInt("request_id");
                int employeeID = rs.getInt("user_id");
                RequestStatus requestStatus = RequestStatus.fromOrdinal(rs.getInt("status"));
                double amount = rs.getDouble("amount");
                RequestType requestType = RequestType.fromOrdinal(rs.getInt("type"));
                requests.add(new Request(requestID, employeeID, requestStatus, amount, requestType));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return requests;
    }

    @Override
    public ArrayList<Request> getPendingRequests() {
        String sql = "select * from project1.Requests where status = ?";
        Connection connection = ConnectionFactory.getConnection();

        ArrayList<Request> requests = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, RequestStatus.PENDING.ordinal());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int requestID = rs.getInt("request_id");
                int employeeID = rs.getInt("user_id");
                RequestStatus requestStatus = RequestStatus.fromOrdinal(rs.getInt("status"));
                double amount = rs.getDouble("amount");
                RequestType requestType = RequestType.fromOrdinal(rs.getInt("type"));
                requests.add(new Request(requestID, employeeID, requestStatus, amount, requestType));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return requests;
    }
}

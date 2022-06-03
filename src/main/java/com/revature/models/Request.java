package com.revature.models;

public class Request {
    private int requestID;
    private int employeeID;
    private RequestStatus requestStatus; //if it's pending, unapproved. maybe an int sos there's pending, approved, unapproved? || maybe a custom enum requestType?
    private double amount;
    private RequestType requestType; // lodging, travel, food, other

    public Request(){

    }
    public Request(double amount, RequestType requestType) {
        this.amount = amount;
        this.requestType = requestType;
    }
    public Request( int employeeID, RequestStatus requestStatus, double amount, RequestType requestType) {
        this.employeeID = employeeID;
        this.requestStatus = requestStatus;
        this.amount = amount;
        this.requestType = requestType;
    }
    public Request(int requestID, int employeeID, RequestStatus requestStatus, double amount, RequestType requestType) {
        this.requestID = requestID;
        this.employeeID = employeeID;
        this.requestStatus = requestStatus;
        this.amount = amount;
        this.requestType = requestType;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus approvalStatus) {
        this.requestStatus = approvalStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestID=" + requestID +
                ", employeeID=" + employeeID +
                ", approvalStatus=" + requestStatus +
                ", amount=" + amount +
                ", requestType='" + requestType + '\'' +
                '}';
    }
}

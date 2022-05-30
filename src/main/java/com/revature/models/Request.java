package com.revature.models;

public class Request {
    private int requestID;
    private int employeeID;
    private Status approvalStatus; //if it's pending, unapproved. maybe an int sos there's pending, approved, unapproved? || maybe a custom enum type?
    private double amount;
    private String type; // lodging, travel, food, other

    public Request(){

    }
    public Request(int requestID, int employeeID, Status approvalStatus, double amount, String type) {
        this.requestID = requestID;
        this.employeeID = employeeID;
        this.approvalStatus = approvalStatus;
        this.amount = amount;
        this.type = type;
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

    public Status getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Status approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestID=" + requestID +
                ", employeeID=" + employeeID +
                ", approvalStatus=" + approvalStatus +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}

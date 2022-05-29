package com.revature.models;

public class Request {
    private int requestID;
    private int employeeID;
    private boolean approved; //if it's pending, unapproved. maybe an int sos there's pending, approved, unapproved?
    private double amount;
    private int type; //0 = lodging, 1 = travel, 2 = food, 3 = other

    public Request(){

    }
    public Request(int requestID, int employeeID, boolean approved, double amount, int type) {
        this.requestID = requestID;
        this.employeeID = employeeID;
        this.approved = approved;
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestID=" + requestID +
                ", employeeID=" + employeeID +
                ", approved=" + approved +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}

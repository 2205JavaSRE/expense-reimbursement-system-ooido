package com.revature.dao;

import com.revature.models.Request;

import java.util.ArrayList;

public interface RequestDaoInterface {
    public void insertRequest(Request request);
    public void updateRequestStatus(Request request);
    public Request getRequestByID(int requestID);
    public ArrayList<Request> getPastRequestsByUserID(int userID); //user history (no pending)
    public ArrayList<Request> getPendingRequestsByUserID(int userID); //user pending
    public ArrayList<Request> getPastRequests(); //all history (no pending)
    public ArrayList<Request> getPendingRequests(); //all pending
}

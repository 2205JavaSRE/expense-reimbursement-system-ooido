package com.revature.service;

import com.revature.dao.RequestDao;
import com.revature.dao.UserDao;
import com.revature.models.Request;
import com.revature.models.RequestStatus;

import java.util.ArrayList;

public class RequestService {
    RequestDao rDao = new RequestDao();

    public void newRequest(Request request){
        //if valid request
        rDao.insertRequest(request);
    }

    public void setRequestStatus(int requestID, RequestStatus status){
        //if valid update
        Request fullRequest = rDao.getRequestByID(requestID);
        fullRequest.setRequestStatus(status);
        rDao.updateRequestStatus(fullRequest);
    }
    public Request getRequestByID(int requestID){
        //if manager else return null
        return rDao.getRequestByID(requestID);
    }

    public ArrayList<Request> getPendingRequests() {
        return rDao.getPendingRequests();
    }

    public ArrayList<Request> getAllRequests() {
        return rDao.getAllRequests();
    }
}

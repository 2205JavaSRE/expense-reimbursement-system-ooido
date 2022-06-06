package com.revature.service;

import com.revature.dao.RequestDao;
import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.models.RequestType;

import java.util.ArrayList;

public class RequestService {
    RequestDao rDao = new RequestDao();

    public void newRequest(Request request) throws Exception{
        if(request.getAmount() <=0){
            throw new Exception();
        } else {
            rDao.insertRequest(request);
        }
    }

    public void setRequestStatus(int requestID, RequestStatus status){
        Request fullRequest = rDao.getRequestByID(requestID);
        fullRequest.setRequestStatus(status);
        rDao.updateRequestStatus(fullRequest);
    }
    public Request getRequestByID(int requestID){
        return rDao.getRequestByID(requestID);
    }

    public ArrayList<Request> getPendingRequests() {
        return rDao.getPendingRequests();
    }

    public ArrayList<Request> getAllRequests() {
        return rDao.getAllRequests();
    }
}

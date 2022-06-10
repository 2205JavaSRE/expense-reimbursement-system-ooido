package com.revature.service;

import com.revature.dao.RequestDao;
import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.models.RequestType;

import java.util.ArrayList;

public class RequestService {
    RequestDao rDao = new RequestDao();

    /**
     * Accesses the DAO and requests to insert a new valid reimbursement request into the database, or throws an exception if the balance is invalid.
     * @param request
     * @throws Exception
     */
    public void newRequest(Request request) throws Exception{
        if(request.getAmount() <=0){
            throw new Exception();
        } else {
            rDao.insertRequest(request);
        }
    }

    /**
     * Accesses the dao and requests to update a reimbursement request's status.
     * @param requestID
     * @param status
     */
    public void setRequestStatus(int requestID, RequestStatus status){
        Request fullRequest = rDao.getRequestByID(requestID);
        fullRequest.setRequestStatus(status);
        rDao.updateRequestStatus(fullRequest);
    }

    /**
     * Accesses the dao and returns a request with the passed ID.
     * @param requestID the id of a desired request
     * @return A request object.
     */
    public Request getRequestByID(int requestID){
        return rDao.getRequestByID(requestID);
    }

    /**
     * Accesses the dao and returns a list of all pending requests.
     * @return A list of Request objects.
     */
    public ArrayList<Request> getPendingRequests() {
        return rDao.getPendingRequests();
    }
    /**
     * Accesses the dao and returns a list of all requests.
     * @return A list of Request objects.
     */
    public ArrayList<Request> getAllRequests() {
        return rDao.getAllRequests();
    }
    /**
     * Accesses the dao and returns a list of all historical requests.
     * @return A list of Request objects.
     */
    public ArrayList<Request> getPastRequests() { return rDao.getPastRequests();}
    /**
     * Accesses the dao and returns a list of an employee's pending requests..
     * @return A list of Request objects.
     */
    public ArrayList<Request> getPendingRequestsByUserID(Integer employeeID) {
        return rDao.getPendingRequestsByUserID(employeeID);
    }
    /**
     * Accesses the dao and returns a list of all an employee's approve and denied quests.
     * @return A list of Request objects.
     */
    public ArrayList<Request> getAllRequestsByUserID(Integer employeeID) {
        return rDao.getAllRequestsByUserID(employeeID);
    }
    /**
     * Accesses the dao and returns a list of a user's historical requests.
     * @return A list of Request objects.
     */
    public ArrayList<Request> getPastRequestsByUserID(int employeeID) {
        return rDao.getPastRequestsByUserID(employeeID);
    }
}

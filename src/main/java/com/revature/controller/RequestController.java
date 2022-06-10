package com.revature.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.service.RequestService;
import io.javalin.http.Context;

public class RequestController {
    RequestService rService = new RequestService();

    /**
     * This method, for an authorized user, creates a new request, if it is not an invalid request.
     * @param ctx
     */
    public void request(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");

        try {
            if(employee!=null) {
                Request request = ctx.bodyAsClass(Request.class);

                request.setEmployeeID(employee.getEmployeeID());
                rService.newRequest(request);
                ctx.status(201);
            } else{
                ctx.status(401);
            }
        }catch(Exception e){
            ctx.status(400);
            //e.printStackTrace();
        }

    }

    /**
     * This method, for an authorized manager, returns an http response with a request for the given ID parameter.
     * @param ctx
     */
    public void requestByID(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");

        try {
            if (employee != null && employee.isManager()) {
                int requestID = Integer.parseInt(ctx.pathParam("id"));
                Request request = rService.getRequestByID(requestID);
                if (request != null) {
                    ctx.status(200);
                    ctx.json(request);
                } else {
                    ctx.status(404);
                }
            } else {
                ctx.status(401);
            }
        }catch(Exception e){
            ctx.status(400);
        }
    }

    /**
     * This method, for an authorized manager, approves a request with the given path parameter.
     * @param ctx
     */
    public void approveRequest(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");
        try {
            int requestID = Integer.parseInt(ctx.pathParam("id"));
            if (employee != null && employee.isManager()) {
                rService.setRequestStatus(requestID, RequestStatus.APPROVED);
                ctx.status(200);
            } else {
                ctx.status(401);
            }
        } catch (Exception e){
            ctx.status(400);
        }
    }

    /**
     * This method, for an authorized manager, denies a request with the given path parameter.
     * @param ctx
     */
    public void denyRequest(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");
        try {
            int requestID = Integer.parseInt(ctx.pathParam("id"));
            if (employee != null && employee.isManager()) {
                rService.setRequestStatus(requestID, RequestStatus.DENIED);
                ctx.status(200);
            } else {
                ctx.status(401);
            }
        } catch (Exception e){
            ctx.status(400);
        }
    }

    /**
     * This method processes an http request, for an authorized manager, and returns an http response with all pending requests.
     * @param ctx
     */
    public void getPendingRequests(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()){
            ctx.json(rService.getPendingRequests());
            ctx.status(200);
        } else{
            ctx.status(401);
        }

    }

    /**
     * This method processes an http request, for an authorized manager, and returns an http response with all requests.
     * @param ctx
     */
    public void getAllRequests(Context ctx) {
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()){
            ctx.json(rService.getAllRequests());
            ctx.status(200);
        } else{
            ctx.status(401);
        }

    }
    /**
     * This method processes an http request, for an authorized manager, and returns an http response with all denied
     * or approved requests.
     * @param ctx
     */
    public void getPastRequests(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()){
            ctx.json(rService.getPastRequests());
            ctx.status(200);
        } else{
            ctx.status(401);
        }
    }

    /**
     * This method processes an http request, for an authorized manager, and returns an http response with all pending
     * requests for with the pathparam ID.
     * @param ctx
     */
    public void getPendingRequestsByUser(Context ctx) {
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()) {
            ctx.json(rService.getPendingRequestsByUserID(Integer.parseInt(ctx.pathParam("id"))));
            ctx.status(200);
        } else {
            ctx.status(401);
        }

    }
    /**
     * This method processes an http request, for an authorized manager, and returns an http response with all requests
     * for with the pathparam ID.
     * @param ctx
     */
    public void getAllRequestsByUser(Context ctx) {
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()) {
            ctx.json(rService.getAllRequestsByUserID(Integer.parseInt(ctx.pathParam("id"))));
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    }
    /**
     * This method processes an http request, for an authorized manager, and returns an http response with approve or denied
     * requests for with the pathparam ID.
     * @param ctx
     */
    public void getPastRequestsByUser(Context ctx) {
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()) {
            ctx.json(rService.getPastRequestsByUserID(Integer.parseInt(ctx.pathParam("id"))));
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    }
}

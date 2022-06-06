package com.revature.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.service.RequestService;
import io.javalin.http.Context;

public class RequestController {
    RequestService rService = new RequestService();

    public void request(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");
        System.out.println("controller" + employee);
        try {
            if(employee!=null) {
                Request request = ctx.bodyAsClass(Request.class);
                System.out.println("controller" + request);
                request.setEmployeeID(employee.getEmployeeID());
                rService.newRequest(request);
                ctx.status(200);
            } else{
                ctx.status(401);
            }
        }catch(Exception e){
            ctx.status(400);
            e.printStackTrace();
        }

    }

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

    public void getPendingRequests(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()){
            ctx.json(rService.getPendingRequests());
            ctx.status(200);
        } else{
            ctx.status(401);
        }

    }

    public void getAllRequests(Context ctx) {
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()){
            ctx.json(rService.getAllRequests());
            ctx.status(200);
        } else{
            ctx.status(401);
        }

    }

    public void getPastRequests(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()){
            ctx.json(rService.getPastRequests());
            ctx.status(200);
        } else{
            ctx.status(401);
        }
    }
}

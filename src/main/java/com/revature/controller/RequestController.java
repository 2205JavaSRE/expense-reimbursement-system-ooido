package com.revature.controller;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.models.RequestStatus;
import com.revature.service.RequestService;
import com.revature.service.UserService;
import io.javalin.http.Context;

public class RequestController {
    RequestService rService = new RequestService();
    public void request(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");
        Request request = ctx.bodyAsClass(Request.class);

        if(employee!=null) {
            request.setEmployeeID(employee.getEmployeeID());
            rService.newRequest(request);
            ctx.status(200);
        } else{
            ctx.status(401);
        }
    }

    public void requestByID(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");
        int requestID = Integer.parseInt(ctx.pathParam("id"));


        if(employee!=null && employee.isManager()) {
            Request request = rService.getRequestByID(requestID);
            if(request!=null){
                ctx.status(200);
                ctx.json(request);
            } else {
                ctx.status(404);
            }
        } else{
            ctx.status(401);
        }
    }

    public void approveRequest(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");
        int requestID = Integer.parseInt(ctx.pathParam("id"));

        if(employee != null && employee.isManager()){
            rService.setRequestStatus(requestID, RequestStatus.APPROVED);
            ctx.status(200);
        } else{
            ctx.status(401);
        }

    }

    public void denyRequest(Context ctx){
        Employee employee = ctx.sessionAttribute("Employee");
        int requestID = Integer.parseInt(ctx.pathParam("id"));

        if(employee != null && employee.isManager()){
            rService.setRequestStatus(requestID, RequestStatus.DENIED);
            ctx.status(200);
        } else{
            ctx.status(401);
        }
    }

}

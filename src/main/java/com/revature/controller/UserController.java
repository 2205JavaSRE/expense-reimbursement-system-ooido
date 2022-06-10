package com.revature.controller;
import com.revature.models.Employee;
import com.revature.models.Request;
import io.javalin.http.Context;
import com.revature.service.UserService;

import java.util.ArrayList;


public class UserController {
    UserService uService = new UserService();

    public UserController() {
    }

    /**
     * This method processes an http request, takes the body and parses it as json into an employee object.
     * It then checks this object and checks against the database. If it does not match, returns 401, otherwise it creates
     * a new session context for the existing user.
     * @param ctx
     */
    public void login(Context ctx){
        Employee employee = ctx.bodyAsClass(Employee.class);
        Employee e2 = uService.authEmployee(employee.getUsername(), employee.getPassword());
        if(e2!=null){
            ctx.sessionAttribute("Employee", e2);
            ctx.status(200);
        } else{
            ctx.status(401);
        }

    }

    /**
     * This method invalidates the current context's session.
     * @param ctx
     */
    public void logout(Context ctx){
        ctx.req.getSession().invalidate();

    }

    /**
     * This method processes an http request and returns an http response with a json body, for an authorized user,
     * with all pending requests for the current user.
     * @param ctx
     */
    public void getPendingRequestsForUser(Context ctx) {

        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null){
            ctx.json(uService.getPendingRequestsByUserID(employee.getEmployeeID()));
            ctx.status(200);
        } else {
            ctx.status(401);
        }

    }

    /**
     * This method processes an http request and returns an http response with a json body, for an authorized user,
     * and returns a list of all requests for the current user.
     * @param ctx
     */
    public void getAllRequestsForUser(Context ctx) {
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null){
            ctx.json(uService.getAllRequestsByUserID(employee.getEmployeeID()));
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    }

    /**
     * This method processes an http request and returns an http response with a json body, for an authorized user,
     * and returns a list of all of the user's past approved or denied requests.
     * @param ctx
     */
    public void getPastRequestsForUser(Context ctx) {
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null){
            ctx.json(uService.getPastRequestsByUserID(employee.getEmployeeID()));
            ctx.status(200);
        }  else {
            ctx.status(401);
        }
    }
}

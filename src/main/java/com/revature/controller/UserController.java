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

    public void logout(Context ctx){
        //ctx.consumeSessionAttribute("Employee");
        ctx.req.getSession().invalidate();

    }

    public void getPendingRequestsForUser(Context ctx) {

        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null){
            ctx.json(uService.getPendingRequestsByUserID(employee.getEmployeeID()));
            ctx.status(200);
        } else{
            ctx.status(401);
        }

    }

    public void getAllRequestsForUser(Context ctx) {
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null){
            ctx.json(uService.getAllRequestsByUserID(employee.getEmployeeID()));
            ctx.status(200);
        } else{
            ctx.status(401);
        }
    }

    public void getPastRequestsForUser(Context ctx) {
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null){
            ctx.json(uService.getPastRequestsByUserID(employee.getEmployeeID()));
            ctx.status(200);
        } else{
            ctx.status(401);
        }
    }
}

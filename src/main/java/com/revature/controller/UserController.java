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
        //System.out.println(employee);
    }

    public void logout(Context ctx){
        ctx.consumeSessionAttribute("Employee");
        //System.out.println("consumed");
    }

    public ArrayList<Request> getPendingRequestsByUserID(Context ctx) {

        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()){
            ctx.json(uService.getPendingRequestsByUserID(employee.getEmployeeID()));
            ctx.status(200);
        } else{
            ctx.status(401);
        }

        return null;
    }

    public ArrayList<Request> getAllRequestByUserID(Context ctx) {
        Employee employee = ctx.sessionAttribute("Employee");

        if(employee != null && employee.isManager()){
            ctx.json(uService.getAllRequestsByUserID(employee.getEmployeeID()));
            ctx.status(200);
        } else{
            ctx.status(401);
        }

        return null;
    }
}

package com.revature.controller;
import com.revature.models.Employee;
import io.javalin.http.Context;
import com.revature.service.UserService;


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
}

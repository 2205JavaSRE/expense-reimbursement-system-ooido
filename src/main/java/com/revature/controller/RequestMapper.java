package com.revature.controller;

import io.javalin.Javalin;

public class RequestMapper {
    private UserController uControl = new UserController();
    private RequestController rControl= new RequestController();
    public void configureRoutes(Javalin app){

        app.post("/login", ctx -> { // log in, take credentials and verify
            uControl.login(ctx);
        });

        app.post("/logout", ctx -> { // log out, clear session server side, invalidate cookie?
            uControl.logout(ctx);
        });

        app.post("/employee/request", ctx -> { //input for a new employee request
            rControl.request(ctx);
        });

        app.get("/request/{id}", ctx -> { // get particular request by id
            rControl.requestByID(ctx);
        });

        app.patch("/request/approve/{id}", ctx -> { //approve request
            rControl.approveRequest(ctx);
        });

        app.patch("/request/deny/{id}", ctx -> { //deny request
            rControl.denyRequest(ctx);
        });

        app.get("/requests", ctx -> {  // get all pending requests

        });

        app.get("/requests/history", ctx -> { // get all denied/approved/pending requests

        });

        app.get("/employee/requests", ctx -> { // get all pending requests for a user

        });

        app.get("/employee/requests/history", ctx -> { // get all denied/approved/pending requests for a user

        });

    }

}

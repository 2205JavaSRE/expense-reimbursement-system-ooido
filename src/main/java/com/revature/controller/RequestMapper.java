package com.revature.controller;

import com.revature.utils.Monitoring;
import io.javalin.Javalin;

public class RequestMapper {
    private UserController uControl = new UserController();
    private RequestController rControl= new RequestController();
    public void configureRoutes(Javalin app, Monitoring monitoring){

        app.get("/metrics", ctx -> {
            ctx.result(monitoring.registry.scrape());
        });

        app.post("/login", ctx -> { // log in, take credentials and verify
            uControl.login(ctx);
            monitoring.loginCounter();
        });

        app.post("/logout", ctx -> { // log out, clear session server side, invalidate cookie?
            uControl.logout(ctx);
            monitoring.logoutCounter();
        });

        app.post("/employee/request", ctx -> { //input for a new employee request
            rControl.request(ctx);
            monitoring.requestCounter();
        });

        app.get("/request/{id}", ctx -> { // get particular request by id
            rControl.requestByID(ctx);
            monitoring.requestByIDCounter();
        });

        app.patch("/request/approve/{id}", ctx -> { //approve request
            rControl.approveRequest(ctx);
            monitoring.approveRequestCounter();
        });

        app.patch("/request/deny/{id}", ctx -> { //deny request
            rControl.denyRequest(ctx);
            monitoring.denyRequestCounter();
        });

        app.get("/requests", ctx -> {  // get all pending requests
            rControl.getPendingRequests(ctx);
            monitoring.getAllPendingRequestsCounter();
        });

        app.get("/requests/history", ctx -> { // get all denied/approved/pending requests
            rControl.getAllRequests(ctx);
            monitoring.getAllRequestsCounter();
        });

        app.get("/employee/requests", ctx -> { // get all pending requests for a user
            uControl.getPendingRequestsForUser(ctx);
            monitoring.getAllPendingRequestsForUserCounter();
        });

        app.get("/employee/requests/history", ctx -> { // get all denied/approved/pending requests for a user
            uControl.getAllRequestsForUser(ctx);
            monitoring.getAllRequestsForUserCounter();
        });


    }

}

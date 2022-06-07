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

        app.post("/api/login", ctx -> { // log in, take credentials and verify
            uControl.login(ctx);
            monitoring.loginCounter();
        });

        app.post("/api/logout", ctx -> { // log out, clear session server side, invalidate cookie?
            uControl.logout(ctx);
            monitoring.logoutCounter();
        });

        app.post("/api/employee/request", ctx -> { //input for a new employee request
            rControl.request(ctx);
            monitoring.requestCounter();
        });

        app.get("/api/employee/requests/", ctx -> { // get all denied/approved/pending requests for a user
            uControl.getAllRequestsForUser(ctx);
            monitoring.getAllRequestsForUserCounter();
        });

        app.get("/api/employee/requests/history", ctx -> { // get all denied/approved requests for a user
            uControl.getPastRequestsForUser(ctx);
            monitoring.getPastRequestsForUserCounter();
        });

        app.get("/api/employee/requests/pending", ctx -> { // get all pending requests for a user
            uControl.getPendingRequestsForUser(ctx);
            monitoring.getAllPendingRequestsForUserCounter();
        });

        app.get("/api/request/{id}", ctx -> { // get particular request by id
            rControl.requestByID(ctx);
            monitoring.requestByIDCounter();
        });

        app.patch("/api/request/approve/{id}", ctx -> { //approve request
            rControl.approveRequest(ctx);
            monitoring.approveRequestCounter();
        });

        app.patch("/api/request/deny/{id}", ctx -> { //deny request
            rControl.denyRequest(ctx);
            monitoring.denyRequestCounter();
        });

        app.get("/api/requests/", ctx -> {  // get all approved/denied/pending requests
            rControl.getAllRequests(ctx);
            monitoring.getAllRequestsCounter();
        });

        app.get("/api/requests/history", ctx -> { // get all denied/approved requests
            rControl.getPastRequests(ctx);
            monitoring.getPastRequestsCounter();
        });

        app.get("/api/requests/pending", ctx -> {  // get all pending requests
            rControl.getPendingRequests(ctx);
            monitoring.getAllPendingRequestsCounter();
        });
    }

}

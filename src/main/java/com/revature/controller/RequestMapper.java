package com.revature.controller;

import io.javalin.Javalin;

public class RequestMapper {

    public void configureRoutes(Javalin app){

        app.post("/login", ctx -> { // log in, take credentials and verify

        });

        app.post("/logout", ctx -> { // log out, clear session server side, invalidate cookie?

        });

        app.get("/request/{id}", ctx -> { // get particular request by id

        });

        app.get("/requests", ctx -> {  // get all pending requests

        });

        app.get("/requests/history", ctx -> { // get all denied/approved/pending requests

        });

        app.get("/employee/requests", ctx -> { // get all pending requests for a user

        });

        app.get("/employee/requests/history", ctx -> { // get all denied/approved/pending requests for a user

        });

        app.post("/employee/request", ctx -> { //input for a new employee request

        });

        app.post("/request/approve", ctx -> { //approve request

        });

        app.post("/request/deny", ctx -> { //deny request

        });


    }

}

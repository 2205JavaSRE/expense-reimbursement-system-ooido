package com.revature;

import com.revature.controller.RequestMapper;
import com.revature.utils.Monitoring;
import io.javalin.plugin.metrics.MicrometerPlugin;

import io.javalin.Javalin;


public class MainDriver {

    /**
     * The main function starts javalin with monitoring, and instantiates the request mapper.
     *
     */
    public static void main(String[] args) {

        Monitoring monitoring = new Monitoring();

        Javalin app = Javalin.create(
                config -> {
                    config.registerPlugin(new MicrometerPlugin(monitoring.registry));
                }
        ).start(7500);

        RequestMapper requestMapper = new RequestMapper();
        requestMapper.configureRoutes(app, monitoring);

    }

}

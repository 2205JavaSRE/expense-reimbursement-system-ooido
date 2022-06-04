import java.util.List;
import java.util.Scanner;

import com.revature.controller.RequestMapper;
import com.revature.utils.ConnectionFactory;
import com.revature.utils.Monitoring;
import io.javalin.plugin.metrics.MicrometerPlugin;

import io.javalin.Javalin;


public class MainDriver {
    public static void main(String[] args) {
        System.out.println("Main Start");
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

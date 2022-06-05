package com.revature.utils;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmMemoryMetrics;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import io.micrometer.core.instrument.binder.system.DiskSpaceMetrics;
import io.micrometer.core.instrument.binder.system.ProcessorMetrics;
import io.micrometer.core.instrument.binder.system.UptimeMetrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import java.io.File;

public class Monitoring {

    public PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
    private Counter loginCounter = Counter
            .builder("path_request_to_/login")
            .description("To track the number of logins")
            .tag("purpose", "grafana")
            .register(registry);
    private Counter logoutCounter = Counter
            .builder("path_request_to_/logout")
            .description("To track the number of logouts")
            .tag("purpose", "grafana")
            .register(registry);
    private Counter requestCounter = Counter
            .builder("path_request_to_/request")
            .description("To track the number of new reimbursement requests")
            .tag("purpose", "grafana")
            .register(registry);
    private Counter requestByIDCounter = Counter
            .builder("path_request_to_request/{id}")
            .description("To track the number of new reimbursement requests")
            .tag("purpose", "grafana")
            .register(registry);
    private Counter approveRequestCounter = Counter
            .builder("path_request_to_request/approve/{id}")
            .description("To track the number of approved requests")
            .tag("purpose", "grafana")
            .register(registry);
    private Counter denyRequestCounter = Counter
            .builder("path_request_to_request/deny/{id}")
            .description("To track the number of denied requests")
            .tag("purpose", "grafana")
            .register(registry);
    private Counter getAllPendingRequestsCounter = Counter
            .builder("path_request_to_/requests")
            .description("To track the number of calls for all pending requests by a manager")
            .tag("purpose", "grafana")
            .register(registry);
    private Counter getAllRequestsCounter = Counter
            .builder("path_request_to_/request/history")
            .description("To track the number of calls for all request history by a manager")
            .tag("purpose", "grafana")
            .register(registry);
    private Counter getAllPendingRequestsForUserCounter = Counter
            .builder("path_request_to_/employee/requests")
            .description("To track the number of calls for pending requests for user")
            .tag("purpose", "grafana")
            .register(registry);
    private Counter getAllRequestsForUserCounter = Counter
            .builder("path_request_to_/employee/requests/history")
            .description("To track the number of calls for request history for user")
            .tag("purpose", "grafana")
            .register(registry);

    public Monitoring() {
        registry.config().commonTags("application", "My-First-Monitored-App");
        new ClassLoaderMetrics().bindTo(registry);
        new JvmMemoryMetrics().bindTo(registry);
        new JvmGcMetrics().bindTo(registry);
        new JvmThreadMetrics().bindTo(registry);
        new UptimeMetrics().bindTo(registry);
        new ProcessorMetrics().bindTo(registry);
        new DiskSpaceMetrics(new File(System.getProperty("user.dir"))).bindTo(registry);
    }

    public void loginCounter() {
        loginCounter.increment();
    }
    public void requestCounter() {
        requestCounter.increment();
    }
    public void logoutCounter(){
        logoutCounter.increment();
    }
    public void requestByIDCounter(){
        requestByIDCounter.increment();
    }
    public void approveRequestCounter(){
        approveRequestCounter.increment();
    }
    public void denyRequestCounter(){
        denyRequestCounter.increment();
    }
    public void getAllPendingRequestsCounter(){
        getAllPendingRequestsCounter.increment();
    }
    public void getAllRequestsCounter(){
        getAllRequestsCounter.increment();
    }
    public void getAllPendingRequestsForUserCounter(){
        getAllPendingRequestsForUserCounter.increment();
    }
    public void getAllRequestsForUserCounter(){
        getAllRequestsForUserCounter.increment();
    }
}
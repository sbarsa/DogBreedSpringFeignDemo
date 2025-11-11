package com.sergiubarsa.openfeigndemo.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "demo")
public class DemoActuator {

    @ReadOperation
    public String demoEndpoint() {
        return "This is a demo actuator endpoint";
    }
}

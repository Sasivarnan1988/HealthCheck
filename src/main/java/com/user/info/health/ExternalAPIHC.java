package com.user.info.health;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.Socket;

@Component
@Slf4j
public class ExternalAPIHC
        implements HealthIndicator, HealthContributor {

    private static final String URL
            = "https://dummy.restapiexample.comm/api/v1/employee/1";

    @Override
    public Health health() {
        try (Socket socket =
                     new Socket(new java.net.URL(URL).getHost(),443)) {
        } catch (Exception e) {
            log.warn("Failed to connect to: {}",URL);
            return Health.down()
                    .withDetail("error", e.getMessage())
                    .build();
        }
        return Health.up().build();
    }



}
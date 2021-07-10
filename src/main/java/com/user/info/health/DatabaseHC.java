package com.user.info.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component("Database")
public class DatabaseHC implements HealthIndicator, HealthContributor {

    @Autowired
    private DataSource ds;

    @Override
    public Health health() {
        try(Connection conn = ds.getConnection();){
            Statement stmt = conn.createStatement();
            stmt.execute("select Employee_Number from User_Master");
        } catch (SQLException ex) {
            return Health.outOfService().withException(ex).build();
        }
        return Health.up().build();
    }

}

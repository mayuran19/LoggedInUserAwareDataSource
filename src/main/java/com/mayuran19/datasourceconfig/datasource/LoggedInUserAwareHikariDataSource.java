package com.mayuran19.datasourceconfig.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class LoggedInUserAwareHikariDataSource extends HikariDataSource {
    public LoggedInUserAwareHikariDataSource() {
    }

    public LoggedInUserAwareHikariDataSource(HikariConfig configuration) {
        super(configuration);
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = super.getConnection();

        try (Statement sql = connection.createStatement()) {
            log.debug("Setting the current logged in user 1");
            sql.execute("SET app.session.principal = '" + ThreadLocalStorage.getCurrentLoggedInUser() + "'");
        }

        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Connection connection = super.getConnection(username, password);
        log.debug("Setting the current logged in user 2");
        try (Statement sql = connection.createStatement()) {
            sql.execute("SET app.session.principal = '" + ThreadLocalStorage.getCurrentLoggedInUser() + "'");
        }

        return connection;
    }
}

package com.example.prog2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration

public class ConnectionDb {
    @Value("postgres")
    private String username;

    private String password=System.getenv("db_password");
    @Bean
    public Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/cinema_room",
                username,
                password
        );


    }
}

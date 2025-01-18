package com.funfit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        System.out.println("Initializing database connection...");
        Connection con = null;

        try {
            // 1. Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            String url = "jdbc:mysql://localhost:3306/funfit_db";
            String username = "root";
            String password = "root1234!";

            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Connection error: " + e.getMessage());
            e.printStackTrace();
        }

        return con;
    }
}

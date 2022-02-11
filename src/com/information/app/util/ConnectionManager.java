package com.information.app.util;

import java.sql.*;

public class ConnectionManager {
    static final String URL = "jdbc:mysql://localhost:3308/javaparadise?";
    static final String USER = "root";
    static final String PWD = "";
    static Connection connection = null;
    private static ConnectionManager connectionManager = null;

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    private static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
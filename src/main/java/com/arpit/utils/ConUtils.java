package com.arpit.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConUtils {

    private static final String CONFIG_FILE = "config.properties";
    private static ConUtils instance = null;

    private String dbUsername;
    private String dbUserpwd;
    private String dbLoc;
    private String dbName;

    private Connection connection = null;

    private ConUtils() {
        loadConfig();
    }

    public static synchronized ConUtils getInstance() {
        if (instance == null) {
            instance = new ConUtils();
        }
        return instance;
    }

    private void loadConfig() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + CONFIG_FILE + " in the classpath");
            }
            properties.load(input);

            dbUsername = properties.getProperty("db.username");
            dbUserpwd = properties.getProperty("db.password");
            dbLoc = properties.getProperty("db.url");
            dbName = properties.getProperty("db.driver");
        } catch (IOException e) {
            throw new RuntimeException("Error loading config.properties", e);
        }
    }

    public synchronized Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(dbName);
                connection = DriverManager.getConnection(dbLoc, dbUsername, dbUserpwd);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException("Error connecting to the database", e);
            }
        }
        return connection;
    }

    public synchronized void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                throw new RuntimeException("Error closing the database connection", e);
            }
        }
    }
}

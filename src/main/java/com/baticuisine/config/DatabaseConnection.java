package main.java.com.workpal.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection{

    private Connection connection;
    private static DatabaseConnection instance;

    private static final String URL = "jdbc:postgresql://localhost:5432/workpal";
    private static final String USER = "postgres";
    private static final String PASSWORD = "0074";

    private DatabaseConnection(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e){
            e.printStackTrace();
        throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static DatabaseConnection getInstance(){
        if(instance == null ){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

    public boolean isConnectionValid() {
        try {
            return connection != null && connection.isValid(5);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
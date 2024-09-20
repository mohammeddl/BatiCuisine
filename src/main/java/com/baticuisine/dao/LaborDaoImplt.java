package main.java.com.baticuisine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import main.java.com.baticuisine.config.DatabaseConnection;
import main.java.com.baticuisine.model.Labor;


public class LaborDaoImplt implements LaborDao {
    
    final private Connection connection;

    private final String ADD_LABOR = "INSERT INTO labor ( name, componenttype, project_id, hourlyrate, hoursworked) VALUES (?, ?, ?, ?, ?)";

    public LaborDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void addLabor(Labor labor) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_LABOR);
            preparedStatement.setString(1, labor.getName());
            preparedStatement.setString(2, labor.getTypeComposant());
            preparedStatement.setInt(3, labor.getProjectId());
            preparedStatement.setDouble(4, labor.getHourlyRate());
            preparedStatement.setDouble(5, labor.getHoursWorked());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
}

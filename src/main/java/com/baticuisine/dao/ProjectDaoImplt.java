package main.java.com.baticuisine.dao;

import java.sql.Connection;

import main.java.com.baticuisine.config.DatabaseConnection;
import main.java.com.baticuisine.model.Project;

public class ProjectDaoImplt implements ProjectDao {

    private final Connection connection;

    public ProjectDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    
    @Override
    public void addProject(Project project) {
       // add project
        
    }
    
}

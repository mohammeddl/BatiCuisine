package main.java.com.baticuisine.dao;

import java.sql.Connection;

import main.java.com.baticuisine.config.DatabaseConnection;
import main.java.com.baticuisine.model.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProjectDaoImplt implements ProjectDao {

    private static final String INSERT_PROJECT = "INSERT INTO Project (projectname, client_id, totalcost, margebeneficium, projectstatus ) VALUES (?, ?, ?, ?, ?)";
    private static final String GET_PROJECT_BY_NAME = "SELECT * FROM Project WHERE projectname = ?";

    private final Connection connection;

    public ProjectDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    
    @Override
    public void addProject(Project project) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT);
            preparedStatement.setString(1, project.getProjectName());
            preparedStatement.setInt(2, project.getClient().getId());
            preparedStatement.setDouble(3, project.getTotalCost());
            preparedStatement.setInt(4, project.getMargeBeneficium());
            preparedStatement.setString(5, project.getProjectStatus());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public Project getProjectByName(String name) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PROJECT_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Project(resultSet.getInt("id"), resultSet.getString("projectname"), resultSet.getInt("totalcost"), resultSet.getString("projectstatus"), resultSet.getInt("client_id"), resultSet.getInt("margebeneficium"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

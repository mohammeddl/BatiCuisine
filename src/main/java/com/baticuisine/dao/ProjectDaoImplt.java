package main.java.com.baticuisine.dao;

import java.sql.Connection;

import main.java.com.baticuisine.config.DatabaseConnection;
import main.java.com.baticuisine.model.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProjectDaoImplt implements ProjectDao {

    private static final String INSERT_PROJECT = "INSERT INTO Project (projectname, client_id) VALUES (?, ?)";
    private static final String GET_PROJECT_BY_NAME = "SELECT * FROM Project WHERE projectname = ?";
    private static final String UPDATE_TOTAL_MARGEBINIF = "UPDATE Project SET totalcost = ?, marginbeneficium = ? WHERE projectname = ?";
    private static final String GET_ALL_PROJECTS = "SELECT project.projectname, client.name from project inner join client on project.client_id = client.id";

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
                return new Project(resultSet.getString("projectname"), resultSet.getInt("client_id"), resultSet.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addTotalCost(Project project) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOTAL_MARGEBINIF);
            preparedStatement.setDouble(1, project.getTotalCost());
            preparedStatement.setDouble(2, project.getMargeBeneficium());
            preparedStatement.setString(3, project.getProjectName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public List<Project> getAllProjects() {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PROJECTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("Project: " + resultSet.getString("projectname") + ", Client: " + resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

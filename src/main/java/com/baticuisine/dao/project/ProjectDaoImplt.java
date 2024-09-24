package main.java.com.baticuisine.dao.project;

import java.sql.Connection;

import main.java.com.baticuisine.config.DatabaseConnection;
import main.java.com.baticuisine.model.Client;
import main.java.com.baticuisine.model.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectDaoImplt implements ProjectDao {

    private static final String INSERT_PROJECT = "INSERT INTO Project (projectname, client_id) VALUES (?, ?)";
    private static final String GET_PROJECT_BY_NAME = "SELECT * FROM Project WHERE projectname = ?";
    private static final String UPDATE_PROJECT_STATUS = "UPDATE project SET projectstatus = ? WHERE projectname = ?";
    private static final String UPDATE_TOTAL_MARGEBINIF = "UPDATE Project SET totalcost = ?, marginbeneficium = ? WHERE projectname = ?";
    private static final String GET_ALL_PROJECTS_WITH_CLIENT = "SELECT client.*, project.* FROM project JOIN client ON project.client_id = client.id where project.projectname = ?";
    private static final String GET_ALL_PROJECTS = "SELECT * FROM project";
   

    private final Connection connection;

    public ProjectDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    

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

    public Optional<Project> getProjectByName(String name) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PROJECT_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Project project = new Project(resultSet.getString("projectname"), resultSet.getInt("client_id"), resultSet.getInt("id"), resultSet.getDouble("totalcost"));
                return Optional.of(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
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
    

    public Optional<Project> getAllProjectsWithClient(String name) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PROJECTS_WITH_CLIENT);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Project project = new Project(resultSet.getString("projectname"), new Client(resultSet.getString("name"), resultSet.getString("address"), resultSet.getString("phone"),resultSet.getBoolean("isProfessional")));
                return Optional.of(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();

    }


    public void updateProject(Project project) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROJECT_STATUS);
            preparedStatement.setString(1, project.getProjectStatus());
            preparedStatement.setString(2, project.getProjectName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public List<Project> displayProjects() {
    List<Project> projects = new ArrayList<>();
    
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PROJECTS);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            Project project = new Project(resultSet.getString("projectname"), 
                                          resultSet.getInt("client_id"), 
                                          resultSet.getInt("id"),
                                          resultSet.getDouble("totalcost"));
                                          
            projects.add(project); 
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return projects;
}

}

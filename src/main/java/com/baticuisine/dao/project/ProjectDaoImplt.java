package main.java.com.baticuisine.dao.project;

import java.sql.Connection;

import main.java.com.baticuisine.config.DatabaseConnection;
import main.java.com.baticuisine.model.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class ProjectDaoImplt implements ProjectDao {

    private static final String INSERT_PROJECT = "INSERT INTO Project (projectname, client_id) VALUES (?, ?)";
    private static final String GET_PROJECT_BY_NAME = "SELECT * FROM Project WHERE projectname = ?";
    private static final String UPDATE_TOTAL_MARGEBINIF = "UPDATE Project SET totalcost = ?, marginbeneficium = ? WHERE projectname = ?";
    private static final String GET_ALL_PROJECTS = 
    "SELECT client.name AS client_name, " +
    "project.projectname AS project_name, " +
    "project.totalcost AS total_cost, " +
    "component.name AS component_name, " +
    "component.componenttype AS component_type " +
    "FROM project " +
    "JOIN client ON project.client_id = client.id " +
    "JOIN component ON project.id = component.project_id";


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
    

    public List<Project> getAllProjects() {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PROJECTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String projectInfo = String.format(
                    "Client name: %s | Project name: %s | Total cost: %.2f | Component name: %s | Component type: %s",
                    resultSet.getString("client_name"),
                    resultSet.getString("project_name"),
                    resultSet.getDouble("total_cost"),
                    resultSet.getString("component_name"),
                    resultSet.getString("component_type")
                );
                System.out.println(projectInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

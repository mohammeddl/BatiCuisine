package main.java.com.baticuisine.dao;

import java.util.List;

import main.java.com.baticuisine.model.Project;

public interface ProjectDao {

    public void addProject(Project project);
    Project getProjectByName(String name);
    public void addTotalCost(Project project);
    List<Project> getAllProjects();
    
}

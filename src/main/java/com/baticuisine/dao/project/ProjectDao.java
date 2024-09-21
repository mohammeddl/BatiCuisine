package main.java.com.baticuisine.dao.project;


import java.util.List;
import java.util.Optional;

import main.java.com.baticuisine.model.Project;

public interface ProjectDao {

    public void addProject(Project project);
    Optional<Project> getProjectByName(String name);
    public void addTotalCost(Project project);
    List<Project> getAllProjects();
    
}

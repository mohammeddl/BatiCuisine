package main.java.com.baticuisine.dao;

import main.java.com.baticuisine.model.Project;

public interface ProjectDao {

    public void addProject(Project project);
    Project getProjectByName(String name);

    
}

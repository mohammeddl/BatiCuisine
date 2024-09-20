package main.java.com.baticuisine.repository.project;

import main.java.com.baticuisine.model.Project;
import java.util.List;

public interface ProjectRepository {
    void addProject(Project project);
    Project getProjectByName(String name);
    List<Project> getAllProjects();

}

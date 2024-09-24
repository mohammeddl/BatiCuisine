package main.java.com.baticuisine.repository.project;

import main.java.com.baticuisine.model.Project;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    void addProject(Project project);
    Optional<Project> getProjectByName(String name);
    Optional<Project> getAllProjectsWithClient(String name);
    void addTotalAndbinifit(Project project);
    void updateProject(Project project);
    List<Project> displayProjects();

}

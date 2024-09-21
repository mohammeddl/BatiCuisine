package main.java.com.baticuisine.repository.project;

import main.java.com.baticuisine.model.Project;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    void addProject(Project project);
    Optional<Project> getProjectByName(String name);
    List<Project> getAllProjects();
    void addTotalAndbinifit(Project project);

}

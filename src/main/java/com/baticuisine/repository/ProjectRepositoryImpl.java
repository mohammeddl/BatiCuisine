package main.java.com.baticuisine.repository;

import main.java.com.baticuisine.model.Project;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {
    private final List<Project> projects = new ArrayList<>();


    public void addProject(Project project) {
        projects.add(project);
    }

    public Project getProjectByName(String name) {
        return projects.stream()
                .filter(project -> project.getProjectName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }


    public List<Project> getAllProjects() {
        return new ArrayList<>(projects);
    }
}

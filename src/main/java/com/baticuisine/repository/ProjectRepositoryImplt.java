package main.java.com.baticuisine.repository;

import main.java.com.baticuisine.dao.ProjectDao;
import main.java.com.baticuisine.model.Project;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImplt implements ProjectRepository {
    private final List<Project> projects = new ArrayList<>();

    private final ProjectDao projectDao;

    public ProjectRepositoryImplt(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }


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

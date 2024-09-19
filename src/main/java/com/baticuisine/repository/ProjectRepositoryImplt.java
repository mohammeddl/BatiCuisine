package main.java.com.baticuisine.repository;

import main.java.com.baticuisine.dao.ProjectDaoImplt;
import main.java.com.baticuisine.model.Project;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImplt implements ProjectRepository {
    private final List<Project> projects = new ArrayList<>();

    private final ProjectDaoImplt projectDaoImplt;

    public ProjectRepositoryImplt(ProjectDaoImplt projectDaoImplt) {
        this.projectDaoImplt = projectDaoImplt;
    }


    public void addProject(Project project) {
        projectDaoImplt.addProject(project);
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

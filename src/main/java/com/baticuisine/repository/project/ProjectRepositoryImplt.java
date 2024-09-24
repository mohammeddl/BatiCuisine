package main.java.com.baticuisine.repository.project;

import main.java.com.baticuisine.dao.project.ProjectDaoImplt;
import main.java.com.baticuisine.model.Project;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectRepositoryImplt implements ProjectRepository {
    private final List<Project> projects = new ArrayList<>();

    private final ProjectDaoImplt projectDaoImplt;

    public ProjectRepositoryImplt(ProjectDaoImplt projectDaoImplt) {
        this.projectDaoImplt = projectDaoImplt;
    }


    public void addProject(Project project) {
        projectDaoImplt.addProject(project);
    }

    public Optional<Project> getProjectByName(String name) {
        return projectDaoImplt.getProjectByName(name);
    }


    public Optional<Project> getAllProjectsWithClient(String name) {
        return projectDaoImplt.getAllProjectsWithClient(name);
    }

    public void addTotalAndbinifit(Project project) {
        projectDaoImplt.addTotalCost(project);
    }

    public void updateProject(Project project) {
        projectDaoImplt.updateProject(project);
    }

    public List<Project> displayProjects() {
        return projectDaoImplt.displayProjects();
    }
}

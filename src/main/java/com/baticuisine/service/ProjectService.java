package main.java.com.baticuisine.service;

import java.util.List;

import main.java.com.baticuisine.model.Project;
import main.java.com.baticuisine.repository.ProjectRepository;

public class ProjectService {
    
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void addProject(Project project) {
        projectRepository.addProject(project);
    }

    public void displayProjects() {
        List<Project> projects = projectRepository.getAllProjects();
        for (Project project : projects) {
            System.out.println("Project: " + project.getProjectName() + ", Client: " + project.getClient().getName());
        }
    }

    public void calculateProjectCost(String projectName) {
        Project project = projectRepository.getProjectByName(projectName);
        if (project != null) {
            double totalCost = project.calculateTotalCost();
            System.out.println("Total cost of project " + projectName + ": " + totalCost);
        } else {
            System.out.println("Project not found!");
        }
    }
}

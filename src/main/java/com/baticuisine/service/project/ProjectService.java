package main.java.com.baticuisine.service.project;

import java.util.List;

import main.java.com.baticuisine.model.Project;
import main.java.com.baticuisine.repository.project.ProjectRepositoryImplt;

public class ProjectService {
    
    private final ProjectRepositoryImplt projectRepositoryImplt;

    public ProjectService(ProjectRepositoryImplt projectRepositoryImplt) {
        this.projectRepositoryImplt = projectRepositoryImplt;
    }

    public void addProject(Project project) {
        projectRepositoryImplt.addProject(project);
        System.out.println("Project created successfully!");
    }

    public Project getProjectByName(String name) {
        return projectRepositoryImplt.getProjectByName(name);
    }

    public void displayProjects() {
        List<Project> projects = projectRepositoryImplt.getAllProjects();
        for (Project project : projects) {
            System.out.println("Project: " + project.getProjectName() + ", Client: " + project.getClient().getName());
        }
    }

    public void calculateProjectCost(String projectName) {
        Project project = projectRepositoryImplt.getProjectByName(projectName);
        if (project != null) {
            double totalCost = project.calculateTotalCost();
            System.out.println("Total cost of project " + projectName + ": " + totalCost);
        } else {
            System.out.println("Project not found!");
        }
    }

    public void calculateProjectBenefit(Project project) {
        projectRepositoryImplt.addTotalAndbinifit(project);
    }
}

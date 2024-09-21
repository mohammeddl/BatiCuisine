package main.java.com.baticuisine.service.project;

import java.util.List;
import java.util.Optional;

import main.java.com.baticuisine.model.Project;
import main.java.com.baticuisine.repository.project.ProjectRepositoryImplt;

public class ProjectService {
    
    private final ProjectRepositoryImplt projectRepositoryImplt;

    public ProjectService(ProjectRepositoryImplt projectRepositoryImplt) {
        this.projectRepositoryImplt = projectRepositoryImplt;
    }

    // Adds a new project to the repository
    public void addProject(Project project) {
        projectRepositoryImplt.addProject(project);
        System.out.println("Project created successfully!");
    }

    // Retrieves a project by its name using Optional
    public Optional<Project> getProjectByName(String name) {
        return projectRepositoryImplt.getProjectByName(name);
    }

    // Displays all projects
    public void displayProjects() {
       projectRepositoryImplt.getAllProjects(); // Consider returning the list of projects for further use
    }

    // Calculates and displays the total cost of a project by its name
    public void calculateProjectCost(String projectName) {
        // Using ifPresentOrElse to handle both cases (project found or not)
        projectRepositoryImplt.getProjectByName(projectName).ifPresentOrElse(
            project -> {
                double totalCost = project.calculateTotalCost();
                System.out.println("Total cost of project " + projectName + ": " + totalCost);
            },
            () -> System.out.println("Project not found!")
        );
    }

    // Calculates the total cost and benefit of a project and saves it
    public void calculateProjectBenefit(Project project) {
        projectRepositoryImplt.addTotalAndbinifit(project);
    }
}

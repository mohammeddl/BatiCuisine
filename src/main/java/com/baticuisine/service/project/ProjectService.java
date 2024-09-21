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


    public void addProject(Project project) {
        projectRepositoryImplt.addProject(project);
        System.out.println("Project created successfully!");
    }

    public Optional<Project> getProjectByName(String name) {
        return projectRepositoryImplt.getProjectByName(name);
    }

    public void displayProjects() {
       projectRepositoryImplt.getAllProjects(); 
    }

    public void updateProject(Project project) {
        projectRepositoryImplt.updateProject(project);
    }

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

    public void calculateProjectBenefit(Project project) {
        projectRepositoryImplt.addTotalAndbinifit(project);
    }


}

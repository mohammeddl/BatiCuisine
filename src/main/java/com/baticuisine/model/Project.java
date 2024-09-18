package main.java.com.baticuisine.model;

import java.util.ArrayList;
import java.util.List;




public class Project {
    private int id;
    private String projectName;
    private double totalCost;
    private String projectStatus;
    private Client client;
    private Quote quote;
    private List<Component> components;

    public Project(int id, String projectName, double totalCost, String projectStatus, Client client) {
        this.id = id;
        this.projectName = projectName;
        this.totalCost = totalCost;
        this.projectStatus = projectStatus;
        this.client = client;
        this.components = new ArrayList<>();
    }

    // Getters and Setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void addComponent(Component component) {
        components.add(component);
    }


}

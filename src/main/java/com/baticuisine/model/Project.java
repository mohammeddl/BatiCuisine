package main.java.com.baticuisine.model;

import java.util.ArrayList;
import java.util.List;




public class Project {
    private int id;
    private String projectName;
    private double totalCost;
    private String projectStatus;
    private int margeBeneficium;
    private Client client;
    private Quote quote;
    private List<Component> components;

    public Project(int id, String projectName, double totalCost, String projectStatus, Client client, int margeBeneficium) {
        this.id = id;
        this.projectName = projectName;
        this.totalCost = totalCost;
        this.projectStatus = projectStatus;
        this.client = client;
        this.margeBeneficium = margeBeneficium;
        this.components = new ArrayList<>();
    }

    public Project(String projectName, Client client) {
        this.projectName = projectName;
        this.client = client;
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

    public void setMargeBeneficium(int margeBeneficium) {
        this.margeBeneficium = margeBeneficium;
    }

    public int getMargeBeneficium() {
        return margeBeneficium;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void addComponent(Component component) {
        components.add(component);
    }


    public double calculateTotalCost() {
        double totalCost = 0;
        for (Component component : components) {
            totalCost += component.calculateCost();
        }
        return totalCost;
    }

}

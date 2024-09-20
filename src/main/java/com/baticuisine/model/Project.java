package main.java.com.baticuisine.model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String projectName;
    private double totalCost;
    private String projectStatus;
    private double margeBeneficium;
    private int clientId; 
    private Client client;
    private Quote quote; 
    private List<Component> components;
    private List<Material> materials; 
    private List<Labor> labors; 


    public Project(int id, String projectName, double totalCost, String projectStatus, int clientId, double margeBeneficium) {
        this.id = id;
        this.projectName = projectName;
        this.totalCost = totalCost;
        this.projectStatus = projectStatus;
        this.clientId = clientId;
        this.margeBeneficium = margeBeneficium;
        this.components = new ArrayList<>();
        this.materials = new ArrayList<>(); 
        this.labors = new ArrayList<>(); 
    }

    // Constructor with projectName and Client
    public Project(String projectName, Client client) {
        this.projectName = projectName;
        this.client = client;
        this.components = new ArrayList<>();
        this.materials = new ArrayList<>(); 
        this.labors = new ArrayList<>(); 
    }

    public Project(String projectName, int clientId , int id) {
        this.projectName = projectName;
        this.clientId = clientId;
        this.id = id;
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

    public double getMargeBeneficium() {
        return margeBeneficium;
    }

    public void setMargeBeneficium(double margeBeneficium) {
        this.margeBeneficium = margeBeneficium;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void addMaterial(Material material) {
        materials.add(material);
    }

    public List<Labor> getLabors() {
        return labors;
    }

    public void addLabor(Labor labor) {
        labors.add(labor);
    }

    // Method to calculate the total cost based on materials and labor
    public double calculateTotalCost() {
        double totalMaterialCost = materials.stream()
                                            .mapToDouble(Material::calculateCost)
                                            .sum();

        double totalLaborCost = labors.stream()
                                    .mapToDouble(Labor::calculateCost)
                                    .sum();

        totalCost = totalMaterialCost + totalLaborCost;
        return totalCost;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void addComponent(Component component) {
        components.add(component);
    }
}

package main.java.com.baticuisine.model;

public abstract class Component {
    
    private int id;
    private String name;
    private String typeComposant;
    private int projectId;

    public Component( String name, String typeComposant, int projectId) {
        this.name = name;
        this.typeComposant = typeComposant;
        this.projectId = projectId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeComposant() {
        return typeComposant;
    }

    public void setTypeComposant(String typeComposant) {
        this.typeComposant = typeComposant;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public abstract double calculateCost();



}
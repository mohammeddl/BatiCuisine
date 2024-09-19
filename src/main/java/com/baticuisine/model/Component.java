package main.java.com.baticuisine.model;

public abstract class Component {
    
    private int id;
    private String name;

    public Component(int id, String name) {
        this.id = id;
        this.name = name;
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


    // Abstract method to calculate the cost of a component
    public abstract double calculateCost();
}
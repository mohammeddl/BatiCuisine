package main.java.com.baticuisine.model;

public class Material extends Component {
    private int taxRate;
    private int transportCost;
    private int quantity;

    public Material(String name, int quantity, int taxRate, int transportCost, String typeComposant, int projectId) {
        super(name, typeComposant, projectId);
        this.taxRate = taxRate;
        this.transportCost = transportCost;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }

    public int getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(int transportCost) {
        this.transportCost = transportCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateCost() {
        return getQuantity() * (taxRate + transportCost);
    }
    
}

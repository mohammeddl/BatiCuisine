package main.java.com.baticuisine.model;

public class Material extends Component {
    private int taxRate;
    private int transportCost;

    public Material(int id, String name, int quantity, int taxRate, int transportCost) {
        super(id, name, quantity);
        this.taxRate = taxRate;
        this.transportCost = transportCost;
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


    public double calculateCost() {
        return getQuantity() * (taxRate + transportCost);
    }
}

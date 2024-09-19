package main.java.com.baticuisine.model;

public class Labor extends Component {
    private int hourlyRate;
    private int hoursWorked;

    public Labor(int id, String name, int hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Getters and Setters
    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateCost() {
        return hoursWorked * hourlyRate;
    }
}

package main.java.com.baticuisine.model;

import java.util.Date;

public class Quote {
    private int id;
    private double estimatedAmount;
    private Date issueDate;
    private Date validityDate;
    private boolean isAccepted;
    private int projectId;

    public Quote(double estimatedAmount, Date issueDate, Date validityDate, boolean isAccepted, int projectId) {
        this.estimatedAmount = estimatedAmount;
        this.issueDate = issueDate;
        this.validityDate = validityDate;
        this.isAccepted = isAccepted;
        this.projectId = projectId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void generateQuote(double totalMaterialCost, double totalLaborCost) {
        this.estimatedAmount = totalMaterialCost + totalLaborCost;
        this.issueDate = new Date(); // Set the current date as the issue date
        this.validityDate = new Date(issueDate.getTime() + (7 * 24 * 60 * 60 * 1000)); // 7 days validity
    }

    @Override
    public String toString() {
        return "Quote [id=" + id + ", estimatedAmount=" + estimatedAmount + ", issueDate=" + issueDate
                + ", validityDate=" + validityDate + ", isAccepted=" + isAccepted + "]";
    }
}


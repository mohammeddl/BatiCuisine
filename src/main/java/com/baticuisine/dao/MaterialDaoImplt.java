package main.java.com.baticuisine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import main.java.com.baticuisine.config.DatabaseConnection;
import main.java.com.baticuisine.model.Material;

public class MaterialDaoImplt {

    private static final String INSERT_MATERIAL = "INSERT INTO material (name,  componenttype, project_id, taxrate, transportcost, quantity) VALUES (?, ?, ?, ?, ?, ?)";
    

    private final Connection connection;

    public MaterialDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void addMaterial(Material material) {
    try{
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATERIAL);
        preparedStatement.setString(1, material.getName());
        preparedStatement.setString(2, material.getTypeComposant());
        preparedStatement.setInt(3, material.getProjectId());
        preparedStatement.setDouble(4, material.getTaxRate());
        preparedStatement.setDouble(5, material.getTransportCost());
        preparedStatement.setInt(6, material.getQuantity());
        preparedStatement.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }

}




}

package main.java.com.baticuisine.dao.client;

import main.java.com.baticuisine.config.DatabaseConnection;
import main.java.com.baticuisine.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class ClientDaoImplt implements ClientDao {

    private static final String INSERT_CLIENT = "INSERT INTO Client (name, address, phone, isProfessional) VALUES (?, ?, ?, ?)";
    private static final String SELECT_CLIENT_BY_NAME = "SELECT id, name, address, phone, isProfessional FROM Client WHERE name = ?";


    private final Connection connection;

    public ClientDaoImplt() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void addClient(Client client) {
    try{
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT);
        preparedStatement.setString(1, client.getName());
        preparedStatement.setString(2, client.getAddress());
        preparedStatement.setString(3, client.getPhone());
        preparedStatement.setBoolean(4, client.isProfessional());
        preparedStatement.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public Optional<Client> getClientByName(String name) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return Optional.of(new Client(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("address"), resultSet.getString("phone"), resultSet.getBoolean("isProfessional")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
}

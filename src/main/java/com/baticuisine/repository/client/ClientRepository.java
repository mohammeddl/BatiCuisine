package main.java.com.baticuisine.repository.client;

import java.util.List;
import java.util.Optional;

import main.java.com.baticuisine.model.Client;

public interface ClientRepository {
    void addClient(Client client);
    Optional<Client> getClientByName(String name);
    List<Client> getAllClients();
    
} 

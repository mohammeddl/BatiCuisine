package main.java.com.baticuisine.repository;

import java.util.List;

import main.java.com.baticuisine.model.Client;

public interface ClientRepository {
    void addClient(Client client);
    Client getClientByName(String name);
    List<Client> getAllClients();
    
} 

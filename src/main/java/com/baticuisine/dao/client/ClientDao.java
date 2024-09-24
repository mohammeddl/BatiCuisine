package main.java.com.baticuisine.dao.client;

import java.util.Optional;

import main.java.com.baticuisine.model.Client;

public interface ClientDao {
    public void addClient(Client client);
    Optional<Client> getClientByName(String name);
}


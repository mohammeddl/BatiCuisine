package main.java.com.baticuisine.dao.client;

import main.java.com.baticuisine.model.Client;

public interface ClientDao {
    public void addClient(Client client);
    Client getClientByName(String name);
}


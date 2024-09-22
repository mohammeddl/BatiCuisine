package main.java.com.baticuisine.service.client;

import java.util.Optional;

import main.java.com.baticuisine.model.Client;

public interface ClientService {

    void addClient(Client client);
    Optional<Client> getClientByName(String name);
    Client displayAllClients();

} 

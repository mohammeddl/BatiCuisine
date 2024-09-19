package main.java.com.baticuisine.service;

import main.java.com.baticuisine.model.Client;

public interface ClientService {

    void addClient(Client client);
    Client getClientByName(String name);
    Client displayAllClients();

} 

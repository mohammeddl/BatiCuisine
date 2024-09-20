package main.java.com.baticuisine.service;

import main.java.com.baticuisine.model.Client;
import main.java.com.baticuisine.repository.client.ClientRepository;

public class ClientServiceImplt implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImplt(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Client client) {
        if (clientRepository.getClientByName(client.getName()) != null) {
            System.out.println("Client with this name already exists.");
        } else {
            clientRepository.addClient(client);
            System.out.println("Client added successfully.");
        }
    }

    public Client getClientByName(String name) {
        Client client = clientRepository.getClientByName(name);
        if (client != null) {
            System.out.println("Client found: " + client.getName());
        } else {
            System.out.println("Client not found.");
        }
        return client;
    }


    public Client displayAllClients() {
        System.out.println("All clients: ");
        for (Client client : clientRepository.getAllClients()) {
            System.out.println(client.getName());
        }
        return null;
    }
}

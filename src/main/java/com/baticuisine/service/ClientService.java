package main.java.com.baticuisine.service;

import java.util.List;
import main.java.com.baticuisine.model.Client;
import main.java.com.baticuisine.repository.ClientRepository;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Client client) {
        // if (clientRepository.getClientByName(client.getName()) != null) {
        //     System.out.println("Client with this name already exists.");
        // } else {
            clientRepository.addClient(client);
            System.out.println("Client added successfully.");
        // }
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

    public void displayAllClients() {
        List<Client> clients = clientRepository.getAllClients();
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
        } else {
            clients.forEach(client -> {
                System.out.println("Client: " + client.getName() + ", Address: " + client.getAddress());
            });
        }
    }
}

package main.java.com.baticuisine.service.client;

import java.util.Optional;

import main.java.com.baticuisine.model.Client;
import main.java.com.baticuisine.repository.client.ClientRepository;

public class ClientServiceImplt implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImplt(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Client client) {
        if (clientRepository.getClientByName(client.getName()) != null) {
            clientRepository.addClient(client);
            System.out.println("Client added successfully.");
        } else {
            System.out.println("Client with this name already exists.");
        }
    }

    public Optional<Client> getClientByName(String name) {
        Optional<Client> client = clientRepository.getClientByName(name);
        if (client.isPresent()) {
            System.out.println("Client found: " + client.get().getName());
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

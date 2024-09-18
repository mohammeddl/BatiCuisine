package main.java.com.baticuisine.repository;

import main.java.com.baticuisine.model.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImplt implements ClientRepository {
    private final List<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
    }

    public Client getClientByName(String name) {
        return clients.stream()
                .filter(client -> client.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clients);
    }
}

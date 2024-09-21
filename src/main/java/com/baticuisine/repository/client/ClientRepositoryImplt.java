package main.java.com.baticuisine.repository.client;

import main.java.com.baticuisine.dao.client.ClientDaoImplt;
import main.java.com.baticuisine.model.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImplt implements ClientRepository {

    private final ClientDaoImplt clientDaoImplt;

    private final List<Client> clients = new ArrayList<>();

    public ClientRepositoryImplt(ClientDaoImplt clientDaoImplt) {
        this.clientDaoImplt = clientDaoImplt;
    }

    
    public void addClient(Client client) {
        clientDaoImplt.addClient(client);
    }

    public Client getClientByName(String name) {
       return clientDaoImplt.getClientByName(name);
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clients);
    }
}

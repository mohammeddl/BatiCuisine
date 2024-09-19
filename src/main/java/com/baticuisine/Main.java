package main.java.com.baticuisine;

import main.java.com.baticuisine.dao.ClientDaoImplt;
import main.java.com.baticuisine.dao.ProjectDaoImplt;
import main.java.com.baticuisine.repository.ClientRepositoryImplt;
import main.java.com.baticuisine.service.ClientService;
import main.java.com.baticuisine.service.ProjectService;
import main.java.com.baticuisine.repository.ProjectRepositoryImplt;
import main.java.com.baticuisine.ui.Menu;

public class Main {
    
    public static void main(String[] args) {
        ClientDaoImplt clientDaoImplt = new ClientDaoImplt();
        ClientRepositoryImplt clientRepositoryImplt = new ClientRepositoryImplt(clientDaoImplt);
        ClientService clientService = new ClientService(clientRepositoryImplt);

        ProjectDaoImplt projectDaoImplt = new ProjectDaoImplt(); 
        ProjectRepositoryImplt projectRepositoryImplt = new ProjectRepositoryImplt(projectDaoImplt);
        ProjectService projectService = new ProjectService(projectRepositoryImplt);

        Menu menu = new Menu(projectService, clientService);
        menu.displayMenu();


  

    }
}

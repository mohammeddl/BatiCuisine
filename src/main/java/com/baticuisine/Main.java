package main.java.com.baticuisine;

import main.java.com.baticuisine.dao.ClientDaoImplt;
import main.java.com.baticuisine.dao.MaterialDaoImplt;
import main.java.com.baticuisine.dao.ProjectDaoImplt;
import main.java.com.baticuisine.service.ClientServiceImplt;
import main.java.com.baticuisine.service.MaterialServiceImplt;
import main.java.com.baticuisine.service.ProjectService;
import main.java.com.baticuisine.repository.client.ClientRepositoryImplt;
import main.java.com.baticuisine.repository.material.MaterialRepositoryImplt;
import main.java.com.baticuisine.repository.project.ProjectRepositoryImplt;
import main.java.com.baticuisine.ui.Menu;

public class Main {
    
    public static void main(String[] args) {
        ClientDaoImplt clientDaoImplt = new ClientDaoImplt();
        ClientRepositoryImplt clientRepositoryImplt = new ClientRepositoryImplt(clientDaoImplt);
        ClientServiceImplt clientService = new ClientServiceImplt(clientRepositoryImplt);

        ProjectDaoImplt projectDaoImplt = new ProjectDaoImplt(); 
        ProjectRepositoryImplt projectRepositoryImplt = new ProjectRepositoryImplt(projectDaoImplt);
        ProjectService projectService = new ProjectService(projectRepositoryImplt);

        MaterialDaoImplt materialDaoImplt = new MaterialDaoImplt();
        MaterialRepositoryImplt materialRepositoryImplt = new MaterialRepositoryImplt(materialDaoImplt);
        MaterialServiceImplt materialService = new MaterialServiceImplt(materialRepositoryImplt);

        

        Menu menu = new Menu(projectService, clientService, materialService);
        menu.displayMenu();


  

    }
}

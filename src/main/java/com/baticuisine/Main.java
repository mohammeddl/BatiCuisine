package main.java.com.baticuisine;

import main.java.com.baticuisine.dao.ClientDaoImplt;
import main.java.com.baticuisine.dao.LaborDaoImplt;
import main.java.com.baticuisine.dao.MaterialDaoImplt;
import main.java.com.baticuisine.dao.ProjectDaoImplt;
import main.java.com.baticuisine.model.Labor;
import main.java.com.baticuisine.service.client.ClientServiceImplt;
import main.java.com.baticuisine.service.labor.LaborServiceImplt;
import main.java.com.baticuisine.service.material.MaterialServiceImplt;
import main.java.com.baticuisine.service.project.ProjectService;
import main.java.com.baticuisine.repository.client.ClientRepositoryImplt;
import main.java.com.baticuisine.repository.labor.LaborRepositoryImplt;
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

        LaborDaoImplt laborDaoImplt = new LaborDaoImplt();
        LaborRepositoryImplt laborRepositoryImplt = new LaborRepositoryImplt(laborDaoImplt);
        LaborServiceImplt laborServiceImplt = new LaborServiceImplt(laborRepositoryImplt);

        

        Menu menu = new Menu(projectService, clientService, materialService, laborServiceImplt);
        menu.displayMenu();


  

    }
}

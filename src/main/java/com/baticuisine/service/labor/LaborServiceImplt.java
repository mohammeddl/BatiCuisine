package main.java.com.baticuisine.service.labor;

import main.java.com.baticuisine.model.Labor;
import main.java.com.baticuisine.repository.labor.LaborRepositoryImplt;

public class LaborServiceImplt implements LaborService {
    
    private final LaborRepositoryImplt laborRepositoryImplt;

    public LaborServiceImplt(LaborRepositoryImplt laborRepositoryImplt) {
        this.laborRepositoryImplt = laborRepositoryImplt;
    }

    public void addLabor(Labor labor) {
        laborRepositoryImplt.addLabor(labor);
        System.out.println("Labor added successfully");
    }
    
}

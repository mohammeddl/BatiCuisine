package main.java.com.baticuisine.repository.labor;

import main.java.com.baticuisine.dao.component.LaborDaoImplt;
import main.java.com.baticuisine.model.Labor;

public class LaborRepositoryImplt implements LaborRepository {

    private final LaborDaoImplt laborDaoImplt;

    public LaborRepositoryImplt(LaborDaoImplt laborDaoImplt) {
        this.laborDaoImplt = laborDaoImplt;
    }
    
    public void addLabor(Labor labor) {
        laborDaoImplt.addLabor(labor);
    }
    
}

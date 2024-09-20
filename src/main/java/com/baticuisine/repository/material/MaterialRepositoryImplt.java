package main.java.com.baticuisine.repository.material;

import main.java.com.baticuisine.dao.MaterialDaoImplt;
import main.java.com.baticuisine.model.Material;

public class MaterialRepositoryImplt implements MaterialRepository {

    private final MaterialDaoImplt materialDaoImplt;

    public MaterialRepositoryImplt(MaterialDaoImplt materialDaoImplt) {
        this.materialDaoImplt = materialDaoImplt;
    }

    public void addMaterial(Material material) {
        materialDaoImplt.addMaterial(material);
    }
    
}

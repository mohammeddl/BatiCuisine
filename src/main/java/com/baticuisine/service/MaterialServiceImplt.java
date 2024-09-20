package main.java.com.baticuisine.service;

import main.java.com.baticuisine.model.Material;
import main.java.com.baticuisine.repository.material.MaterialRepositoryImplt;

public class MaterialServiceImplt implements MaterialService {
    
    private final MaterialRepositoryImplt materialRepositoryImplt;

    public MaterialServiceImplt(MaterialRepositoryImplt materialRepositoryImplt) {
        this.materialRepositoryImplt = materialRepositoryImplt;
    }

    public void addMaterial(Material material) {
        materialRepositoryImplt.addMaterial(material);
        
    }
    
}

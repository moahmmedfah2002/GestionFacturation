package ma.ensa.project.service;

import ma.ensa.project.entity.Produit;
import ma.ensa.project.repo.ProduitRepo;

import java.util.List;

public class ProduitService implements ProduitRepo {
    @Override
    public boolean addProduit(Produit p) {
        return false;
    }

    @Override
    public boolean updateProduit(Produit p) {
        return false;
    }

    @Override
    public boolean deleteProduit(int id) {
        return false;
    }

    @Override
    public Produit getProduit(int id) {
        return null;
    }

    @Override
    public List<Produit> getAllProduits() {
        return List.of();
    }
}

package ma.ensa.project.repo;

import ma.ensa.project.entity.Produit;

import java.util.List;

public interface ProduitRepo {
    boolean addProduit(Produit p);
    boolean updateProduit(Produit p);
    boolean deleteProduit(int id);
    Produit getProduit(int id);
    List<Produit> getAllProduits();

}

package ma.ensa.project.repo;

import ma.ensa.project.entity.Produit;

import java.sql.SQLException;
import java.util.List;

public interface ProduitRepo {
    void addProduit(Produit p) throws SQLException;
    void updateProduit(Produit p) throws SQLException;
    void deleteProduit(int id) throws SQLException;
    Produit getProduit(int id) throws SQLException;
    List<Produit> getAllProduits() throws SQLException;

}

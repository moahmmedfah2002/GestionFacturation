package ma.ensa.project.repo;

import ma.ensa.project.entity.Commande;

import java.sql.SQLException;
import java.util.List;

public interface CommandeRepo {
    boolean addCommande(Commande commande) throws SQLException;
    Commande getCommande(int id) throws SQLException;
    List<Commande> getCommandes() throws SQLException;
    boolean updateCommande(Commande commande) throws SQLException;
    boolean deleteCommande(int id) throws SQLException;

}

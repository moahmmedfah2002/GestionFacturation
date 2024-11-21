package ma.ensa.project.service;

import ma.ensa.project.Connexion;
import ma.ensa.project.entity.Commande;
import ma.ensa.project.repo.DetaileCommandeRepo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DetaileCommandeService implements DetaileCommandeRepo {
    private Connexion connexion;
    private Connection con;

    public DetaileCommandeService() throws SQLException, ClassNotFoundException {
        connexion=new Connexion();
        con=connexion.getCon();
    }
    @Override
    public boolean addDetaileCommande(Commande commande) {
        return false;
    }

    @Override
    public boolean updateDetaileCommande(Commande commande) {
        return false;
    }

    @Override
    public boolean deleteDetaileCommande(Commande commande) {
        return false;
    }

    @Override
    public Commande getDetaileCommande(int id) {
        return null;
    }

    @Override
    public List<Commande> getDetaileCommandes() {
        return List.of();
    }
}

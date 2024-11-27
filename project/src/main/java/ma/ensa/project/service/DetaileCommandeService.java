package ma.ensa.project.service;

import ma.ensa.project.Connexion;
import ma.ensa.project.entity.Commande;
import ma.ensa.project.entity.DetaileCommande;
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
    public boolean addDetaileCommande(DetaileCommande detailecommande) {
        return false;
    }

    @Override
    public boolean updateDetaileCommande(DetaileCommande detaileCommande) {
        return false;
    }

    @Override
    public boolean deleteDetaileCommande(int id) {
        return false;
    }

    @Override
    public DetaileCommande getDetaileCommande(int id) {
        return null;
    }

    @Override
    public List<DetaileCommande> getDetaileCommandes() {
        return List.of();
    }
}

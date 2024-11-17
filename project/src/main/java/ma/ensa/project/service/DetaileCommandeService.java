package ma.ensa.project.service;

import ma.ensa.project.entity.Commande;
import ma.ensa.project.repo.DetaileCommandeRepo;

import java.util.List;

public class DetaileCommandeService implements DetaileCommandeRepo {
    @Override
    public boolean addCommande(Commande commande) {
        return false;
    }

    @Override
    public boolean updateCommande(Commande commande) {
        return false;
    }

    @Override
    public boolean deleteCommande(Commande commande) {
        return false;
    }

    @Override
    public Commande getCommande(int id) {
        return null;
    }

    @Override
    public List<Commande> getCommandes() {
        return List.of();
    }
}

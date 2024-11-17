package ma.ensa.project.service;

import ma.ensa.project.entity.Commande;
import ma.ensa.project.repo.CommandeRepo;

import java.util.List;

public class CommandeService implements CommandeRepo {
    @Override
    public boolean addCommande(Commande commande) {
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

    @Override
    public int updateCommande(Commande commande) {
        return 0;
    }

    @Override
    public int deleteCommande(int id) {
        return 0;
    }
}

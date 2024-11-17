package ma.ensa.project.repo;

import ma.ensa.project.entity.Commande;

import java.util.List;

public interface DetaileCommandeRepo {
    boolean addCommande(Commande commande);
    boolean updateCommande(Commande commande);
    boolean deleteCommande(Commande commande);
    Commande getCommande(int id);
    List<Commande> getCommandes();

}

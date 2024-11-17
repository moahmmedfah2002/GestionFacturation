package ma.ensa.project.repo;

import ma.ensa.project.entity.Commande;

import java.util.List;

public interface CommandeRepo {
    boolean addCommande(Commande commande);
    Commande getCommande(int id);
    List<Commande> getCommandes();
    int updateCommande(Commande commande);
    int deleteCommande(int id);

}

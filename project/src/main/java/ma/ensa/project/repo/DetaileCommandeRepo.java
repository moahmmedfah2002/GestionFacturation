package ma.ensa.project.repo;

import ma.ensa.project.entity.Commande;

import java.util.List;

public interface DetaileCommandeRepo {
    boolean addDetaileCommande(Commande commande);
    boolean updateDetaileCommande(Commande commande);
    boolean deleteDetaileCommande(Commande commande);
    Commande getDetaileCommande(int id);
    List<Commande> getDetaileCommandes();

}

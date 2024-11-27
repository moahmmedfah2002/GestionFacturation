package ma.ensa.project.repo;

import ma.ensa.project.entity.Commande;
import ma.ensa.project.entity.DetaileCommande;

import java.util.List;

public interface DetaileCommandeRepo {
    boolean addDetaileCommande(DetaileCommande detaileCommande);
    boolean updateDetaileCommande(DetaileCommande DetaileCommande);
    boolean deleteDetaileCommande(int id);
    DetaileCommande getDetaileCommande(int id);
    List<DetaileCommande> getDetaileCommandes();

}

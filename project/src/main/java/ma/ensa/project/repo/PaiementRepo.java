package ma.ensa.project.repo;

import ma.ensa.project.entity.Paiement;

import java.util.List;

public interface PaiementRepo {
    boolean addPaiement(Paiement paiement);
    boolean removePaiement(Paiement paiement);
    boolean updatePaiement(Paiement paiement);
    Paiement getPaiement(int id);
    List<Paiement> getAllPaiement();

}

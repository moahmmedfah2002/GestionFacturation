package ma.ensa.project.service;

import ma.ensa.project.entity.Paiement;
import ma.ensa.project.repo.PaiementRepo;

import java.util.List;

public class PaimentService implements PaiementRepo {
    @Override
    public boolean addPaiement(Paiement paiement) {
        return false;
    }

    @Override
    public boolean removePaiement(Paiement paiement) {
        return false;
    }

    @Override
    public boolean updatePaiement(Paiement paiement) {
        return false;
    }

    @Override
    public Paiement getPaiement(int id) {
        return null;
    }

    @Override
    public List<Paiement> getAllPaiement() {
        return List.of();
    }
}

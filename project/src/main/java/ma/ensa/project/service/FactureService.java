package ma.ensa.project.service;

import ma.ensa.project.entity.Facture;
import ma.ensa.project.repo.FactureRepo;

import java.util.List;

public class FactureService implements FactureRepo {
    @Override
    public boolean addFacture(Facture facture) {
        return false;
    }

    @Override
    public Facture getFacture(int id) {
        return null;
    }

    @Override
    public boolean deleteFacture(int id) {
        return false;
    }

    @Override
    public boolean updateFacture(Facture facture) {
        return false;
    }

    @Override
    public List<Facture> getFactures() {
        return List.of();
    }
}

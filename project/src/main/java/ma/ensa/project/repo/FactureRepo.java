package ma.ensa.project.repo;

import ma.ensa.project.entity.Facture;

import java.util.List;

public interface FactureRepo {
    boolean addFacture(Facture facture);
    Facture getFacture(int id);
    boolean deleteFacture(int id);
    boolean updateFacture(Facture facture);
    List<Facture> getFactures();

}

package ma.ensa.project.repo;

import ma.ensa.project.entity.Facture;

import java.sql.SQLException;
import java.util.List;

public interface FactureRepo {

    void addFacture(Facture facture) throws SQLException;
    Facture getFacture(int id) throws SQLException;
    void deleteFacture(int id) throws SQLException;
    void updateFacture(Facture facture) throws SQLException;
    List<Facture> getFactures() throws SQLException;


}

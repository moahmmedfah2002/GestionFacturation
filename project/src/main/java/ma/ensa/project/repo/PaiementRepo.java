package ma.ensa.project.repo;

import ma.ensa.project.entity.Paiement;

import java.sql.SQLException;
import java.util.List;

public interface PaiementRepo {

    boolean addPaiement(Paiement paiement) throws SQLException;
    boolean updatePaiement(Paiement paiement) throws SQLException;
    Paiement getPaiement(int id) throws SQLException;
    List<Paiement> getAllPaiement() throws SQLException;


}

package ma.ensa.project.service;

import ma.ensa.project.Connexion;
import ma.ensa.project.entity.Paiement;
import ma.ensa.project.repo.PaiementRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaimentService implements PaiementRepo {
    private Connexion connexion;
    private Connection con;

    public PaimentService() throws SQLException, ClassNotFoundException {
        connexion=new Connexion();
        con=connexion.getCon();
    }
    @Override
    public boolean addPaiement(Paiement paiement) throws SQLException {

        PreparedStatement ps=con.prepareCall("INSERT INTO Paiement(factureId,montant,datepaiement,modepaiement,statutpaiement) values(?,?,?,?,?)");
        ps.setInt(1,paiement.getFactureId());
        ps.setDouble(2,paiement.getMontant());
        ps.setDate(3,paiement.getDatePaiement());
        ps.setString(4,paiement.getModepaiement());
        ps.setString(5,paiement.getStatutPaiement());
        return ps.executeUpdate()!=0;

    }


    @Override
    public boolean updatePaiement(Paiement paiement) throws SQLException {
        PreparedStatement ps=con.prepareCall("UPDATE Paiement set factureId=?,montant=?,datepaiement=?,modepaiement=?,statutpaiement=? where id=?");
        ps.setInt(1,paiement.getFactureId());
        ps.setDouble(2,paiement.getMontant());
        ps.setDate(3,paiement.getDatePaiement());
        ps.setString(4,paiement.getModepaiement());
        ps.setString(5,paiement.getStatutPaiement());
        ps.setInt(6,paiement.getId());
        return ps.executeUpdate()!=0;

    }

    @Override
    public Paiement getPaiement(int id) throws SQLException {
        PreparedStatement ps=con.prepareCall("SELECT * FROM Paiement where id=?");
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        Paiement paiement=new Paiement();

        if(rs.next()){
            paiement.setId(rs.getInt("id"));
            paiement.setFactureId(rs.getInt("factureId"));
            paiement.setMontant(rs.getDouble("montant"));
            paiement.setModepaiement(rs.getString("modepaiement"));
            paiement.setStatutPaiement(rs.getString("statutpaiement"));

        }
        return paiement;
    }

    @Override
    public List<Paiement> getAllPaiement() throws SQLException {
        PreparedStatement ps=con.prepareCall("SELECT * FROM Paiement ");

        ResultSet rs=ps.executeQuery();
        List<Paiement> paiements=new ArrayList<Paiement>();

        while (rs.next()){
            Paiement paiement=new Paiement();
            paiement.setId(rs.getInt("id"));
            paiement.setFactureId(rs.getInt("factureId"));
            paiement.setMontant(rs.getDouble("montant"));
            paiement.setModepaiement(rs.getString("modepaiement"));
            paiement.setStatutPaiement(rs.getString("statutpaiement"));
            paiements.add(paiement);
        }
        return paiements;
    }
}

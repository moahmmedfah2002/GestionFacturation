package ma.ensa.project.service;

import ma.ensa.project.Connexion;
import ma.ensa.project.entity.Commande;
import ma.ensa.project.entity.Facture;
import ma.ensa.project.entity.Paiement;
import ma.ensa.project.repo.FactureRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactureService implements FactureRepo {
    private Connexion connection;
    private java.sql.Connection con;
    private int idCommande;
    private int idPaiement;
    private CommandeService commandeService;
    private PaimentService paimentService;

    public FactureService(int idCommande, int idPaiement) {
        this.idCommande = idCommande;
        this.idPaiement = idPaiement;
    }

    public FactureService() throws SQLException, ClassNotFoundException {
        connection=new Connexion();
        con=connection.getCon();
    }
    @Override
    public void addFacture(Facture facture) throws SQLException {
        String sql="Insert into Facture(date,tax,status,prixaftertax,idCommande,idPaiement) values(?,?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setDate(1,facture.getDate());
        pstmt.setInt(2,facture.getTax());
        pstmt.setBoolean(3,facture.getStatus());
        pstmt.setFloat(4,facture.getPrixafertax());
        pstmt.setInt(5,idCommande);
        pstmt.setInt(6,idPaiement);
        pstmt.executeUpdate();
    }

    @Override
    public Facture getFacture(int id) throws SQLException {
        String sql="select * from Facture where idFacture=?";
        PreparedStatement str=con.prepareStatement(sql);
        str.setInt(1,id);
        ResultSet rs=str.executeQuery();
        Facture facture=new Facture();

        if(rs.next()){
           int idfac= rs.getInt("idFacture");
           facture.setId(idfac);
           Date date= rs.getDate("date");
           facture.setDate(date);
           int tax=   rs.getInt("tax");
           facture.setTax(tax);
           boolean status=   rs.getBoolean("status");
           facture.setStatus(status);
           float prixaftertax=  rs.getFloat("prixaftertax");
           facture.setPrixaftertax(prixaftertax);
           int idcommande=    rs.getInt("idCommande");
         Commande commande=  commandeService.getCommande(idcommande);
           facture.setCommande(commande);
           int idpaiement=     rs.getInt("idPaiement");
           Paiement paiement= paimentService.getPaiement(idpaiement);

           facture.setPaiement(paiement);

        }
        return facture;


    }

    @Override
    public void deleteFacture(int id) throws SQLException {

        String sql="delete from Facture where idFacture=?";
        PreparedStatement str=con.prepareStatement(sql);
        str.setInt(1,id);
        str.executeUpdate();

    }

    @Override
    public void updateFacture(Facture facture) throws SQLException {
String sql="Update Facture set date=?,tax=?,status=?,prixaftertax=? where idFacture=?";
PreparedStatement str=con.prepareStatement(sql);
str.setDate(1,facture.getDate());
str.setInt(2,facture.getTax());
str.setBoolean(3,facture.getStatus());
str.setFloat(4,facture.getPrixaftertax());
str.setInt(5,facture.getId());
str.executeUpdate();

    }

    @Override
    public List<Facture> getFactures() throws SQLException {
        List<Facture> factures=new ArrayList<Facture>();
        String sql="select * from Facture";
        PreparedStatement str=con.prepareStatement(sql);
        ResultSet rs=str.executeQuery();
        while(rs.next()){
            int idfac= rs.getInt("idFacture");
            int tax=   rs.getInt("tax");
            boolean status=   rs.getBoolean("status");
            float prixaftertax=rs.getFloat("prixaftertax");
            int idcommande=    rs.getInt("idCommande");
            int idpaiement=    rs.getInt("idPaiement");
            Commande commande=  commandeService.getCommande(idcommande);
            Paiement paiement= paimentService.getPaiement(idpaiement);
            Facture facture=new Facture(idfac,tax,status,prixaftertax,commande,paiement);
            factures.add(facture);
        }

                return factures;

    }
}

package ma.ensa.project.service;

import ma.ensa.project.Connexion;

import ma.ensa.project.entity.*;

import ma.ensa.project.repo.CommandeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandeService implements CommandeRepo {

    private Connexion connexion;
    private Connection con;
    public CommandeService() throws SQLException, ClassNotFoundException {
        connexion=new Connexion();
        con=connexion.getCon();

    }
    @Override
    public boolean addCommande(Commande commande,List<DetaileCommande> detaileCommandes) throws SQLException, ClassNotFoundException {

        PreparedStatement ps=con.prepareCall("INSERT INTO commande (commandedate, totalamount, idClient, statuePaiement, idPaiement, idUser) VALUES (?, ?, ?, ?, ?, ?)\n");
        ps.setDate(1,commande.getCommandeDate());
        ps.setFloat(2,commande.getTotalAmount());
        ps.setInt(3, commande.getClient());
        ps.setInt(4, commande.getStatusPaiement());
        ps.setInt(5, commande.getIdPaiement());
        ps.setInt(6, commande.getIdUser());
        DetaileCommandeService detaileCommandeService=new DetaileCommandeService();
        int count = ps.executeUpdate();
        boolean created= count > 0;
        if(created){
            for(DetaileCommande detaile:detaileCommandes){
                int id=ps.getGeneratedKeys().getInt("id");
                detaile.setIdcommande(id);
                detaileCommandeService.addDetaileCommande(detaile);

            }
        }


        return created;




    }

    @Override
    public Commande getCommande(int id) throws SQLException {
        PreparedStatement ps=con.prepareCall("SELECT * from commande where idCommande=?");
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        Commande commande=new Commande();
        while(rs.next()){
            commande.setId(rs.getInt("id"));
            commande.setCommandeDate(rs.getDate("commandedate"));
            commande.setTotalAmount(rs.getFloat("Totalamount"));
            commande.setClient(rs.getInt("idClient"));

        }
        return commande;
    }


    @Override
    public List<Commande> getCommandes() throws SQLException {
        PreparedStatement ps=con.prepareCall("SELECT * from commande");
        ResultSet rs=ps.executeQuery();
        List<Commande> commandes=new ArrayList<Commande>();
        while(rs.next()){
            Commande commande=new Commande();
            commande.setId(rs.getInt("id"));
            commande.setCommandeDate(rs.getDate("commandedate"));
            commande.setTotalAmount(rs.getFloat("Totalamount"));
            commande.setClient(rs.getInt("idClient"));
            commandes.add(commande);
        }
        return commandes;
    }

    @Override
    public boolean updateCommande(Commande commande) throws SQLException {
        PreparedStatement ps=con.prepareCall("UPDATE commande set commandedate=?,Totalamount=?,idClient=? , statuePaiement=? where id=?");

        ps.setDate(1,commande.getCommandeDate());
        ps.setFloat(2,commande.getTotalAmount());
        ps.setInt(3,commande.getClient());
        ps.setInt(4,commande.getStatusPaiement());
        ps.setInt(5,commande.getId());

        int count = ps.executeUpdate();
        if(count>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteCommande(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement ps=con.prepareCall("Delete from Commande where id=?");
        PreparedStatement ps1=con.prepareCall("SELECT id from detailCommande where idCommande=?");
        ps1.setInt(1,id);
        ResultSet rs1=ps1.executeQuery();
        DetaileCommandeService detaileCommandeService=new DetaileCommandeService();

        while(rs1.next()){
            detaileCommandeService.deleteDetaileCommande(rs1.getInt("id"));
        }

        ps.setInt(1,id);
        int count = ps.executeUpdate();
        if(count>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<DetaileCommande> getDetaileCommandesByCommande(int id) throws SQLException {
        PreparedStatement ps=con.prepareCall("SELECT * from detaileCommande where idCommande=?");
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        List<DetaileCommande> detaileCommandes = new ArrayList<>();

        while (rs.next()){

            DetaileCommande detaileCommande=new DetaileCommande();
            detaileCommande.setId(rs.getInt("id"));
            detaileCommande.setQuantite(rs.getInt("quantite"));
            PreparedStatement psP=con.prepareCall("SELECT * from produit where id=?");
            psP.setInt(1,detaileCommande.getIdProduit());
            ResultSet rsP=psP.executeQuery();
            while (rsP.next()){
                detaileCommande.setIdProduit(rsP.getInt("id"));
            }
            detaileCommandes.add(detaileCommande);
        }
        return detaileCommandes;
    }
}
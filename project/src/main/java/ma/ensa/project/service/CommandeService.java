package ma.ensa.project.service;

import ma.ensa.project.Connexion;
import ma.ensa.project.entity.Commande;
import ma.ensa.project.repo.CommandeRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeService implements CommandeRepo {

    Connexion connexion;
    Connection con;
    public CommandeService() throws SQLException, ClassNotFoundException {
        connexion=new Connexion();
        con=connexion.getCon();

    }
    @Override
    public boolean addCommande(Commande commande) throws SQLException {

        PreparedStatement ps=con.prepareCall("INSERT INTO Commande('date','idClient') VALUES (?,?)");
        ps.setDate(1,commande.getDate());
        ps.setInt(2,commande.getClient());
        int count = ps.executeUpdate();
        if(count>0){
            return true;
        }else {
            return false;
        }



    }

    @Override
    public Commande getCommande(int id) throws SQLException {
        PreparedStatement ps=con.prepareCall("SELECT * from Commande where idCommande=?");
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        Commande commande=new Commande();
        while(rs.next()){
            commande.setId(rs.getInt("id");
            commande.setCommandedate(rs.getDate("commandedate"));
            commande.setTotalamount(rs.getFloat("Totalamount"));
            commande.setClient(rs.getInt("idClient"));

        }
        return commande;
    }

    @Override
    public List<Commande> getCommandes() throws SQLException {
        PreparedStatement ps=con.prepareCall("SELECT * from Commande");
        ResultSet rs=ps.executeQuery();
        List<Commande> commandes=new ArrayList<Commande>();
        while(rs.next()){
            Commande commande=new Commande();
            commande.setId(rs.getInt("id"));
            commande.setCommandedate(rs.getDate("commandedate"));
            commande.setTotalamount(rs.getFloat("Totalamount"));
            commande.setClient(rs.getInt("idClient"));
            commandes.add(commande);
        }
        return commandes;
    }

    @Override
    public boolean updateCommande(Commande commande) throws SQLException {
        PreparedStatement ps=con.prepareCall("UPDATE Commande set commandedate=?,Totalamount=?,idClient=? where id=?");

        ps.setDate(1,commande.getDate());
        ps.setFloat(2,commande.getTotalamount());
        ps.setInt(3,commande.getClient());
        ps.setInt(4,commande.getId());
        int count = ps.executeUpdate();
        if(count>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteCommande(int id) throws SQLException {
        PreparedStatement ps=con.prepareCall("Delete from Commande where id=?");


        ps.setInt(1,commande.getId());
        int count = ps.executeUpdate();
        if(count>0){
            return true;
        }else {
            return false;
        }

    }
}

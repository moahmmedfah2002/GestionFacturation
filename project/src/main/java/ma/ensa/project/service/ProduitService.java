package ma.ensa.project.service;

import ma.ensa.project.Connexion;

import ma.ensa.project.entity.Produit;
import ma.ensa.project.repo.ProduitRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ProduitService implements ProduitRepo {
  private Connexion connection;
  private Connection con;

    public ProduitService() throws SQLException, ClassNotFoundException {
      connection=new Connexion();
      con=connection.getCon();
    }

    @Override
    public void addProduit(Produit p) throws SQLException {

        String sql="Insert into Produit(nom,prix,quantitedisponible)values(?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,p.getNom());
        pstmt.setDouble(2,p.getPrix());
        pstmt.setInt(3,p.getQuantitedisponible());
        pstmt.executeUpdate();


    }

    @Override
    public void updateProduit(Produit p) throws SQLException {
        String sql="Update Produit set name=?,prix=?,quantitedisponible=? where id=?";
        PreparedStatement str = con.prepareStatement(sql);
        str.setString(1,p.getName());
        str.setDouble(2,p.getPrix());
        str.setInt(3,p.getQuantitedisponible());
        str.setInt(4,p.getId());
        str.executeUpdate();


    }

    @Override
    public void deleteProduit(int id) throws SQLException {
        String sql="Delete from Produit where id=?";

        PreparedStatement str=con.prepareStatement(sql);
        str.setInt(1,id);
        

    }

    @Override
    public Produit getProduit(int id) throws SQLException {

        String sql="Select * from Produit where id=?";
        PreparedStatement str=con.prepareStatement(sql);
        str.setInt(1,id);
        ResultSet rs=str.executeQuery();
        Produit p=new Produit();
        if (rs.next()) {
          int idpro=  rs.getInt("id");
          p.setId(idpro);
        String name=    rs.getString("nom");
        p.setName(name);
       double prix=     rs.getDouble("prix");
       p.setPrix(prix);
        int quantity=    rs.getInt("quantitedisponible");
        p.setQuantitedisponible(quantity);


        }
        return  p;

    }

    @Override
    public List<Produit> getAllProduits() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        String sql="Select * from Produit";
        PreparedStatement str= con.prepareStatement(sql);
        ResultSet rs=str.executeQuery();

        while (rs.next()) {
            int idpro=  rs.getInt("id");
            String name=    rs.getString("nom");
            double prix=     rs.getDouble("prix");
            int quantity=    rs.getInt("quantitedisponible");
            Produit p=new Produit(idpro,name,prix,quantity);
            produits.add(p);
        }
        return produits;
    }
}


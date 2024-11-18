package ma.ensa.project.service;


import ma.ensa.project.Connection;
import ma.ensa.project.Connexion;
import ma.ensa.project.entity.Client;
import ma.ensa.project.repo.ClientRepo;

import java.sql.*;
import java.util.ArrayList;

public class ClientService implements ClientRepo {
    private Connexion connection;
    private java.sql.Connection con;

    public ClientService() throws SQLException, ClassNotFoundException {
        connection=new Connexion();
        con=connection.getCon();
    }





    @Override
    public Client getClient(int id) throws SQLException {
        String sql="select * from Client where id=?";
        PreparedStatement str=con.prepareStatement(sql);
        str.setInt(1, id);
        ResultSet rs=str.executeQuery();
        Client c=new Client();
        if(rs.next()){
            int idclient = rs.getInt("id");
            c.setId(idclient);
            String name=rs.getString("nom");
            c.setName(name);
            String address=rs.getString("address");
            c.setAddress(address);
            String email=rs.getString("email");
            c.setEmail(email);
            String telephone=rs.getString("telephone");
            c.setTelephone(telephone);
        }

        rs.close();
        str.close();
        con.close();

        return c;



    }

    @Override
    public ArrayList<Client> getClients() throws SQLException {
        ArrayList<Client> clients=new ArrayList<>();
        String sql="select * from Client";
        Statement str=con.createStatement();
        ResultSet rs=str.executeQuery(sql);
        while(rs.next()){
            int idclient=rs.getInt("id");
            String name=rs.getString("nom");
            String address=rs.getString("address");
            String email=rs.getString("email");
            String telephone=rs.getString("telephone");
            Client c=new Client(idclient,name,address,email,telephone);
            clients.add(c);

        }
        return clients;


    }

    @Override
    public void addClient(Client client) throws SQLException {


        String sql="insert into Client(name,address,email,telephone) values(?,?,?,?)";
        PreparedStatement str=con.prepareStatement(sql);
        str.setString(1,client.getName());
        str.setString(2,client.getAddress());
        str.setString(3,client.getEmail());
        str.setString(4,client.getTelephone());
        str.executeUpdate();}






    @Override
    public void updateClient(Client client) throws SQLException {
     String sql="Update Client set name=?,address=?,email=?,telephone=? where id="+client.getId();
        PreparedStatement str= con.prepareStatement(sql);
        str.setString(1,client.getName());
        str.setString(2,client.getAddress());
        str.setString(3,client.getEmail());
        str.setString(4,client.getTelephone());
        str.executeUpdate();


    }

    @Override
    public void deleteClient(int id) throws SQLException {
        ArrayList<Client> clients=getClients();
        boolean exist=false;
        for(Client c:clients){
            if(c.getId() == id){
                exist=true;
            }
        }
        if(exist){
            String sql="delete from Client where id="+id;
            Statement str=con.createStatement();

            str.execute(sql);}
        else {
            throw new SQLException("Client does not exist");
        }

    }

    @Override
    public Client getClientByEmailAnd(String email) throws SQLException {
        String sql="select * from Client where email=?";
        PreparedStatement str=con.prepareStatement(sql);
        str.setString(1,email);
        ResultSet rs=str.executeQuery(sql);
        Client c=new Client();
        if(rs.next()){
            int idclient=rs.getInt("id");
            c.setId(idclient);
            String name=rs.getString("nom");
            c.setName(name);
            String address=rs.getString("address");
            c.setAddress(address);
            String emailclient=rs.getString("email");
            c.setEmail(emailclient);
            String telephone=rs.getString("telephone");
            c.setTelephone(telephone);

        }
        return c;

    }
}
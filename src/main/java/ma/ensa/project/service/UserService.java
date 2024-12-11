package ma.ensa.project.service;

import ma.ensa.project.Connexion;
import ma.ensa.project.entity.Paiement;
import ma.ensa.project.entity.Permission;
import ma.ensa.project.entity.User;
import ma.ensa.project.repo.UserRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserRepo {
    private Connexion connection;
    private Connection con;

    public UserService() throws SQLException, ClassNotFoundException {
        connection=new Connexion();
        con=connection.getCon();
    }
    @Override
    public boolean addUser(User user, List<Permission> permissions) throws SQLException {
        PreparedStatement ps =con.prepareCall("INSERT INTO user(username,password,role) VALUES(?,?,?)") ;
        ps.setString(1,user.getNomUtilisateur());
        ps.setString(2,user.getMotDePasse());
        ps.setString(3,user.getRole());
        boolean result=ps.executeUpdate()>0;
        if(result){
        for(Permission p:permissions){
            PreparedStatement ps1 =con.prepareCall("INSERT INTO permission(nom,idUser) VALUES(?,?)") ;

            ps.setString(1,p.getNom());
            ps.setInt(2,ps.getGeneratedKeys().getInt("id"));
            ps1.executeUpdate();
        }

        }
        return result;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        PreparedStatement ps1 =con.prepareCall("SELECT * from permission WHERE idUser=?") ;
        ps1.setInt(1,id);
        ResultSet rs = ps1.executeQuery();
        while(rs.next()){

        }
        PreparedStatement ps =con.prepareCall("delete from user where id=?") ;
        ps.setInt(1,id);

        return ps.executeUpdate()!=0;
    }

    @Override
    public boolean updateUser(User user,List<Permission> permissions) throws SQLException {
        PreparedStatement ps =con.prepareCall("update  user VALUES  set username=?,password=?,role=? where id=?  ") ;
        ps.setInt(4,user.getId());
        ps.setString(1,user.getNomUtilisateur());
        ps.setString(2,user.getMotDePasse());
        ps.setString(3,user.getRole());
        boolean result=ps.executeUpdate()>0;
        if(result){
            for(Permission p:permissions){
                PreparedStatement ps1 =con.prepareCall("SELECT * from permission WHERE idUser=?") ;
                ps1.setInt(1,user.getId());
                ResultSet rs = ps1.executeQuery();

                List<Permission> permissions1=new ArrayList<>();
                while(rs.next()){
                    Permission permission=new Permission();
                    permission.setId(rs.getInt("id"));
                    permission.setNom(rs.getString("nom"));
                    permission.setIdUser(rs.getInt("idUser"));
                    permissions1.add(permission);
                }
                for(Permission p2:permissions){
                    if(!permissions1.contains(p2)){

                        PreparedStatement ps3 =con.prepareCall("INSERT INTO permission(nom,idUser) VALUES(?,?)") ;

                        ps3.setString(1,p.getNom());
                        ps3.setInt(2,user.getId());
                        ps1.executeUpdate();
                    }
                }
                for(Permission p3:permissions1){
                    if(!permissions.contains(p3)) {
                        PreparedStatement ps4 = con.prepareCall("DELETE FROM permission WHERE id=?");
                        ps4.setInt(1, p3.getId());
                        ps4.executeUpdate();
                    }
                }
                ps.setInt(1,user.getId());
                ps1.executeQuery();
            }
        }
        return result;
    }

    @Override
    public User getUser(int id) throws SQLException {
        PreparedStatement ps=this.con.prepareCall("SELECT * from user where id=?") ;
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        User user=new User();
        if(rs.next()){
            user.setId(rs.getInt("id"));
            user.setNomUtilisateur(rs.getString("nomUtilisateur"));
            user.setMotDePasse(rs.getString("motDePasse"));
            user.setRole(rs.getString("role"));

        }
        return user;


    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        PreparedStatement ps=this.con.prepareCall("SELECT * from user");
        ResultSet rs= ps.executeQuery();
        List<User> users=new ArrayList<User>();
        while (rs.next()){
            User user=new User();
            user.setId(rs.getInt("id"));
            user.setNomUtilisateur(rs.getString("username"));
            user.setMotDePasse(rs.getString("password"));
            user.setRole(rs.getString("role"));
            users.add(user);


        }

        return users;
    }
}

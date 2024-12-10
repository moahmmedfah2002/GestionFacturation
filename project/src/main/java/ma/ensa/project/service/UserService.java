package ma.ensa.project.service;

import ma.ensa.project.Connexion;
import ma.ensa.project.entity.Paiement;
import ma.ensa.project.entity.Permission;
import ma.ensa.project.entity.User;
import ma.ensa.project.repo.UserRepo;
import org.mindrot.jbcrypt.BCrypt;

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
    public String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
    public boolean login(User user) throws SQLException {
        PreparedStatement ps=con.prepareCall("SELECT password from user where username=?");
        ps.setString(1,user.getNomUtilisateur());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            return BCrypt.checkpw(user.getMotDePasse(), rs.getString("password"));
        }
        else return false;

    }
    @Override
    public boolean addUser(User user, List<Permission> permissions) throws SQLException {
        String p1=user.getMotDePasse();
        BCrypt bCrypt=new BCrypt();
        p1=hashPassword(p1);
        System.out.println(p1);
        PreparedStatement ps =con.prepareCall("INSERT INTO user(username,password,role) VALUES(?,?,?)") ;
        ps.setString(1,user.getNomUtilisateur());
        ps.setString(2,p1);
        ps.setString(3,user.getRole());
        boolean result=ps.executeUpdate()>0;
        ResultSet id=ps.getGeneratedKeys();
        if(id.next()) {
            int i = id.getInt(1);

        if(result){
        for(Permission p:permissions){

            PreparedStatement ps1 =con.prepareCall("INSERT INTO permissions(permission,idUser) VALUES(?,?)") ;

            ps1.setString(1,p.getNom());
            ps1.setInt(2,i);
            ps1.executeUpdate();
        }

        }}
        return result;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {

        PreparedStatement ps =con.prepareCall("delete from permissions where idUser=?") ;
        ps.setInt(1,id);
        ps.executeUpdate();


        PreparedStatement ps1 =con.prepareCall("delete from user where id=?") ;
        ps1.setInt(1,id);
        return ps1.executeUpdate()>0;



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
                PreparedStatement ps1 =con.prepareCall("SELECT * from permissions WHERE idUser=?") ;
                ps1.setInt(1,user.getId());
                ResultSet rs = ps1.executeQuery();

                List<Permission> permissions1=new ArrayList<>();
                while(rs.next()){
                    Permission permission=new Permission();
                    permission.setId(rs.getInt("id"));
                    permission.setNom(rs.getString("permission"));
                    permission.setIdUser(rs.getInt("idUser"));
                    permissions1.add(permission);
                }
                for(Permission p2:permissions){
                    if(!permissions1.contains(p2)){

                        PreparedStatement ps3 =con.prepareCall("INSERT INTO permissions(permission,idUser) VALUES(?,?)") ;

                        ps3.setString(1,p.getNom());
                        ps3.setInt(2,user.getId());
                        ps1.executeUpdate();
                    }
                }
                for(Permission p3:permissions1){
                    if(!permissions.contains(p3)) {
                        PreparedStatement ps4 = con.prepareCall("DELETE FROM permissions WHERE id=?");
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

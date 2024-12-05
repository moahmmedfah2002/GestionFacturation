package ma.ensa.project.service;

import ma.ensa.project.Connexion;
import ma.ensa.project.entity.User;
import ma.ensa.project.repo.UserRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserService implements UserRepo {
    private Connexion connection;
    private Connection con;

    public UserService() throws SQLException, ClassNotFoundException {
        connection=new Connexion();
        con=connection.getCon();
    }
    @Override
    public boolean addUser(User user) throws SQLException {
        PreparedStatement ps =con.prepareCall("INSERT INTO user(username,password,role) VALUES(?,?,?)") ;
        ps.setString(1,user.getNomUtilisateur());
        ps.setString(2,user.getMotDePasse());
        ps.setString(3,user.getRole());
        return ps.executeUpdate()!=0;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}

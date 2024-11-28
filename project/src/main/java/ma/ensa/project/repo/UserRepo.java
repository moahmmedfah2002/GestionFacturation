package ma.ensa.project.repo;

import ma.ensa.project.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepo {
    boolean addUser(User user) throws SQLException;
    boolean deleteUser(int id);
    boolean updateUser(User user);
    User getUser(int id);
    List<User> getAllUsers();
}

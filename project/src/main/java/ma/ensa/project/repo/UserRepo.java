package ma.ensa.project.repo;

import ma.ensa.project.entity.User;

import java.util.List;

public interface UserRepo {
    boolean addUser(User user);
    boolean deleteUser(int id);
    boolean updateUser(User user);
    User getUser(int id);
    List<User> getAllUsers();
}

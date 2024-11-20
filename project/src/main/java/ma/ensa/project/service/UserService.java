package ma.ensa.project.service;

import ma.ensa.project.entity.User;
import ma.ensa.project.repo.UserRepo;

import java.util.List;

public class UserService implements UserRepo {
    @Override
    public boolean addUser(User user) {
        return false;
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

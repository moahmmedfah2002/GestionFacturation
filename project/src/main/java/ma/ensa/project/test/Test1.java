package ma.ensa.project.test;


import ma.ensa.project.entity.Role;
import ma.ensa.project.entity.User;
import ma.ensa.project.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class Test1 {
    @Test
    public void t()  {
        try{
        User user=new User();
        user.setRole("admin");
        user.setNomUtilisateur("mohammed");
        user.setMotDePasse("123");
        UserService userService=new UserService();
        Assert.assertTrue(userService.addUser(user));
        }catch (SQLException | ClassNotFoundException e){

        }

    }
}

package ma.ensa.project.test;

import ma.ensa.project.service.MailService;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Test1 {

    @Test
    public void mail(){
        //kawtar.zouiher.02@gmail.com
        //bilallaariny01@gmail.com
        MailService mailService = new MailService();
        boolean m=mailService.send("fahlaouimohammed@gmail.com","test","chouf lta7t","C:\\Users\\pc\\Documents\\java2\\GestionFacturation\\project\\src\\main\\resources\\f.pdf");
        Assert.assertTrue(m);


    }
}

package ma.ensa.project.test;

import ma.ensa.project.entity.*;
import ma.ensa.project.service.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TestCommandeServices {

    @Test
    public void testAddcommande() {
        try {
            String dateString = "21/05/2022";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = dateFormat.parse(dateString);
            Date sqlDate = new Date(utilDate.getTime());


            ClientService clientService = new ClientService();
            clientService.addClient(clientService.getClient(5),13);
            Produit savon = new Produit("savon", 75, 100);
            ProduitService produitService = new ProduitService();
            produitService.addProduit(savon);
            Produit pain = new Produit("pain", 2, 50);
            produitService.addProduit(pain);
            Facture facture = new Facture(1,500, true, sqlDate, 50);
            FactureService factureService = new FactureService();
            factureService.addFacture(facture);
            Paiement paiement = new Paiement();
            PaimentService paimentService = new PaimentService();
            UserService userService = new UserService();
            paimentService.addPaiement(paiement,userService.getUser(13));
            Commande commande = new Commande(sqlDate, 200, 5, paiement.getId());
            DetaileCommande detail = new DetaileCommande(commande.getId(), savon.getId(), 75);
            DetaileCommande detail2 = new DetaileCommande(commande.getId(), savon.getId(), 75);
            DetaileCommandeService detaileCommandeService = new DetaileCommandeService();
            detaileCommandeService.addDetaileCommande(detail);
            detaileCommandeService.addDetaileCommande(detail2);


            List<DetaileCommande> liste = new ArrayList<>();
            List<DetaileCommande> listee = new ArrayList<>();
            liste.add(detail);
            liste.add(detail2);

            CommandeService commandeService = new CommandeService();

            Assert.assertTrue(commandeService.addCommande(commande,liste));

            System.out.println("Test reussi");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}

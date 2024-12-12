package ma.ensa.project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductController {

    @FXML
    private TextField nomProduitField;

    @FXML
    private TextField quantiteField;

    @FXML
    private TextField prixField;

    private ProduitController produitController; // Référence au contrôleur principal

    public void setProduitController(ProduitController produitController) {
        this.produitController = produitController;
    }

    @FXML
    public void handleAddProduct() {
        // Récupérer les valeurs saisies
        String nom = nomProduitField.getText();
        String quantite = quantiteField.getText();
        String prix = prixField.getText();

        // Ajouter les données dans le tableau principal via ProduitController
        produitController.addProductToTable(nom, quantite, prix);

        // Fermer la fenêtre
        Stage stage = (Stage) nomProduitField.getScene().getWindow();
        stage.close();
    }
}

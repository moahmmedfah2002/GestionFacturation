package ma.ensa.project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.ensa.project.entity.Produit;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



public class ProduitController {

    @FXML
    private TableView<Produit> produitTable;

    @FXML
    private TableColumn<Produit, Integer> idColumn;

    @FXML
    private TableColumn<Produit, String> nomColumn;

    @FXML
    private TableColumn<Produit, Integer> quantiteColumn;

    @FXML
    private TableColumn<Produit, Double> prixColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));

        // Exemple de données (test)
        produitTable.getItems().addAll(

        );
    }

    @FXML
    private void handleAddProduct() {
        // Logique pour ajouter un produit
        System.out.println("Ajouter un produit !");
    }
    @FXML
    private void handleToggleFullScreen() {
        Stage stage = (Stage) produitTable.getScene().getWindow();
        stage.setFullScreen(!stage.isFullScreen());
    }

    public void handleAddItem(ActionEvent event) {
        // Your logic for handling the "Add Item" button click goes here
        System.out.println("Add Item button clicked");
    }



    @FXML
    private void handleDeleteProduct() {
        // Logique pour supprimer le produit sélectionné
        Produit selectedProduct = produitTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            produitTable.getItems().remove(selectedProduct);
            System.out.println("Produit supprimé : " + selectedProduct.getNom());
        }
    }

    @FXML
    public void handleAddDetail() {
        try {
            // Charger le fichier FXML pour la nouvelle page
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ma/ensa/project/AddProduit.fxml"));
            Parent root = loader.load();

            // Obtenir le contrôleur de la nouvelle page
            AddProductController controller = loader.getController();
            controller.setProduitController(this); // Passer une référence au contrôleur principal

            // Créer une nouvelle scène
            Stage stage = new Stage();
            stage.setTitle("Ajouter un Produit");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProductToTable(String nom, String quantite, String prix) {
        try {
            int qte = Integer.parseInt(quantite);
            double price = Double.parseDouble(prix);

            Produit newProduit = new Produit(0, nom, qte, price); // Remplacez 'Product' par 'Produit'
            produitTable.getItems().add(newProduit);
        } catch (NumberFormatException e) {
            System.err.println("Quantité ou prix invalide.");
        }
    }
    @FXML
    private void handleClose(ActionEvent event) {
        // Ferme la fenêtre actuelle
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}

package ma.ensa.project.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ma.ensa.project.entity.DetaileCommande;

public class DetailCommandeController {

    @FXML
    private TableView<DetaileCommande> detailTable;

    @FXML
    private TableColumn<DetaileCommande, String> nomProduitColumn;

    @FXML
    private TableColumn<DetaileCommande, Double> prixColumn;

    @FXML
    private TableColumn<DetaileCommande, Integer> quantiteColumn;

    @FXML
    private TableColumn<DetaileCommande, Double> montantColumn;

    @FXML
    private TableColumn<DetaileCommande, Button> actionColumn;

    @FXML
    private void handleAddDetail() {
        System.out.println("Ajout d'un détail !");
        // Logique pour ajouter un détail (par exemple, ouvrir une boîte de dialogue pour saisir les informations)
    }

    @FXML
    private void handleToggleFullScreen() {
        // Récupérer la scène et la fenêtre associée
        Stage stage = (Stage) detailTable.getScene().getWindow();

        // Basculer le mode plein écran
        stage.setFullScreen(!stage.isFullScreen());
    }


    // Initialisation des colonnes (appelée automatiquement après le chargement du FXML)
    @FXML
    public void initialize() {
        nomProduitColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getProduit().get(0).toString()));
        prixColumn.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getProduit().get(0).getPrix()).asObject());
        quantiteColumn.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getQuantite()).asObject());
        montantColumn.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getQuantite() *
                        cellData.getValue().getProduit().get(0).getPrix()).asObject());
        // ActionColumn peut être rempli avec des boutons dynamiques si nécessaire
    }
    @FXML
    private void handleClose(ActionEvent event) {
        // Ferme la fenêtre actuelle
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

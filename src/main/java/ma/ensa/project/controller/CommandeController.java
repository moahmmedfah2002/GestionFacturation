package ma.ensa.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ma.ensa.project.entity.Commande;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

public class CommandeController {

    @FXML
    private TableView<Commande> commandeTable;

    @FXML
    private TableColumn<Commande, Integer> idColumn;

    @FXML
    private TableColumn<Commande, Integer> clientColumn;  // Le type doit être Integer, car 'client' est un int

    @FXML
    private TableColumn<Commande, LocalDate> dateColumn;

    @FXML
    private TableColumn<Commande, Float> montantColumn;  // Le type doit être Float pour correspondre à totalAmount

    @FXML
    private TableColumn<Commande, String> statusColumn;

    @FXML
    public void initialize() {
        // Lier les colonnes aux propriétés de Commande
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<>("client"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("commandeDate"));
        montantColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("statut"));

        // Ajouter des commandes pour tester
        commandeTable.getItems().addAll(

        );
    }

    @FXML
    private void handleAddCommande() {
        System.out.println("Ajouter une commande !");
    }

    @FXML
    private void handleEditCommande() {
        System.out.println("Modifier une commande !");
    }

    @FXML
    private void handleDeleteCommande() {
        System.out.println("Supprimer une commande !");
    }

    @FXML
    private void handleToggleFullScreen() {
        javafx.stage.Stage stage = (javafx.stage.Stage) commandeTable.getScene().getWindow();
        stage.setFullScreen(!stage.isFullScreen());
    }

    public void handleAddDetail(ActionEvent actionEvent) {
    }
    @FXML
    private void handleClose(ActionEvent event) {
        // Ferme la fenêtre actuelle
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

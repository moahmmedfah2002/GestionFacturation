package ma.ensa.project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import ma.ensa.project.entity.Facture;
import ma.ensa.project.service.FactureService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class FactureController {
    private ObservableList<Facture> factureList = FXCollections.observableArrayList();


    @FXML
    private TableView<Facture> factureTable;

    @FXML
    private TableColumn<Facture, String> idColumn;

    @FXML
    private TableColumn<Facture, String> clientColumn;

    @FXML
    private TableColumn<Facture, String> dateColumn;

    @FXML
    private TableColumn<Facture, Double> taxColumn;

    @FXML
    private TableColumn<Facture, Double> montantColumn;

    @FXML
    private TableColumn<Facture, String> statusColumn;

    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientColumn.setCellValueFactory(new PropertyValueFactory<>("client"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        taxColumn.setCellValueFactory(new PropertyValueFactory<>("tax"));
        montantColumn.setCellValueFactory(new PropertyValueFactory<>("montant"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Ajouter les données à la table
        factureTable.setItems(getFactureData());
    }

    // Exemple pour obtenir des données (adapter selon votre projet)
    private ObservableList<Facture> getFactureData() {
        return FXCollections.observableArrayList(

        );
    }


    // Méthode pour passer en plein écran
    @FXML
    public void handleToggleFullScreen(ActionEvent event) {
        // Exemple de basculement entre plein écran et mode fenêtré
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setFullScreen(!stage.isFullScreen());
    }
    @FXML
    private void handleAddDetail(ActionEvent event) {
        System.out.println("Ajout d'un détail !");
        // Logique pour ajouter un détail
    }
    @FXML
    private void handleClose(ActionEvent event) {
        // Ferme la fenêtre actuelle
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}

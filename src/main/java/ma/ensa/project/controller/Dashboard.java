package ma.ensa.project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.ensa.project.entity.Ferme;

public class Dashboard {

    @FXML
    private Label totalAnimauxLabel;

    @FXML
    private Label totalCulturesLabel;

    @FXML
    private Label totalPersonnelLabel;

    @FXML
    private TableView<Ferme> fermesTable;

    @FXML
    private TableColumn<Ferme, Integer> idColumn;

    @FXML
    private TableColumn<Ferme, String> nomColumn;

    @FXML
    private TableColumn<Ferme, String> localisationColumn;

    @FXML
    private TableColumn<Ferme, Double> tailleColumn;

    @FXML
    private TableColumn<Ferme, String> responsableColumn;

    @FXML
    public void initialize() {
        // Configuration des colonnes
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        localisationColumn.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        tailleColumn.setCellValueFactory(new PropertyValueFactory<>("taille"));
        responsableColumn.setCellValueFactory(new PropertyValueFactory<>("responsable"));

        // Chargement des données (à personnaliser avec votre logique métier)

    }

    @FXML
    public void handleAddFarm() {
        System.out.println("Ajouter une ferme");
        // Ajouter une ferme (logique à implémenter)
    }

    @FXML
    public void handleEditFarm() {
        System.out.println("Modifier une ferme");
        // Modifier une ferme sélectionnée (logique à implémenter)
    }

    @FXML
    public void handleDeleteFarm() {
        System.out.println("Supprimer une ferme");
        // Supprimer une ferme sélectionnée (logique à implémenter)
    }
}

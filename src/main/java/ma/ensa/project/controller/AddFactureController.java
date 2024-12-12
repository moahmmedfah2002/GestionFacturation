package ma.ensa.project.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ma.ensa.project.entity.Facture;
import ma.ensa.project.service.FactureService;

import java.sql.Date;

public class AddFactureController {
    private ObservableList<Facture> factureList = FXCollections.observableArrayList();


    @FXML
    private TextField dateField;

    @FXML
    private TextField statusField;

    @FXML
    private TextField taxField;

    @FXML
    private TextField montantField;

    @FXML
    public void handleSaveFacture(ActionEvent event) {
        try {
            // Validation des champs
            if (dateField.getText().isEmpty() || statusField.getText().isEmpty() ||
                    taxField.getText().isEmpty() || montantField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Champs obligatoires manquants");
                alert.setContentText("Veuillez remplir tous les champs avant de sauvegarder.");
                alert.showAndWait();
                return;
            }

            // Validation du format de la date
            if (!isValidDate(dateField.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Format de date invalide");
                alert.setContentText("Veuillez entrer la date au format yyyy-MM-dd.");
                alert.showAndWait();
                return;
            }

            // Création d'une nouvelle facture
            Facture facture = new Facture();
            facture.setDate(Date.valueOf(dateField.getText())); // Assurez-vous que le format est correct
            facture.setStatut(Boolean.parseBoolean(statusField.getText()));
            facture.setTax(Double.parseDouble(taxField.getText()));
            facture.setMontant(Double.parseDouble(montantField.getText()));

            // Sauvegarde dans la base de données
            FactureService factureService = new FactureService();
            factureService.addFacture(facture);


            factureList.add(facture);

            // Message de succès
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText("Nouvelle facture ajoutée avec succès !");
            alert.showAndWait();

            // Fermer la fenêtre
            Stage stage = (Stage) dateField.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Une erreur s'est produite");
            alert.setContentText("Impossible d'ajouter la facture. Vérifiez vos données.");
            alert.showAndWait();
        }
    }


    private boolean isValidDate(String date) {
        try {
            Date.valueOf(date);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @FXML
    public void handleCancel(ActionEvent event) {
        // Fermer la fenêtre sans enregistrer
        Stage stage = (Stage) dateField.getScene().getWindow();
        stage.close();
    }
}

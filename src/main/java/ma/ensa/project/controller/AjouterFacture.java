package ma.ensa.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouterFacture {

    @FXML
    private TextField txtNomClient;

    @FXML
    private TextField txtMontantHT;

    @FXML
    private TextField txtMontantTTC;

    @FXML
    private TextField txtDateEcheance;

    // Action pour enregistrer la facture
    @FXML
    public void saveFacture(ActionEvent event) {
        // Récupération des données saisies
        String nomClient = txtNomClient.getText();
        String montantHT = txtMontantHT.getText();
        String montantTTC = txtMontantTTC.getText();
        String dateEcheance = txtDateEcheance.getText();

        // Logique pour sauvegarder la facture
        System.out.println("Facture enregistrée : Nom=" + nomClient + ", HT=" + montantHT + ", TTC=" + montantTTC + ", Échéance=" + dateEcheance);

        // Fermer la fenêtre après sauvegarde
        closeWindow(event);
    }

    // Action pour annuler l'opération
    @FXML
    public void cancelAction(ActionEvent event) {
        closeWindow(event);
    }

    // Méthode pour fermer la fenêtre
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

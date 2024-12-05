package ma.ensa.project.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

public class facture {

    @FXML
    private TableView<?> articleTable; // Remplacez ? par votre classe d'article, si nécessaire.

    @FXML
    public void handleAddItem(ActionEvent event) {
        // Logique pour gérer l'ajout d'un nouvel article
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajouter un article");
        alert.setHeaderText(null);
        alert.setContentText("La fonction 'Ajouter' a été déclenchée !");
        alert.showAndWait();

        // Vous pouvez ouvrir une nouvelle fenêtre ou formulaire pour saisir les détails d'un nouvel article ici.
    }

    @FXML
    public void handleUpdateItem(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modifier un article");
        alert.setHeaderText(null);
        alert.setContentText("La fonction 'Modifier' a été déclenchée !");
        alert.showAndWait();
    }

    @FXML
    public void handleDeleteItem(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Supprimer un article");
        alert.setHeaderText(null);
        alert.setContentText("La fonction 'Supprimer' a été déclenchée !");
        alert.showAndWait();
    }

    @FXML
    public void handleClose(ActionEvent event) {
        // Fermer la fenêtre actuelle
        javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

package ma.ensa.project.view;

import javafx.scene.control.TableCell;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import ma.ensa.project.entity.Facture;

public class FactureActionCell extends TableCell<Facture, String> {

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            // Créer un bouton pour l'action
            Button actionButton = new Button("Action");
            actionButton.setOnAction(event -> {
                Facture facture = getTableView().getItems().get(getIndex());
                // Implémentation de l'action pour cette facture
                System.out.println("Action pour la facture: " + facture.getId());
            });

            // Créer un conteneur pour afficher le bouton
            HBox hBox = new HBox(actionButton);
            setGraphic(hBox);
        } else {
            setGraphic(null);  // Supprimer tout le contenu si la ligne est vide
        }
    }
}

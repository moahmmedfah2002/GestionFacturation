package ma.ensa.project.controller;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Client {
    public void Close(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

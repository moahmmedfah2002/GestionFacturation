package ma.ensa.project.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ensa.project.ApplicationGestionFacturation;

import java.io.IOException;

public class Login {

    public void start() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationGestionFacturation.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

}
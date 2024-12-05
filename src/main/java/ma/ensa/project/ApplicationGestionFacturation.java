package ma.ensa.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ensa.project.controller.Login;
import ma.ensa.project.controller.home;

import java.io.IOException;

public class ApplicationGestionFacturation extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        home h=new home();
       h.initialize(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}


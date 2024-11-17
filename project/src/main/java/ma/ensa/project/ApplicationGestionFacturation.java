package ma.ensa.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ensa.project.controller.Login;

import java.io.IOException;

public class ApplicationGestionFacturation extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ma/ensa/project/home.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Application Home");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


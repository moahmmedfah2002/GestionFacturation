package ma.ensa.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ma.ensa.project.controller.DashboardUser;
import ma.ensa.project.controller.Login;
import ma.ensa.project.controller.home;
import ma.ensa.project.entity.Role;

import java.io.IOException;

public class ApplicationGestionFacturation extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

       
        Login login = new Login();
        login.initialize(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}


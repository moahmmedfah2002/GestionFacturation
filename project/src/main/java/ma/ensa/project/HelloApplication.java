package ma.ensa.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ensa.project.controller.Login;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Login login = new Login();
        login.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
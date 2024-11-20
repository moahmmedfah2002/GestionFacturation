package ma.ensa.project;

import javafx.application.Application;
import javafx.stage.Stage;
import ma.ensa.project.controller.Login;

import java.io.IOException;

public class ApplicationGestionFacturation extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Login login = new Login();
        login.start();
    }

    public static void main(String[] args) {
        launch();
    }
}
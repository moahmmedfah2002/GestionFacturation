package ma.ensa.project.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ma.ensa.project.ApplicationGestionFacturation;

import java.io.IOException;
import java.sql.SQLException;

public class Login {
    private VBox root;
    @FXML
    public VBox vbox;
    @FXML
    public TextField nom;
    @FXML
    public TextField prenom;
    @FXML
    public TextField email;
    @FXML
    public TextField cin;

    @FXML
    public Button btnFull;
    public Button btnClose;


    public void initialize(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationGestionFacturation.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Gestion de stock");
        scene.setFill(Color.TRANSPARENT);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);

        primaryStage.show();

    }



    public void full(MouseEvent mouseEvent) {
        Stage stage = (Stage) vbox.getScene().getWindow();
        if (stage.isFullScreen() && mouseEvent.getClickCount() == 1) {
            stage.setFullScreen(false);
        }else {
            if (!stage.isFullScreen() && mouseEvent.getClickCount() == 1) {
                stage.setFullScreen(true);

            }}
    }
    public void close(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 1) {
            Stage stage = (Stage) vbox.getScene().getWindow();
            stage.hide();
        }
    }


}
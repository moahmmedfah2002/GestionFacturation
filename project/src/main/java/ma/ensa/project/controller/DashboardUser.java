package ma.ensa.project.controller;

import io.github.palexdev.mfxcore.controls.Text;
import javafx.animation.FadeTransition;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import ma.ensa.project.entity.User;
import ma.ensa.project.service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DashboardUser {
    @FXML
    public VBox vbox= new VBox();

    @FXML
    public TableView<User> userTable=new TableView<User>();
    @FXML
    public TableColumn<User, Integer> idColumn=new TableColumn<User,Integer>("id");
    @FXML
    public TableColumn<User, String> nameColumn=new TableColumn<User,String>("username");
    @FXML
    public TableColumn<User, String> passwordColumn=new TableColumn<>("password");
    @FXML
    public TableColumn<User, String> roleColumn=new TableColumn<>("role");
    @FXML
    public Button btnClose;
    public Button btnFull;

    @FXML
    private TableColumn<User, Void> actionsColumn=new TableColumn<>("delete");

    private final UserService userDao;
    private final ObservableList<User> userList;

    public DashboardUser() throws SQLException, ClassNotFoundException {
        userDao = new UserService();
        userList = FXCollections.observableArrayList();
        userTable.getColumns().add(idColumn);
        userTable.getColumns().add(nameColumn);
        userTable.getColumns().add(passwordColumn);
        userTable.getColumns().add(roleColumn);
        userTable.getColumns().add(actionsColumn);

    }

    public void full(Event mouseEvent) {
        Stage stage = (Stage) btnFull.getScene().getWindow();
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
        }else {
            if (!stage.isFullScreen() ) {
                stage.setFullScreen(true);

            }}
    }
    @FXML
    public void close(ActionEvent mouseEvent) {

            Stage stage = (Stage) btnClose.getScene().getWindow();
            stage.hide();

    }



    public class Update extends Thread{
        @Override
        public void run(){
            while (true){
                try {
                    sleep(3000);
                    System.out.println("check");
                    loadUsers();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }
    @FXML
    public void initialize() throws IOException, SQLException {
        // Configuration des colonnes



        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
        nameColumn.setCellValueFactory(cellData ->  new SimpleObjectProperty<>(cellData.getValue().getNomUtilisateur()));
        passwordColumn.setCellValueFactory(cellData ->  new SimpleObjectProperty<>(cellData.getValue().getMotDePasse()));
        roleColumn.setCellValueFactory(cellData ->  new SimpleObjectProperty<>(cellData.getValue().getRole()));

        Update update=new Update();
        update.start();
        actionsColumn.setCellFactory(column -> new TableCell<>() {
            private final Button deleteButton = new Button("Supprimer");
            private final HBox container = new HBox(5);

            {
                // Choisissez un des styles ci-dessus
                deleteButton.getStyleClass().add("delete-btn"); // ou un autre style

                // Optionnel : Ajout d'une icône
                Text icon = new Text("🗑️");
                deleteButton.setGraphic(icon);

                container.setAlignment(Pos.CENTER);
                container.getChildren().add(deleteButton);

                deleteButton.setOnAction(event -> {
                    User user = getTableView().getItems().get(getIndex());
                    // Animation optionnelle avant la suppression
                    FadeTransition fade = new FadeTransition(Duration.millis(200), container);
                    fade.setFromValue(1.0);
                    fade.setToValue(0.5);
                    fade.setOnFinished(e -> handleDelete(user));
                    fade.play();
                });
            }



        });

        // Chargement des données




        userList.addAll(userDao.getAllUsers());
        List<User> users=userDao.getAllUsers();
        userTable.setItems(userList);



























    }

    private void loadUsers() throws SQLException {
        userList.clear();
        userList.addAll(userDao.getAllUsers());
        List<User> users=userDao.getAllUsers();
        userTable.setItems(userList);



    }

    @FXML
    private void getAddView() throws SQLException {


//        try {
//
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ma/ensa/project/adduser.fxml"));
//            Parent root = loader.load();
//
//            Object addUserController = loader.getController();
////            addUserController.setDashboardController(this);
//
//            Stage stage = new Stage();
//            stage.setTitle("Ajouter un utilisateur");
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            showAlert("Erreur", "Impossible d'ouvrir la fenêtre d'ajout", Alert.AlertType.ERROR);
//        }
    }

   private void handleEdit(User user) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ma/ensa/project/edituser.fxml"));
//            Parent root = loader.load();
//
//            EditUser editUserController = loader.getController();
//            editUserController.setUser(user);
//            editUserController.setDashboardController(this);
//
//            Stage stage = new Stage();
//            stage.setTitle("Modifier l'utilisateur");
//            stage.setScene(new Scene(root));
//            stage.show();
//        } catch (Exception e) {
//            e.printStackTrace();
//            showAlert("Erreur", "Impossible d'ouvrir la fenêtre de modification", Alert.AlertType.ERROR);
//        }
   }

    private void handleDelete(User user) {
        // Utiliser Platform.runLater pour éviter les conflits d'animation
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Supprimer l'utilisateur ?");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cet utilisateur ?");

            // Styling de l'alerte de confirmation
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.setStyle(
                    "-fx-background-color: white;" +
                            "-fx-border-color: #FF4757;" +
                            "-fx-border-width: 2px;" +
                            "-fx-border-radius: 5px;"
            );

            // Styling des boutons
            Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setStyle(
                    "-fx-background-color: #FF4757;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 5px;"
            );

            Button cancelButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);
            cancelButton.setStyle(
                    "-fx-background-color: #E8ECEF;" +
                            "-fx-text-fill: #2D3436;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 5px;"
            );

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        userDao.deleteUser(user.getId());

                        userList.addAll(userDao.getAllUsers());
                        userTable.setItems(userList);
                        showSuccessMessage("Utilisateur supprimé avec succès");
                    } catch (Exception e) {
                        showErrorMessage("Erreur lors de la suppression : " + e.getMessage());
                    }
                }
            });
        });
    }

    private void showSuccessMessage(String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initStyle(StageStyle.UNDECORATED);
            alert.setTitle("Succès");
            alert.setHeaderText(null);
            alert.setContentText(message);

            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStyleClass().add("success-alert");
            dialogPane.setStyle(
                    "-fx-background-color: white;" +
                            "-fx-border-color: #2ECC71;" +
                            "-fx-border-width: 2px;" +
                            "-fx-border-radius: 5px;"
            );

            Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setStyle(
                    "-fx-background-color: #2ECC71;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 5px;"
            );

            alert.showAndWait();
        });
    }

    private void showErrorMessage(String message) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText(message);

            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStyleClass().add("error-alert");
            dialogPane.setStyle(
                    "-fx-background-color: white;" +
                            "-fx-border-color: #E74C3C;" +
                            "-fx-border-width: 2px;" +
                            "-fx-border-radius: 5px;"
            );

            Button okButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            okButton.setStyle(
                    "-fx-background-color: #E74C3C;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 5px;"
            );

            alert.showAndWait();
        });
    }
}
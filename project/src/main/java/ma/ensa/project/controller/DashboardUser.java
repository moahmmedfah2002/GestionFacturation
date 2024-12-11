package ma.ensa.project.controller;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ma.ensa.project.entity.User;
import ma.ensa.project.service.UserService;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;

public class DashboardUser {


    public class UserModel extends RecursiveTreeObject<UserModel> {
        private SimpleIntegerProperty id;
        private SimpleStringProperty nomUtilisateur;
        private SimpleStringProperty motDePasse;
        private SimpleStringProperty role;

        // Constructeur
        public UserModel(int id, String nomUtilisateur, String motDePasse, String role) {
            this.id = new SimpleIntegerProperty(id);
            this.nomUtilisateur = new SimpleStringProperty(nomUtilisateur);
            this.motDePasse = new SimpleStringProperty(motDePasse);
            this.role = new SimpleStringProperty(role);
        }

        // Getters pour les valeurs
        public int getId() {
            return id.get();
        }

        public String getNomUtilisateur() {
            return nomUtilisateur.get();
        }

        public String getMotDePasse() {
            return motDePasse.get();
        }

        public String getRole() {
            return role.get();
        }

        // Getters pour les propriétés (nécessaires pour JFXTreeTableView)
        public SimpleIntegerProperty idProperty() {
            return id;
        }

        public SimpleStringProperty nomUtilisateurProperty() {
            return nomUtilisateur;
        }

        public SimpleStringProperty motDePasseProperty() {
            return motDePasse;
        }

        public SimpleStringProperty roleProperty() {
            return role;
        }
    }
    @FXML
    public VBox vbox= new VBox();

    @FXML
    public JFXTreeTableView<UserModel> userTable= new JFXTreeTableView<>();
    @FXML
    public JFXTreeTableColumn<UserModel, Integer> idColumn= new JFXTreeTableColumn<>("id");
    @FXML
    public JFXTreeTableColumn<UserModel, String> nameColumn= new JFXTreeTableColumn<>("username");
    @FXML
    public JFXTreeTableColumn<UserModel, String> passwordColumn=new JFXTreeTableColumn<>("password");
    @FXML
    public JFXTreeTableColumn<UserModel, String> roleColumn=new JFXTreeTableColumn<>("role");
    @FXML
    public Button btnClose;
    public Button btnFull;
    private static ObservableList<UserModel> userList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<User, Void> actionsColumn=new TableColumn<>("delete");

    private static UserService userDao;

    static {
        try {
            userDao = new UserService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public DashboardUser() throws SQLException, ClassNotFoundException {
        userDao = new UserService();
        userList = FXCollections.observableArrayList();
        userTable.getColumns().add(idColumn);
        userTable.getColumns().add(nameColumn);
        userTable.getColumns().add(passwordColumn);
        userTable.getColumns().add(roleColumn);


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
    public void close(ActionEvent mouseEvent) throws Throwable {

            Stage stage = (Stage) btnClose.getScene().getWindow();
            Update.etat=false;
            stage.hide();



    }



    public class Update extends Thread{
        private void loadUsers() throws SQLException {

            try {
                // Vider la liste existante
                userList.clear();


                // Convertir les Users en UserModels
                List<User> users = userDao.getAllUsers();
                Platform.runLater(() -> {
                    try {
                        userList.clear();

                        for (User user : users) {
                            UserModel userModel = new UserModel(
                                    user.getId(),
                                    user.getNomUtilisateur(),
                                    user.getMotDePasse(),
                                    user.getRole()
                            );
                            userList.add(userModel);
                        }

                        TreeItem<UserModel> root = new RecursiveTreeItem<>(userList, RecursiveTreeObject::getChildren);
                        userTable.setRoot(root);
                        userTable.setShowRoot(false);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
            public static boolean etat=true;
        @Override
        public void run(){

            while (etat){

                try {

                    System.out.println("check");
                    sleep(5000);
                    loadUsers();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        public static void cancel(){


            interrupted();
        }

    }
    @FXML
    public void initialize() throws IOException, SQLException {
        userTable.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        userTable.getStyleClass().addAll("table-view","table table-striped");


        // Configuration des colonnes



        idColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getValue().getId()));
        nameColumn.setCellValueFactory(cellData ->  new SimpleObjectProperty<>(cellData.getValue().getValue().getNomUtilisateur()));
        passwordColumn.setCellValueFactory(cellData ->  new SimpleObjectProperty<>(cellData.getValue().getValue().getMotDePasse()));
        roleColumn.setCellValueFactory(cellData ->  new SimpleObjectProperty<>(cellData.getValue().getValue().getRole()));

        Update update=new Update();
        update.start();





        // Chargement des données




































    }
















}
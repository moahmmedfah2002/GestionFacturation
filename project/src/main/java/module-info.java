module ma.ensa.project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ma.ensa.project to javafx.fxml;
    exports ma.ensa.project;
    exports ma.ensa.project.controller;
    opens ma.ensa.project.controller to javafx.fxml;
}
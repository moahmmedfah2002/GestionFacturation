module ma.ensa.project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires static lombok;
    requires java.desktop;
    requires org.testng;
//    requires org.junit.platform.commons;
    requires java.mail;
    requires activation;
    requires MaterialFX;


    opens ma.ensa.project to javafx.fxml;
    exports ma.ensa.project;
    exports ma.ensa.project.entity;
    exports ma.ensa.project.test;
    exports ma.ensa.project.controller;

    opens ma.ensa.project.controller to javafx.fxml;
}
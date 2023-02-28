/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DashboordRSController implements Initializable {
    @FXML
    private Label totalaa;

    @FXML
    private Label totalrapp;
    public static void main(String[] args) {
        launch(args);
    }


    public void showDashboardRS(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/DashboordRS.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showArchiveRS(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/Archive.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showMembersRS(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/MembersRS.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showSetting(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/SettingsAD.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
    public void showAnnonceRS(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/Annonce.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showtotalannonce(){
//        ArrayList<Activite> activites = new ArrayList<>();
//
//        totalaa.setText(Integer.parseInt(activites.size()));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Initializes the controller class.
     */
  
}



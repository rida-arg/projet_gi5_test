/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.example;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * FXML Controller class
 *
 * @author KAMUI
 */
public class MembersController implements Initializable {
    @FXML
    private Button ajouter_btn;
    @FXML
    private VBox vb1;
    @FXML
    private TextField email_txt;

    @FXML
    private ImageView image_txt;

    @FXML
    private TextField password_txt;

    @FXML
    private ComboBox<?> service_txt;
    @FXML
    private Button image_btn;
    @FXML
    private TextField username_txt;

    public static void main(String[] args) {
        launch(args);
    }


    public void showDashboardAD(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/DashboordAD.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showArchiveAD(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/ArchiveAD.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void showMembersAD(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/Members.fxml").toURI().toURL();
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
    public void showAnnonceAD(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/AnnonceAD.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public Image importimage(Stage stage){
        byte[] imageBytes = new byte[0];
        Image img = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*.png"));
        File pngImage = fileChooser.showOpenDialog(stage);
        if (pngImage != null) {
            try {
                imageBytes = Files.readAllBytes(pngImage.toPath());
            } catch (IOException e) {
                System.err.println("File couldn't be read to byte[].");
            }
        }
        img = new Image(new ByteArrayInputStream(imageBytes));
        System.out.println(imageBytes.length);
        image_txt.setImage(img);

        //   return imageBytes;
        return  img;

    }
//    public void addmember(){
//        User user = new User(username_txt.getText(),email_txt.getText(),password_txt.getText(),service_txt.getValue().toString(),image_txt.getImage());
//        Connexion cn = new Connexion();
//        System.out.println("mmmmmmm");
//        try {
//            cn.createconnection();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//
//        cn.adduser(user);
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        ajouter_btn.setOnAction(e -> addmember());
//        image_btn.setOnAction(event -> importimage(new Stage()));
    }    
    
}

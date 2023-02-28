/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.example;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * FXML Controller class
 *
 * @author KAMUI
 */
public class ArchiveController implements Initializable {

    public static void main(String[] args) {
        launch(args);
    }
    public byte[] test;
    @FXML
    private DatePicker date_txt;
    public URI uri;
    @FXML
    private TextArea details_txt;

    @FXML
    private TextField lieu_txt;
    @FXML
    private Button image_btn;
    @FXML
    private ComboBox<?> service_txt;

    @FXML
    private TextField sujet_txt;

    @FXML
    private Button valider_btn;
    @FXML
    private ImageView image_txt;

    @FXML
    private TextField sujet_txt1;

    @FXML
    private ComboBox<?> type_txt1;

    @FXML
    private Button valider1;
    @FXML
    private TextField lieu_txt1;
    @FXML
    private Button imagebtn1;
    @FXML
    private DatePicker date_txt1;
    @FXML
    private ImageView image_txt1;
    @FXML
    private TextArea details_txt1;

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
    public Image importimage(Stage stage){
        byte[] imageBytes = new byte[0];
        Image img = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "*.png"));
        File pngImage = fileChooser.showOpenDialog(stage);
        uri = pngImage.toURI();
        uri.toString();
        System.err.println(uri+"   chof hada");

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
        test = imageBytes;

        //   return imageBytes;
        return  img;
    }
    public void addrapport(){

        // ---detActivite----//

        rapport r1 = new rapport("",sujet_txt.getText(),lieu_txt.getText(),1,service_txt.getValue().toString(),uri.toString());
        Connexion cn = new Connexion();
        try {
            cn.createconnection();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        cn.addraport(1,r1);
    }
    public void modifierrapport(){
        //---------- detctivite-------pdf -------//
     //   rapport r2 = new rapport("",sujet_txt1.getText(),lieu_txt1.getText(),1,type_txt1,);
        Connexion cn = new Connexion();
        try {
            cn.createconnection();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
       // cn.updatrapport();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        valider_btn.setOnAction(event -> addrapport());
        image_btn.setOnAction(event ->importimage(new Stage()) );
        valider1.setOnAction(event -> modifierrapport());
    }
}

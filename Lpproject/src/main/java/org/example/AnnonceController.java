/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.example;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Base64;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
// import com.google.firebase.storage.StorageReference;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class AnnonceController implements Initializable {
    int compteur=0;
    String Images;
    Connexion cn;
    public URI uri;
    public byte[] test;
    @FXML
    private VBox vb1;
    @FXML
    private Button validerann;
    @FXML
    private DatePicker date_txt;

    @FXML
    private TextField details_txt;

    @FXML
    private ImageView image_txt;
    @FXML
    private Button image_btn;

    @FXML
    private TextField lieu_txt;

    @FXML
    private TextField sujet_txt;

    @FXML
    private ComboBox<String> type_txt;

    @FXML
    private ComboBox<String> service_selec;



    public static void main(String[] args) {
        launch(args);
        //  com.google.cloud.storage.;
    }





    public void showDashboardRS(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/DashboordRS.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showArchiveRS(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/Archive.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showMembersRS(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/MembersRS.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void showSetting(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/SettingsAD.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

    public void showAnnonceRS(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/org/example/Annonce.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

        Images = Base64.getEncoder().encodeToString(imageBytes);
        System.out.println(Images);

        System.out.println(imageBytes.clone().toString());

        //   return imageBytes;
        return  img;
    }


    public void AjouterAnn() throws ExecutionException, InterruptedException {

        Activite activite = new Activite(sujet_txt.getText(),type_txt.getValue().toString(),lieu_txt.getText(),date_txt.getValue().toString(),details_txt.getText(),Images);

        Composant comp = new Composant();

        //   HBox hb1 = comp.addlineann(activite);
        vb1.getChildren().add(comp.addline(activite));

        System.out.println("mmmmmmm");
        if (compteur==0)
        {

            cn.addactivite(4,activite);
            System.out.println("jjjjjjjj");
        }





    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cn = new Connexion();
        try {
            cn.createconnection();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        // ****************************//////////////////
        try {
            ArrayList<String> servs = cn.selectService();
            ObservableList<String> data = FXCollections.observableArrayList(servs);
            //  data.addAll(servs);
            System.out.println(data.get(0));
            service_selec.setItems(data); ;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // ****************************//////////////////
        try {
            ArrayList<String> cate = cn.getAllCategorie();
            ObservableList<String> dataCat = FXCollections.observableArrayList(cate);
            //  data.addAll(servs);
            System.out.println(dataCat.get(0));
            type_txt.setItems(dataCat); ;
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        try {
            ArrayList<Activite> array = cn.voirActivite();
            for (Activite ac: array
            ) {
                Composant comp = new Composant();

                System.out.println(ac.toString());
                vb1.getChildren().add(comp.addline(ac));
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


        // TODO
        validerann.setOnAction(event -> {
            try {
                AjouterAnn();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        image_btn.setOnAction(event ->importimage(new Stage()) );

    }
}
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
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KAMUI
 */
public class AjouteannonceRSController implements Initializable {
    @FXML
    private DatePicker date_txt;

    @FXML
    private TextArea details_txt;

    @FXML
    private ImageView image_txt;

    @FXML
    private Button imagebtn;

    @FXML
    private TextField lieu_txt;

    @FXML
    private TextField sujet_txt;

    @FXML
    private ComboBox<?> type_txt;
    public URI uri;
    @FXML
    private Button valider;
    Stage stage;
    public void showstage(Stage stage) {
        this.stage = stage;
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


        //   return imageBytes;
        return  img;
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

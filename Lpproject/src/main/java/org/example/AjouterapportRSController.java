/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package org.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KAMUI
 */
public class AjouterapportRSController implements Initializable {

    @FXML
    private DatePicker date_txt1;

    @FXML
    private TextArea details_txt1;

    @FXML
    private ImageView image_txt1;

    @FXML
    private Button imagebtn1;

    @FXML
    private TextField lieu_txt1;

    @FXML
    private TextField sujet_txt1;

    @FXML
    private ComboBox<?> type_txt1;

    @FXML
    private Button valider1;
    /**
     * Initializes the controller class.
     */
       public void importfile(ActionEvent event) throws IOException {
        VBox root = new VBox();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF File","pdf"));
        File file = fc.showOpenDialog(stage);
        
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

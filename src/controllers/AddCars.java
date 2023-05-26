package controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

public class AddCars implements Initializable {

    @FXML
    private JFXTextField City;

    @FXML
    private JFXTextField Email;

    @FXML
    private JFXPasswordField PhoneNumber;

    @FXML
    private JFXTextField State;

    @FXML
    private JFXTextField State1;

    @FXML
    private JFXButton Submit;

    @FXML
    private JFXTextField companyName;

    private File selectedImage;

    @FXML
    private Label img1;

    @FXML
    private Label img2;

    @FXML
    private Label img3;

    @FXML
    void Finance(ActionEvent event) {

    }

    @FXML
    private void selectImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        selectedImage = fileChooser.showOpenDialog(null);

        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();

        if (buttonId.equals("selectImageButton1")) {
            img1.setText(selectedImage.getName());
            img1.setVisible(true);
        } else if (buttonId.equals("selectImageButton2")) {
            img2.setText(selectedImage.getName());
            img2.setVisible(true);
        } else if (buttonId.equals("selectImageButton3")) {
            img3.setText(selectedImage.getName());
            img3.setVisible(true);
        }
        // if (selectedImage != null) {
        // if (selected == 1) {
        // img1.setText(selectedImage.getName());
        // } else if (selected == 2) {
        // img2.setText(selectedImage.getName());
        // } else if (selected == 3) {
        // img3.setText(selectedImage.getName());
        // }
        // }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        img1.setVisible(false);
        img2.setVisible(false);
        img3.setVisible(false);
    }

}

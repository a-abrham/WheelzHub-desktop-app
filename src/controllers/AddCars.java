package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class AddCars implements Initializable {

    @FXML
    private JFXTextField Address;

    @FXML
    private JFXTextField City;

    @FXML
    private AnchorPane Container;

    @FXML
    private JFXTextField Email;

    @FXML
    private JFXTextField State;

    @FXML
    private JFXButton Submit;

    @FXML
    private JFXButton backButton;

    @FXML
    private JFXTextField phone;

    @FXML
    void BackTo(ActionEvent event) {

    }

    @FXML
    void Finance(ActionEvent event) {
        // Open a dialog box to select an image file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        File selectedFile = fileChooser.showOpenDialog(Submit.getScene().getWindow());

        if (selectedFile != null) {
            // Get the destination folder path
            String destinationFolderPath = "D:\\Car rental System\\src\\image";

            // Create the destination file
            File destinationFile = new File(destinationFolderPath, selectedFile.getName());

            try {
                // Copy the selected image file to the destination folder
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Print the path of the copied image file
                System.out.println("Copied image file path: " + destinationFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }
}
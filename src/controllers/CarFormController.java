package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import DBconnection.DBhandler;

public class CarFormController {
    @FXML
    private TextField makeField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField colorField;
    @FXML
    private TextField mileageField;
    @FXML
    private TextField priceField;

    private File selectedImage;
    private Connection connection;
    private DBhandler handler;
    private PreparedStatement pst;

    @FXML
    private void selectImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
        selectedImage = fileChooser.showOpenDialog(null);
    }

    @FXML
    private void submitForm() {
        handler = new DBhandler(); // Initialize the DBhandler object

        String make = makeField.getText();
        String model = modelField.getText();
        int year = Integer.parseInt(yearField.getText());
        String color = colorField.getText();
        int mileage = Integer.parseInt(mileageField.getText());
        double price = Double.parseDouble(priceField.getText());

        // Code to insert the car details and image into the database
        try {
            connection = handler.getConnection();
            String insert = "INSERT INTO cars (make, model, year, color, mileage, price, image1) VALUES (?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(insert);
            pst.setString(1, make);
            pst.setString(2, model);
            pst.setInt(3, year);
            pst.setString(4, color);
            pst.setInt(5, mileage);
            pst.setDouble(6, price);
            FileInputStream imageStream = new FileInputStream(selectedImage);
            pst.setBinaryStream(7, imageStream);
            pst.executeUpdate();

            // hide current window
            makeField.getScene().getWindow().hide();
            Stage signupStage = new Stage();
            Image icon = new Image(getClass().getResourceAsStream("img/car.png"));
            signupStage.getIcons().add(icon);
            AnchorPane signupRoot = FXMLLoader.load(getClass().getResource("/FXML/signupSuccess.fxml"));
            Scene signupScene = new Scene(signupRoot);
            signupStage.setScene(signupScene);
            signupStage.show();
            signupStage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Use the selectedImage file for further processing

        // Reset the form fields after submission (optional)
        makeField.clear();
        modelField.clear();
        yearField.clear();
        colorField.clear();
        mileageField.clear();
        priceField.clear();
    }
}

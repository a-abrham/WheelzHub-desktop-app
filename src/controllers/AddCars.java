package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import DBconnection.DBhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.stage.FileChooser;

public class AddCars implements Initializable {

    @FXML
    private JFXButton Submit;

    @FXML
    private Label errMssg;

    @FXML
    private JFXTextField fule;

    @FXML
    private Label img1;

    @FXML
    private Label img2;

    @FXML
    private Label img3;

    @FXML
    private JFXTextField makeField;

    @FXML
    private JFXTextField modelField;

    @FXML
    private JFXTextField priceField;

    @FXML
    private Button selectImageButton1;

    @FXML
    private Button selectImageButton2;

    @FXML
    private Button selectImageButton3;

    @FXML
    private Label sucMssg;

    @FXML
    private JFXTextField transmission;

    @FXML
    private JFXTextField yearField;

    @FXML
    private MenuButton carCategoryMenuButton;

    @FXML
    private void category(ActionEvent event) {
        MenuButton clickedItem = (MenuButton) event.getSource();
        String clickedItemText = clickedItem.getText();
        carCategoryMenuButton.setText(clickedItemText);
        System.out.println(clickedItemText);
    }

    private File selectedImage1;
    private File selectedImage2;
    private File selectedImage3;
    private Connection connection;
    private DBhandler handler;
    private PreparedStatement pst;

    @FXML
    private void selectImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));

        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();

        if (buttonId.equals("selectImageButton1")) {
            selectedImage1 = fileChooser.showOpenDialog(null);
            img1.setText(selectedImage1.getName());
            img1.setVisible(true);
        } else if (buttonId.equals("selectImageButton2")) {
            selectedImage2 = fileChooser.showOpenDialog(null);
            img2.setText(selectedImage2.getName());
            img2.setVisible(true);
        } else if (buttonId.equals("selectImageButton3")) {
            selectedImage3 = fileChooser.showOpenDialog(null);
            img3.setText(selectedImage3.getName());
            img3.setVisible(true);
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        img1.setVisible(false);
        img2.setVisible(false);
        img3.setVisible(false);
        sucMssg.setVisible(false);
        errMssg.setVisible(false);
    }

    @FXML
    private void submitCarForm() {
        handler = new DBhandler(); // Initialize the DBhandler object

        String make = makeField.getText();
        String model = modelField.getText();
        Double year = 0.00;
        Double price = 0.00;

        try {
            year = Double.parseDouble(yearField.getText());
        } catch (NumberFormatException e) {
            sucMssg.setVisible(false);
            errMssg.setVisible(true);
            e.printStackTrace();

            return; // Exit the method if the year is not a valid number
        }

        try {
            price = Double.parseDouble(priceField.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return; // Exit the method if the price is not a valid number
        }

        // // Check if any input fields are empty
        // if (make.isEmpty() || model.isEmpty() || yearField.getText().isEmpty() ||
        // priceField.getText().isEmpty()) {
        // sucMssg.setVisible(false);
        // errMssg.setVisible(true);
        // return; // Exit the method if any input field is empty
        // }

        // Code to insert the car details and image into the database
        try {
            connection = handler.getConnection();
            String insert = "INSERT INTO cars (make, model, year, price, image1, image2, image3) VALUES (?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(insert);
            pst.setString(1, make);
            pst.setString(2, model);
            pst.setDouble(3, year);
            pst.setDouble(4, price);

            FileInputStream image1 = null;
            FileInputStream image2 = null;
            FileInputStream image3 = null;

            if (selectedImage1 != null) {
                image1 = new FileInputStream(selectedImage1);
            }

            if (selectedImage2 != null) {
                image2 = new FileInputStream(selectedImage2);
            }

            if (selectedImage3 != null) {
                image3 = new FileInputStream(selectedImage3);
            }

            pst.setBinaryStream(5, image1);
            pst.setBinaryStream(6, image2);
            pst.setBinaryStream(7, image3);

            pst.executeUpdate();
            sucMssg.setVisible(true);
            errMssg.setVisible(false);
            sucMssg.setText("Car inserted successfully");
        } catch (Exception e) {
            errMssg.setVisible(true);
            e.printStackTrace();
        }

        // Use the selectedImage file for further processing

        // Reset the form fields after submission (optional)
        makeField.clear();
        modelField.clear();
        yearField.clear();
        priceField.clear();
        img1.setText("");
        img2.setText("");
        img3.setText("");
        img1.setVisible(false);
        img2.setVisible(false);
        img3.setVisible(false);
        selectedImage1 = null;
        selectedImage2 = null;
        selectedImage3 = null;
    }
}
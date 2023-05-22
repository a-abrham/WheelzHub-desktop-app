package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class Reservation implements Initializable {

    @FXML
    private JFXPasswordField City;

    @FXML
    private JFXTextArea Comment;

    @FXML
    private JFXPasswordField Email;

    @FXML
    private JFXPasswordField PhoneNumber;

    @FXML
    private JFXPasswordField State;

    @FXML
    private JFXButton Submit;

    @FXML
    private JFXTextField companyName;

    @FXML
    private JFXButton financingButton;

    @FXML
    private ImageView progress;

    @FXML
    void Finance(ActionEvent event) {

    }

    @FXML
    void NavigateTofinance(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}

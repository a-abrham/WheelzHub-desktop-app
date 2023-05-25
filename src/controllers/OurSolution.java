package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class OurSolution implements Initializable {

    @FXML
    private JFXTextArea text;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        text.setStyle("-fx-text-fill: white;");
    }

}

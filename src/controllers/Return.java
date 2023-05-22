package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class Return implements Initializable {

    @FXML
    private AnchorPane Container;

    @FXML
    private JFXTextField Email;

    @FXML
    private JFXButton Submit;

    @FXML
    void SendToDataBase(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}


package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class sucess implements Initializable {

    @FXML
    private JFXButton login;

    @FXML
    void Home(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        Stage signUp = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
        Scene scene = new Scene(root);
        signUp.setScene(scene);
        signUp.show();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}

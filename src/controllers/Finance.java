package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class Finance implements Initializable {

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
        if (Holder != null) {
            Holder.getChildren().clear();
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Finance.fxml"));
            AnchorPane financePane = loader.load();
            setNode2(financePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNode2(AnchorPane node) {
        Holder.getChildren().clear();
        AnchorPane.setRightAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setBottomAnchor(node, 0.0);
        Holder.getChildren().add(node);
    }

    @FXML
    void Finance(ActionEvent event) {

    }

    private AnchorPane Holder;

    public void setHolder(AnchorPane holder) {
        Holder = holder;
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}

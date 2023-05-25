package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class returnfinance implements Initializable {

    @FXML
    private JFXButton buttonToBack;

    @FXML
    private JFXTextArea text;

    private AnchorPane holder;

    public void setHolder(AnchorPane holder) {
        this.holder = holder;
    }

    // @FXML
    // void back(ActionEvent event) {
    // try {
    // FXMLLoader loader = new
    // FXMLLoader(getClass().getResource("/FXML/Finance.fxml"));
    // AnchorPane financePane = loader.load();
    // Finance financeController = loader.getController();
    // financeController.setHolder(holder);
    // financeController.setNode2(financePane);
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    @FXML
    void back(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Finance.fxml"));
            AnchorPane financePane = loader.load();
            Finance financeController = loader.getController();
            financeController.setHolder(holder);
            financeController.setNode2(financePane);

            // Set the loaded Finance.fxml as the new content in the holder
            holder.getChildren().add(financePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setNode2(AnchorPane node) {
        holder.getChildren().clear();
        holder.getChildren().add(node);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        text.setStyle("-fx-text-fill: white;");
    }
}

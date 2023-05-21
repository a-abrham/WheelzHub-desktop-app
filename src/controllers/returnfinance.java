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

public class returnfinance implements Initializable{

    @FXML
    private JFXButton buttonToBack;

    @FXML
    private JFXTextArea text;

    @FXML
    void BackTo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Financing.fxml"));
            AnchorPane financePane = loader.load();
            setNode2(financePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        } 
        private AnchorPane Holder;

     public void getholder(AnchorPane holder) {
        Holder= holder;
}
          private void setNode2(AnchorPane node) {
            Holder.getChildren().clear();
            Holder.getChildren().add(node);
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        text.setStyle("-fx-text-fill: white;");
    }

}

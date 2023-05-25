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

    private AnchorPane Holder;

    public void setHolder(AnchorPane holder) {
        Holder = holder;
    }

    @FXML
    void BackTo(ActionEvent event) {
        if (Holder != null) {
            Holder.getChildren().clear();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Finance.fxml"));
                AnchorPane returnFinancePane = loader.load();
                returnfinance returnFinanceController = loader.getController();
                returnFinanceController.setHolder(Holder);
                returnFinanceController.setNode2(returnFinancePane);

                // Set the loaded returnfinance.fxml as the new content in the Holder
                Holder.getChildren().add(returnFinancePane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void setNode2(AnchorPane node) {
        Holder.getChildren().clear();
        AnchorPane.setRightAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setBottomAnchor(node, 0.0);
        Holder.getChildren().add(node);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Container.setStyle("-fx-max-width: 100%;");
        Double x = Container.getWidth();
        Container.setMaxWidth(x);
        Container.setStyle("-fx-background-color:  #2D3447;");
    }

}

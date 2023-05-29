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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Administrator implements Initializable {

    @FXML
    private JFXButton Contact;

    @FXML
    private AnchorPane Container;

    @FXML
    private JFXButton Resevation;

    @FXML
    private JFXButton addcars;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Pane pane;

    @FXML
    private JFXButton returnCar;

    @FXML
    void logout(ActionEvent event) {
        Container.getChildren().clear();
        Container.getChildren().clear();
        try {
            Container.getScene().getWindow().hide();
            Stage login = new Stage();
            Image icon = new Image(getClass().getResourceAsStream("../img/car.png"));
            login.getIcons().add(icon);
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
            Scene scene = new Scene(root);
            login.setScene(scene);
            login.show();
            login.setResizable(false);
            login.setTitle("WheelzHub - Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNode(AnchorPane node) {
        Container.getChildren().clear();
        Container.getChildren().add(node);
    }

    @FXML
    void AddCars(ActionEvent event) {
        Container.getChildren().clear();
        Container.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/carAdd.fxml"));
            setNode(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Contact(ActionEvent event) {

    }

    @FXML
    void Contain(MouseEvent event) {

    }

    @FXML
    void ReservationMethod(ActionEvent event) {
        Container.getChildren().clear();
        Container.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/Resevation.fxml"));
            setNode(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Return(ActionEvent event) {
        Container.getChildren().clear();
        Container.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/ReturnCars.fxml"));
            setNode(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        anchorpane.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            double panewidth = pane.getWidth();
            double anchorPaneWidth = newWidth.doubleValue();
            double containerWidth = anchorPaneWidth * 0.6; // 60% of the anchorpane width
            double containerLeftOffset = anchorPaneWidth * 0.3; // 30% of the anchorpane width

            Container.setPrefWidth(containerWidth);
            AnchorPane.setLeftAnchor(Container, panewidth);
            AnchorPane.setRightAnchor(Container, anchorPaneWidth - (containerWidth + containerLeftOffset));
        });

        AddCars(null);
    }

}

package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Administrator implements Initializable {

    @FXML
    private JFXButton Contact;

    @FXML
    private AnchorPane Container;

    @FXML
    private JFXButton addcars;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Pane pane;

    @FXML
    private JFXButton removeCars;

    @FXML
    void AddCars(ActionEvent event) {

        Container.getChildren().clear();
        Container.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/carAdd.fxml"));
            setNode7(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNode7(AnchorPane node) {
        Container.getChildren().clear();
        Container.getChildren().add(node);
    }

    @FXML
    void Contact(ActionEvent event) {

    }

    @FXML
    void Contain(MouseEvent event) {

    }

    @FXML
    void RemoveCars(ActionEvent event) {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        anchorpane.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            double panewidth = pane.getWidth();
            double anchorPaneWidth = newWidth.doubleValue();
            double containerWidth = anchorPaneWidth * 0.6; // 60% of the anchorpane width
            double containerLeftOffset = anchorPaneWidth * 0.3; // 30% of the anchorpane width

            // Set the width and left/right offsets of the Container AnchorPane
            Container.setPrefWidth(containerWidth);
            AnchorPane.setLeftAnchor(Container, panewidth);
            AnchorPane.setRightAnchor(Container, anchorPaneWidth - (containerWidth + containerLeftOffset));
        });
    }

}

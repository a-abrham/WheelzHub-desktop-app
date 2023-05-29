package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class Catagory {

    @FXML
    private AnchorPane Holder;

    @FXML
    void fetchCasual(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/casualcars.fxml"));
            Holder.getChildren().removeAll();
            Holder.getChildren().setAll(root);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    void fetchConstruction(ActionEvent event) {

    }

    @FXML
    void fetchFunneral(ActionEvent event) {

    }

    @FXML
    void fetchTour(ActionEvent event) {

    }

    @FXML
    void fetchWedding(ActionEvent event) {

    }

}

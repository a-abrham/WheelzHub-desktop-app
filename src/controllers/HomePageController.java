package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToolbar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class HomePageController implements Initializable {

    @FXML
    private JFXButton Catagory;

    @FXML
    private JFXButton about;

    @FXML
    private JFXButton Finance;

    @FXML
    private AnchorPane Holder;

    @FXML
    private JFXButton OurSolution;

    @FXML
    private JFXButton checkout;

    @FXML
    private JFXToolbar welcome;

    @FXML
    private AnchorPane holder;

    @FXML
    private JFXButton item;

    @FXML
    private AnchorPane toplist;

    @FXML
    private Text wellcome;

    @FXML
    void Catagory(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/Catagory.fxml"));
            setNode3(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNode3(AnchorPane node1) {
        Holder.getChildren().clear();
        AnchorPane.setRightAnchor(node1, 0.0);
        AnchorPane.setLeftAnchor(node1, 0.0);
        AnchorPane.setTopAnchor(node1, 0.0);
        AnchorPane.setBottomAnchor(node1, 0.0);
        Holder.getChildren().add(node1);
    }

    @FXML
    void about(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/about.fxml"));
            setNode4(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNode4(AnchorPane node1) {
        Holder.getChildren().clear();
        AnchorPane.setRightAnchor(node1, 0.0);
        AnchorPane.setLeftAnchor(node1, 0.0);
        AnchorPane.setTopAnchor(node1, 0.0);
        AnchorPane.setBottomAnchor(node1, 0.0);
        Holder.getChildren().add(node1);
    }

    @FXML
    void checkout(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/checkout.fxml"));
            setNode5(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNode5(AnchorPane node1) {
        Holder.getChildren().clear();
        AnchorPane.setRightAnchor(node1, 0.0);
        Holder.getChildren().add(node1);
        AnchorPane.setTopAnchor(node1, 0.0);
        AnchorPane.setBottomAnchor(node1, 0.0);
        AnchorPane.setLeftAnchor(node1, 0.0);
    }

    @FXML
    void Home(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/home.fxml"));
            setNode7(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNode7(AnchorPane node) {
        Holder.getChildren().clear();
        Holder.getChildren().add(node);
    }

    @FXML
    void Finances(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Financing.fxml"));
            AnchorPane financePane = loader.load();

            // Get the finance controller instance
            Finance financeController = loader.getController();
            // Pass the Holder reference to the finance controller
            financeController.setHolder(Holder);

            setNode1(financePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNode1(AnchorPane node) {
        Holder.getChildren().clear();
        AnchorPane.setRightAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setBottomAnchor(node, 0.0);
        Holder.getChildren().add(node);
    }

    @FXML
    void OurSolutions(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/OurSolution.fxml"));
            setNode2(homePane);
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
    void navigate(ActionEvent event) {
        // Clear current content
        Holder.getChildren().clear();
        holder.getChildren().clear();
        // Add Home.fxml
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
            setNode(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setNode(AnchorPane node) {
        Holder.getChildren().clear();
        AnchorPane.setRightAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setBottomAnchor(node, 0.0);
        Holder.getChildren().add(node);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Holder.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            double panewidth = welcome.getWidth();
            double anchorPaneWidth = newWidth.doubleValue();
            double containerWidth = anchorPaneWidth * 0.5; // 60% of the anchorpane width
            double containerLeftOffset = anchorPaneWidth * 0.3; // 30% of the anchorpane width
            // double containerRightOffset = anchorPaneWidth * 0.2; // 10% of the anchorpane
            // width

            // Set the width and left/right offsets of the Container AnchorPane
            // welcome.setPrefWidth(containerWidth);
            // AnchorPane.setRightAnchor(welcome, anchorPaneWidth - (containerWidth +
            // containerLeftOffset));

            // wel Come set Width length
            double leftsideofwellcome = anchorPaneWidth * 4.5;
            AnchorPane.setRightAnchor(wellcome, leftsideofwellcome);
            AnchorPane.setLeftAnchor(wellcome, leftsideofwellcome);
        });
    }
}

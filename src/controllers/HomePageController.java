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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePageController implements Initializable {

    @FXML
    private JFXButton Catagory;

    @FXML
    private JFXButton Finance;

    @FXML
    private AnchorPane Holder;

    @FXML
    private JFXButton Home;

    @FXML
    private JFXButton OurSolution;

    @FXML
    private JFXButton about;

    @FXML
    private JFXButton checkout;

    @FXML
    private JFXButton checkout1;

    @FXML
    private AnchorPane holder;

    @FXML
    private AnchorPane holder1;

    @FXML
    private ImageView image;

    @FXML
    private ImageView image1;

    @FXML
    private JFXButton item;

    @FXML
    private AnchorPane toplist;

    @FXML
    private JFXToolbar welcome;
    @FXML
    private JFXButton forward;

    @FXML
    private JFXButton next;

    @FXML
    private Text wellcome;

    private void setNode(AnchorPane node) {
        Holder.getChildren().clear();
        AnchorPane.setRightAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setBottomAnchor(node, 0.0);
        Holder.getChildren().add(node);
    }

    @FXML
    void Home(ActionEvent event) {
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/home.fxml"));
            setNode(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Catagory(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/Catagory.fxml"));
            setNode(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Finances(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Financing.fxml"));
            AnchorPane financePane = loader.load();
            Finance financeController = loader.getController();
            financeController.setHolder(Holder);
            setNode(financePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OurSolutions(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/OurSolution.fxml"));
            setNode(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void about(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            AnchorPane homePane = FXMLLoader.load(getClass().getResource("/FXML/about.fxml"));
            setNode(homePane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void checkout(ActionEvent event) {
        Holder.getChildren().clear();
        holder.getChildren().clear();
        try {
            Holder.getScene().getWindow().hide();
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        Holder.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            double anchorPaneWidth = newWidth.doubleValue();
            double leftsideofwellcome = anchorPaneWidth * 4.5;
            AnchorPane.setRightAnchor(wellcome, leftsideofwellcome);
            AnchorPane.setLeftAnchor(wellcome, leftsideofwellcome);
        });
        Home(null);
    }
}
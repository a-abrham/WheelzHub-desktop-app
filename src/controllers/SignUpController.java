package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import DBconnection.DBhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignUpController implements Initializable {

  @FXML
  private ToggleGroup Gender;

  @FXML
  private JFXButton Signupto;

  @FXML
  private JFXRadioButton female;

  @FXML
  private JFXTextField location;

  @FXML
  private JFXRadioButton male;

  @FXML
  private JFXTextField name;

  @FXML
  private Label progress;

  @FXML
  private AnchorPane parentPane;

  @FXML
  private JFXPasswordField password;

  @FXML
  private JFXButton signup;

  private Connection connection;
  private DBhandler handler;
  private PreparedStatement pst;

  @FXML
  void signup(ActionEvent event) throws IOException {
    signup.getScene().getWindow().hide();
    Stage login = new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
    Scene scene = new Scene(root);
    login.setScene(scene);
    login.show();
    login.setResizable(false);
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    name.setStyle("-fx-text-inner-color:#a0a2ab");
    location.setStyle("-fx-text-inner-color:#a0a2ab");
    password.setStyle("-fx-text-inner-color:#a0a2ab");
    progress.setVisible(false);
    handler = new DBhandler(); // Initialize the DBhandler object
  }

  @FXML
  void Database(ActionEvent event) throws IOException {
    try {
      Database();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void Database() throws SQLException, IOException {
    String inser = "INSERT INTO users(username, password, gender, location)" + "VALUES (?,?,?,?)";
    connection = handler.getConnection();
    try {
      pst = connection.prepareStatement(inser);
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      pst.setString(1, name.getText());
      pst.setString(2, password.getText());
      pst.setString(3, getGender());
      pst.setString(4, location.getText());

      pst.executeUpdate();

      signup.getScene().getWindow().hide();
      Stage signupStage = new Stage();
      AnchorPane signupRoot = FXMLLoader.load(getClass().getResource("/FXML/signupSuccess.fxml"));
      Scene signupScene = new Scene(signupRoot);
      signupStage.setScene(signupScene);
      signupStage.show();
      signupStage.setResizable(false);
    } catch (SQLException e) {
      progress.setVisible(true);
    }
  }

  public String getGender() {
    String gen = "";
    if (male.isSelected()) {
      gen = "Male";
    }
    if (female.isSelected()) {
      gen = "Female";
    }
    return gen;
  }
}
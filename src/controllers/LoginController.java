package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import DBconnection.DBhandler;

public class LoginController implements Initializable {

    @FXML
    private JFXButton forgotPassword;

    @FXML
    private JFXButton login;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Label progress;

    @FXML
    private JFXCheckBox remember;

    @FXML
    private JFXButton signUp;

    @FXML
    private JFXTextField username;

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        try {
            loginAction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connection;
    private DBhandler handler;
    private PreparedStatement pst;

    @FXML
    public void signUp(ActionEvent event) throws IOException {
        login.getScene().getWindow().hide();
        Stage signUp = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/SignUp.fxml"));
        Scene scene = new Scene(root);
        signUp.setScene(scene);
        signUp.show();
        signUp.setResizable(false);
    }

    public void loginAction() throws SQLException, IOException {
        connection = handler.getConnection();

        if (remember.isSelected()) {
            String loginQ = "SELECT * FROM admins where username=? and password=?";
            try {
                pst = connection.prepareStatement(loginQ);
                pst.setString(1, username.getText());
                pst.setString(2, password.getText());

                ResultSet rs = pst.executeQuery();

                int count = 0;
                while (rs.next()) {
                    count = count + 1;
                }

                if (count == 1) {
                    login.getScene().getWindow().hide();
                    Stage administratorStage = new Stage();
                    Parent administratorRoot = FXMLLoader.load(getClass().getResource("/FXML/administrator.fxml"));
                    Scene administratorScene = new Scene(administratorRoot);
                    administratorStage.setScene(administratorScene);
                    administratorStage.show();
                } else {
                    System.out.println("Username and password is not correct");
                    progress.setVisible(true);

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            finally {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            String loginQ = "SELECT * FROM users where username=? and password=?";
            try {
                pst = connection.prepareStatement(loginQ);
                pst.setString(1, username.getText());
                pst.setString(2, password.getText());

                ResultSet rs = pst.executeQuery();

                int count = 0;
                while (rs.next()) {
                    count = count + 1;
                }

                if (count == 1) {
                    login.getScene().getWindow().hide();
                    Stage signUp = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/homepage.fxml"));
                    Scene scene = new Scene(root);
                    signUp.setScene(scene);
                    signUp.show();
                    signUp.setResizable(false);
                } else {
                    System.out.println("Username and password is not correct");
                    progress.setVisible(true);

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            finally {
                try {
                    connection.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        progress.setVisible(false);
        username.setStyle("-fx-text-inner-color:#a0a2ab");
        password.setStyle("-fx-text-inner-color:#a0a2ab");

        handler = new DBhandler();
    }
}

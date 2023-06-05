package controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToolbar;
import DBconnection.DBhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class fetchcontent implements Initializable {

    @FXML
    private JFXButton forward;

    @FXML
    private AnchorPane holder;

    @FXML
    private AnchorPane Holder;

    @FXML
    private JFXButton next;

    @FXML
    private AnchorPane toplist;

    @FXML
    private JFXToolbar welcome;

    @FXML
    private Text wellcome;

    private Connection connection;
    private DBhandler handler;
    private PreparedStatement pst;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    void forward(ActionEvent event) {
        double scrollAmount = scrollPane.getHvalue() - 0.4;
        scrollPane.setHvalue(scrollAmount);
    }

    @FXML

    void next(ActionEvent event) {
        double scrollAmount = scrollPane.getHvalue() + 0.42;
        scrollPane.setHvalue(scrollAmount);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        handler = new DBhandler();
        String loginQuery = "SELECT * FROM cars";
        try {
            connection = handler.getConnection();
            pst = connection.prepareStatement(loginQuery);
            ResultSet rs = pst.executeQuery();

            Double x = 30.0; // Initial position for the Label
            double labelX = 50.0;
            while (rs.next()) {
                String make = rs.getString("make");
                String model = rs.getString("model");
                String year = rs.getString("year");
                byte[] imageData = rs.getBytes("image1");
                Car car = new Car(make, model, year, make, make, imageData);

                VBox vbox = new VBox();
                vbox.setLayoutX(labelX);
                vbox.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
                vbox.setSpacing(10);

                vbox.setAlignment(Pos.TOP_CENTER);

                ImageView imageView = new ImageView();
                imageView.setFitWidth(200);
                imageView.setFitHeight(200);
                if (car.getimage() != null) {
                    ByteArrayInputStream imageStream = new ByteArrayInputStream(car.getimage());
                    Image image = new Image(imageStream);
                    imageView.setImage(image);
                }

                Label makeLabel = new Label("Make: " + car.getmake());
                makeLabel.setMinHeight(30);
                Label modelLabel = new Label("Model: " + car.getmodel());
                modelLabel.setMinHeight(30);
                Label colorLabel = new Label("Color: " + car.getcolor());
                colorLabel.setMinHeight(30);
                Label yearLabel = new Label("Year: " + car.getYear());
                yearLabel.setMinHeight(30);

                vbox.getChildren().addAll(imageView, makeLabel, modelLabel, colorLabel, yearLabel);
                vbox.setPrefWidth(250);

                makeLabel.setAlignment(Pos.CENTER);
                modelLabel.setAlignment(Pos.CENTER);
                colorLabel.setAlignment(Pos.CENTER);
                yearLabel.setAlignment(Pos.CENTER);

                AnchorPane.setTopAnchor(vbox, 50.0);
                toplist.getChildren().add(vbox);
                AnchorPane.setLeftAnchor(vbox, x);
                x += 275;

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        scrollPane = new ScrollPane(toplist);

        toplist.setStyle("-fx-background-color: #b0b6c5;");
        scrollPane.setStyle("-fx-background-color: #b0b6c5;");
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        AnchorPane.setTopAnchor(scrollPane, 80.0);
        AnchorPane.setRightAnchor(scrollPane, 75.0);
        AnchorPane.setBottomAnchor(scrollPane, 500.0);
        AnchorPane.setLeftAnchor(scrollPane, 75.0);

        Holder.getChildren().add(scrollPane);
    }

    // put the following in the right place abresho

    @FXML
    void toHomepage(ActionEvent e) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/Catagory.fxml"));
            Holder.getChildren().removeAll();
            Holder.getChildren().setAll(root);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

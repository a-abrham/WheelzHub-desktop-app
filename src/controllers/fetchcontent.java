package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToolbar;
import DBconnection.DBhandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
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
            double labelY = 30.0;
            double labelX = 50.0;
            List<Label> yearLabels = new ArrayList<>();
            List<Label> makeLabels = new ArrayList<>();
            List<Label> modelLabels = new ArrayList<>();
            List<Label> colorLabels = new ArrayList<>();
            List<Label> mileeagLabels = new ArrayList<>();
            while (rs.next()) {
                labelY = 30.0;
                String make = rs.getString("make");
                String model = rs.getString("model");
                String year = rs.getString("year");
                Car car = new Car(make, model, year, make, make, make);

                Label yearLabel = new Label(car.getYear());
                Label makeLabel = new Label(car.getmake());
                Label modelLabel = new Label(car.getmodel());
                Label colorLabel = new Label(car.getcolor());
                Label mileagLabel = new Label(car.getmileage());
                yearLabels.add(yearLabel);
                makeLabels.add(makeLabel);
                modelLabels.add(modelLabel);
                colorLabels.add(colorLabel);
                mileeagLabels.add(mileagLabel);

                Pane pane = new Pane();
                pane.setLayoutX(labelX);
                pane.setBackground(new Background(new BackgroundFill(Color.GRAY, null,
                        null)));
                pane.getChildren().addAll(yearLabel, makeLabel, modelLabel, colorLabel,
                        mileagLabel);
                pane.setPrefWidth(250);

                makeLabel.setLayoutY(labelY);
                labelY = labelY + 50;
                modelLabel.setLayoutY(labelY);
                labelY = labelY + 50;
                colorLabel.setLayoutY(labelY);
                labelY = labelY + 50;
                mileagLabel.setLayoutY(labelY);
                labelY = labelY + 50;
                yearLabel.setLayoutY(labelY);
                labelY = labelY + 50;
                mileagLabel.setLayoutY(labelY);
                labelY = labelY + 50;
                AnchorPane.setTopAnchor(yearLabel, 50.0);
                AnchorPane.setLeftAnchor(yearLabel, 50.0);

                toplist.getChildren().add(pane);
                AnchorPane.setLeftAnchor(pane, x);
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

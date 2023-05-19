package controllers;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class HomePageController implements Initializable {

    @FXML
    private AnchorPane Holder;

    @FXML
    private AnchorPane holder;

    @FXML
    private Text wellcome;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
         createPage();
       
    }
   private void setNode(Node node){
    Holder.getChildren().clear();
    Holder.getChildren().add((Node) node);


   }
    private void createPage() {
    }

}

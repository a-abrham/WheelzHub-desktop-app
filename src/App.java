import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
   @Override
   public void start(Stage primaryStage) throws IOException {
      Image icon = new Image(getClass().getResourceAsStream("img/car.png"));
      primaryStage.getIcons().add(icon);
      Parent root = FXMLLoader.load(getClass().getResource("/FXML/login.fxml"));
      Scene scene = new Scene(root, 600, 400);
      primaryStage.setScene(scene);
      primaryStage.show();
      primaryStage.setResizable(true);
      primaryStage.setTitle("WheelzHub - Login");

   }

   public static void main(String[] args) {
      launch(args);
   }
}
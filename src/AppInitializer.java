
import Controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Controller c =new Controller();
//        c.music();
        Parent root = FXMLLoader.load(this.getClass().getResource("Views/Dashboard.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("BattleField");
        primaryStage.setScene(scene);

        primaryStage.show();

    }
}

package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Score implements Initializable {
    public Button Playagain;
    public TextField FinalScore;
    public TextField PlayerName;


    public void PlayagainAction(ActionEvent actionEvent) {
    }

    public void PlayAgainClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/Views/Customer.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage)Playagain.getScene().getWindow();
        primaryStage.setTitle("BattleField");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PlayerName.setText(Controller.playerName());
        FinalScore.setText(String.valueOf(Controller.PlayerScore()));
    }
}

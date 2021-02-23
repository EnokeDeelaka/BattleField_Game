package Controller;

import com.sun.tools.hat.internal.model.Root;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class DashboardController {
    public Button Close;
    public Button Maximize;
    public Button Minimize;
    public Button BtnStartGame;

    public void CloseAction(ActionEvent actionEvent) {
    }

    public void MaximizeAction(ActionEvent actionEvent) {
    }

    public void MinimizeAction(ActionEvent actionEvent) {
    }

    public void StartGameAction(ActionEvent actionEvent) throws IOException {
        JFrame f ;
        f = new JFrame();
        JOptionPane.showMessageDialog(f,"Welcome to the BattleField");
        JOptionPane.showMessageDialog(f,"Please Enjoy the Game");
        Parent root = FXMLLoader.load(this.getClass().getResource("/Views/Customer.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage)BtnStartGame.getScene().getWindow();
        primaryStage.setTitle("BattleField");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}

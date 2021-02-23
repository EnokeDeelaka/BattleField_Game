package Controller;
import java.io.FileInputStream;
import java.io.IOException;


import java.lang.reflect.Array;
import java.lang.reflect.Method;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import weapon.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Optional;

public class Controller {
    static int count = 0;
    static int countB = 0;
    public Button BtnStart;
    public CheckBox T56Check;
    public CheckBox TankCheck;
    public CheckBox MultiCheck;
    public CheckBox PistolCheck;
    public CheckBox BombCheck;
    public AnchorPane PlayerTwoPanel;
    public AnchorPane PlayerOnePanel;
    public CheckBox T56Check2;
    public CheckBox TankCheck2;
    public CheckBox MultiCheck2;
    public CheckBox PistolCheck2;
    public CheckBox BombCheck2;
    static int total =0;
    static int totalB = 0;
    Bomb bomb = new Bomb();
    MultiBarrel multiBarrel = new MultiBarrel();
    Pistol pistol = new Pistol();
    T56 t56 = new T56();
    Tank tank = new Tank();

//    Controller(){
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("BattleField");
//        alert.setHeaderText("Read Carefully");
//        alert.setContentText("Each player Please Select 3 weapons to Fight");
//    }


    public void BtnClickOnAction(ActionEvent actionEvent) {
        JFrame f ;
        f = new JFrame();
        JOptionPane.showMessageDialog(f,"Weapons Ready to use");
        Calculator();
        CalculatorB();
    }
    public void PlayerACheckT56(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("BattleField");
        alert.setHeaderText("Read Carefully");
        alert.setContentText("Each Player Can Select 3 Weapons Only");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
        int shoot = t56.shoot();
        if (T56Check.isSelected()==true){
            count++;
            System.out.println("T56 weapon Activated");


        }else{
            count--;
        }
        CountA();

    }
    public void PlayerACheckTank(MouseEvent mouseEvent) {
        int shoot = tank.shoot();
        if (TankCheck.isSelected()==true){
            count++;
            System.out.println("Tank weapon Activated");
//            Controller c = new Controller();
////            c.Count(1);
        }else {
            count--;

        }
        CountA();
    }
    public void PlayerACheckMulti(MouseEvent mouseEvent) {
        int shoot = multiBarrel.shoot();
        if (MultiCheck.isSelected()==true){
            count++;
            System.out.println("Multi Barrel Weapon Activated");
        }else{
            count--;
        }
        CountA();
    }
    public void PlayerACheckPistol(MouseEvent mouseEvent) {
        int shoot = pistol.shoot();
        if (PistolCheck.isSelected()==true){
            count++;
            System.out.println("Pistol weapon Activated");
        }else{
            count--;
        }
        CountA();
    }
    public void PlayerACheckBomb(MouseEvent mouseEvent) {
        int shoot = bomb.shoot();
        if (BombCheck.isSelected()==true){
            count++;

            System.out.println("Bomb weapon Activated");
        }else{
            count--;
        }
        CountA();

    }
    public void AllCheckbox(ActionEvent actionEvent) {
    }
    public void CountA(){
        if (count==3){
            if (T56Check.isSelected()==false){
                T56Check.setDisable(true);
            }
            if (MultiCheck.isSelected()==false){
                MultiCheck.setDisable(true);
            }
            if (PistolCheck.isSelected()==false){
                PistolCheck.setDisable(true);
            }
            if (BombCheck.isSelected()==false){
                BombCheck.setDisable(true);
            }
        }
        if (count<3){
            T56Check.setDisable(false);
            MultiCheck.setDisable(false);
            PistolCheck.setDisable(false);
            BombCheck.setDisable(false);
        }

    }

    public void PlayerBCheckBomb(MouseEvent mouseEvent) {
        int shoot = bomb.shoot();
        if (BombCheck2.isSelected()==true){
            countB++;

            System.out.println("Bomb Weapon2 Activated");
        }else{
            countB--;
        }
        CountB();

    }

    public void PlayerBCheckPistol(MouseEvent mouseEvent) {
        int shoot = pistol.shoot();
        if (PistolCheck2.isSelected()==true){
            countB++;
            System.out.println("Pistol Weapon2 Activated");
        }else{
            countB--;
        }
        CountB();

    }

    public void PlayerBCheckMulti(MouseEvent mouseEvent) {
        int shoot = multiBarrel.shoot();
        if (MultiCheck2.isSelected()==true){
            countB++;
            System.out.println("Multi Barrel2 weapon Activated");
        }else{
            countB--;
        }
        CountB();
    }

    public void PlayerBCheckTank(MouseEvent mouseEvent) {
        int shoot = tank.shoot();
        if (TankCheck2.isSelected()==true){
            countB++;
            System.out.println("Tank Weapon2 Activated");
//            Controller c = new Controller();
////            c.Count(1);
        }else {
            countB--;

        }
        CountB();
    }

    public void PlayerBCheckT56(MouseEvent mouseEvent) {
        int shoot = bomb.shoot();
        if (T56Check2.isSelected()==true){
            countB++;
            System.out.println("T56 Weapon2 Activated");

        }else {
            countB--;
        }
        CountB();
    }
    public void CountB(){
        if (count==3){
            if (T56Check2.isSelected()==false){
                T56Check2.setDisable(true);
            }
            if (MultiCheck2.isSelected()==false){
                MultiCheck2.setDisable(true);
            }
            if (PistolCheck2.isSelected()==false){
                PistolCheck2.setDisable(true);
            }
            if (BombCheck2.isSelected()==false){
                BombCheck2.setDisable(true);
            }
        }
        if (countB<3){
            T56Check2.setDisable(false);
            MultiCheck2.setDisable(false);
            PistolCheck2.setDisable(false);
            BombCheck2.setDisable(false);
        }

    }

    public void BattleStartMouseClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/Views/Score.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage)BtnStart.getScene().getWindow();
        primaryStage.setTitle("BattleField");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
    public void Calculator(){
        if (T56Check.isSelected()==true){
            total += bomb.shoot();
        }
        if (MultiCheck.isSelected()==true){
            total += bomb.shoot();
        }
        if (PistolCheck.isSelected()==true){
            total += bomb.shoot();
        }
        if (BombCheck.isSelected()==true) {
            total += bomb.shoot();
        }
    }
    public void CalculatorB(){
        if (T56Check2.isSelected()==true){
            total += bomb.shoot();
        }
        if (MultiCheck2.isSelected()==true){
            total += bomb.shoot();
        }
        if (PistolCheck2.isSelected()==true){
            total += bomb.shoot();
        }
        if (BombCheck2.isSelected()==true) {
            total += bomb.shoot();
        }
    }
    public static String playerName(){
        if (total>totalB){
            return "player A Win";
        }else {
            return "Player B win";
        }
    }
    public static  int PlayerScore(){
        if (total>totalB){
            return total;
        }else {
            return totalB;
        }
    }
//    public static void music()
//    {
//        AudioPlayer MGP = AudioPlayer.player;
//        AudioStream BGM;
//        AudioData MD;
//
//        ContinuousAudioDataStream loop = null;
//
//        try
//        {
//            BGM = new AudioStream(new FileInputStream("Music/music.mp3"));
//            MD = BGM.getData();
//            loop = new ContinuousAudioDataStream(MD);
//        }
//        catch(IOException e)
//        {
//            System.out.println("cant find the file");
//        }
//
//        MGP.start(loop);
//    }
}

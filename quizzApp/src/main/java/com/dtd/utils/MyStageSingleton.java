/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtd.utils;

import com.dtd.quizzapp.quizzapp.App;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author tiend
 */
public class MyStageSingleton {
    private static MyStageSingleton instance;
    private final Stage stage;

    public MyStageSingleton() {
        this.stage = new Stage();
        this.stage.setTitle("Quizz app");
    }
    
    public static MyStageSingleton getInSingleton(){
        if(instance == null)
            instance = new MyStageSingleton();
        return instance;
    }
    
    public  void showStage(String fxml){
        if(this.stage.isShowing()){
            try {
                Scene scene = new Scene(new FXMLLoader(App.class.getResource(fxml + ".fxml")).load());
                this.stage.setScene(scene);
                this.stage.show();
            } catch (IOException ex) {
                System.getLogger(MyStageSingleton.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }
}

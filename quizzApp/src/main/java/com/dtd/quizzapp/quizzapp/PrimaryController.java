package com.dtd.quizzapp.quizzapp;

import com.dtd.utils.MyAlertSingleton;
import com.dtd.utils.MyStageSingleton;
import com.dtd.utils.themes.ThemeTyles;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable{
    @FXML private ComboBox<ThemeTyles> cbThemes;
    
    
    
    public void manageQuestion  (ActionEvent e){
        MyStageSingleton.getInSingleton().showStage("");
    }
    public void practive (ActionEvent e){
        MyAlertSingleton.getInstance().showAlert("Coming soon practive");
    }
    public void exam (ActionEvent e){
        MyAlertSingleton.getInstance().showAlert("Coming soon exam");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbThemes.setItems(FXCollections.observableArrayList(ThemeTyles.values()));
    }
    
    public void changeTheme(ActionEvent e){
        this.cbThemes.getSelectionModel().getSelectedItem().updateTheme(this.cbThemes.getScene());
    }
}

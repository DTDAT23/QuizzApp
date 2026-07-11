/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizappv2;

import com.dht.pojo.Category;
import com.dht.pojo.Level;
import com.dht.pojo.Question;
import com.dht.pojo.QuestionQueryBuilder;
import com.dht.services.questions.QuestionServiceDeccorator;
import com.dht.utils.Configs;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PractiveController implements Initializable {
    @FXML
    private ComboBox<Category> cbSearchCates;
    @FXML
    private ComboBox<Level> cbSearchLevels;
    @FXML private TextField txtnum;
    @FXML private Label lblContent;
    private List<Question> questions;
    private int currentIdx = -1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.cbSearchCates.setItems(FXCollections.observableList(Configs.cateService.getCates()));
            this.cbSearchLevels.setItems(FXCollections.observableList(Configs.lvlService.getLevels()));
            
        } catch (SQLException ex) {
            
        }
    }    
    
    public void start(ActionEvent e){
        QuestionQueryBuilder query;
        query = new QuestionQueryBuilder().withCategory(this.cbSearchCates.getSelectionModel().getSelectedItem())
                .withLevel(this.cbSearchLevels.getSelectionModel().getSelectedItem())
                        .setLimit (this.txtnum.getText()).setOrderby("rand()");
        
        Configs.quesService.setQuery(query);
        
        try {
            this.questions = new QuestionServiceDeccorator(Configs.quesService).getQuestions();
            this.currentIdx = -1;
            this.showQuestion(1);
        } catch (SQLException ex) {
            Logger.getLogger(PractiveController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void next(ActionEvent e){
        this.showQuestion(1);
    }
    
    public void previous(ActionEvent e){
        this.showQuestion(-1);
    }
    
    public void showQuestion(int step){
        this.currentIdx += step;
        if(this.currentIdx >= 0 && this.currentIdx < this.questions.size()){
        Question q = this.questions.get(this.currentIdx);
        
        this.lblContent.setText(q.getContent());
        }
    }
}

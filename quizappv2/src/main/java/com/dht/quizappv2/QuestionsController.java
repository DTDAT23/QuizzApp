/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizappv2;

import com.dht.pojo.Category;
import com.dht.pojo.Choice;
import com.dht.pojo.Level;
import com.dht.pojo.Question;
import com.dht.services.CategoryServices;
import com.dht.services.LevelServices;
import com.dht.services.questions.QuestionServices;
import com.dht.utils.Configs;
import com.dht.utils.MyAlertSingleton;
import com.dht.utils.MyConnectionSingleton;
import java.io.ObjectInputFilter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {

    @FXML
    private ComboBox<Category> cbCates;
    @FXML
    private ComboBox<Level> cbLevels;
    @FXML
    private TableView<Question> tvQuestions;
    @FXML
    private VBox vChoices;

    @FXML
    private TextArea txtContent;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategoryServices s = new CategoryServices();
        QuestionServices s2 = new QuestionServices();
        LevelServices lvlService = new LevelServices();

        this.loadColumns();
        try {
            this.cbCates.setItems(FXCollections.observableList(Configs.cateService.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(Configs.levelService.getLevels()));
            this.tvQuestions.setItems(FXCollections.observableList(Configs.questionService.getQuestions()));
        } catch (SQLException ex) {
            // Logger.getLogger(QuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadColumns() {
        TableColumn colId = new TableColumn("Id");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colId.setPrefWidth(100);

        TableColumn colContent = new TableColumn("Nội dung câu hỏi");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(300);

        this.tvQuestions.getColumns().addAll(colId, colContent);
    }

    public void addChoice(ActionEvent e) {
        HBox h = new HBox();
        h.getStyleClass().add("Container");

        RadioButton r = new RadioButton();
        TextField t = new TextField();

        t.getStyleClass().add("Input");

        h.getChildren().addAll(r, t);

        this.vChoices.getChildren().add(h);
    }

    public void addQuestion(ActionEvent e) {
        Question q = new Question.Builder().setContent(this.txtContent.getText())
                .setLevel(this.cbLevels.getSelectionModel()
                        .getSelectedItem()).setCategory(this.cbCates.getSelectionModel()
                        .getSelectedItem()).build();
        
        List<Choice> choices = new ArrayList<>();
        for(var hbox : this.vChoices.getChildren()){
            HBox h =(HBox) hbox;
            
            RadioButton r = (RadioButton) h.getChildren().get(0);
            TextField t = (TextField) h.getChildren().get(1);
            
            choices.add(new Choice(t.getText(), r.isSelected()));
        }
        
        try {
            Configs.uQuestionServices.addQuestion(q, choices);
            MyAlertSingleton.getInstance().showMsg("them cau hoi thanh cong ");
        } catch (SQLException ex) {
            MyAlertSingleton.getInstance().showMsg("them cau hoi that bai, do" + ex.getMessage());
                    
        }
    }
}

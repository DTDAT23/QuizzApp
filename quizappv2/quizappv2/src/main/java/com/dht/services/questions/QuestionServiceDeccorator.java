/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services.questions;

import com.dht.pojo.Question;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionServiceDeccorator extends QuestionServiceBase {
    private QuestionServiceBase service;

    public QuestionServiceDeccorator(QuestionServiceBase service) {
        this.service = service;
    }
    
    
    
    @Override
    public List<Question> getQuestions() throws SQLException {
        List<Question> questions = this.service.getQuestions();
        
        ChoiceService ser = new ChoiceService();
        for(var q: questions){
            q.setChoices(ser.getChoicesByQuestionID(q.getId()));
        }
        
        return questions;
    }
    
}

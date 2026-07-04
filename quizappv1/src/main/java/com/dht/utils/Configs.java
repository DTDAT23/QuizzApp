/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.utils;

import com.dht.services.CategoryServices;
import com.dht.services.LevelServices;
import com.dht.services.questions.QuestionServices;
import com.dht.services.questions.updateQuestionServices;

/**
 *
 * @author admin
 */
public class Configs {
    public static final CategoryServices cateServices = new CategoryServices();
    public static final QuestionServices quesServices = new QuestionServices();
    public static final LevelServices levelServices = new LevelServices();
    public static final updateQuestionServices uQuesServices = new updateQuestionServices();
}

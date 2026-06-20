/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtd.utils.themes;

import com.dtd.quizzapp.quizzapp.App;

/**
 *
 * @author admin
 */
public class DEFAULTFACTORY extends ThemeAbstractFactory{

    @Override
    public String getStyleSheet() {
        return App.class.getResource("styles.css").toExternalForm();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtd.utils.themes;

import com.dtd.quizzapp.quizzapp.App;
import javafx.scene.Scene;

/**
 *
 * @author admin
 */
public class ThemesManager {
    private static ThemeAbstractFactory theme = new DEFAULTFACTORY();

    /**
     * @param aTheme the theme to set
     */
    public static void setTheme(ThemeAbstractFactory aTheme) {
        theme = aTheme;
    }
    
    public static void applyTheme(Scene scene){
        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(theme.getStyleSheet());
    }
}

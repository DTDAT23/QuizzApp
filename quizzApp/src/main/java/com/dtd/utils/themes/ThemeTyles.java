/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtd.utils.themes;

import javafx.scene.Scene;

/**
 *
 * @author admin
 */
public enum ThemeTyles {
    DARK {
        @Override
        public void updateTheme(Scene scene) {
            ThemesManager.setTheme(new DARKFACTORY());
            ThemesManager.applyTheme(scene);
        }
    }, LIGHT {
        @Override
        public void updateTheme(Scene scene) {
            ThemesManager.setTheme(new LIGHTFACTORY());
            ThemesManager.applyTheme(scene);
        }
    }, DEFAULT {
        @Override
        public void updateTheme(Scene scene) {
            ThemesManager.setTheme(new DEFAULTFACTORY());
            ThemesManager.applyTheme(scene);
        }
    };
    
    public abstract void updateTheme(Scene scence);
}

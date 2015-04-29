/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.objccompiler;

import org.itver.objccompiler.view.component.Menu;
import org.itver.objccompiler.view.component.MainPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import javax.swing.UnsupportedLookAndFeelException;
import org.itver.objccompiler.controller.Controller;

/**
 *
 * @author Adrián
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame f = new JFrame("Compilador de Objective-C");
        try {
            UIManager.setLookAndFeel(getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
        }
        MainPanel panel = new MainPanel();
        Menu menu = new Menu();
        Controller controller = new Controller(panel);
        menu.addEventos(controller);
        panel.initListeners(controller);

        f.setSize(1300, 700);
        f.setLocationRelativeTo(null);
        f.toFront();
//        f.setResizable(false);
        f.setDefaultCloseOperation(3);
        f.setJMenuBar(menu);
        f.setContentPane(panel);
        f.setVisible(true);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.objccompiler.view.component;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.itver.objccompilator.controller.Controller;

/**
 *
 * @author Adrián
 */
public class Menu extends JMenuBar {
    
    private JMenu jmMenuArchivo;
    private JMenuItem jmiAbrir;
    private JMenuItem jmiGuardar;
    
    private JMenu jmCompilar;
    private JMenuItem compilar;
    
    public Menu () {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addComponents();
    }
    
    private void addComponents() {
        jmMenuArchivo = new JMenu("Archivo");
        jmCompilar = new JMenu("Compilar");
        jmiAbrir = new JMenuItem("Abrir");
        jmiGuardar = new JMenuItem("Guardar");
        jmMenuArchivo.add(jmiAbrir);
        jmMenuArchivo.addSeparator();
        jmMenuArchivo.add(jmiGuardar);
        compilar = new JMenuItem("Compilar");
        jmCompilar.add(compilar);
        this.add(jmMenuArchivo);
        this.add(jmCompilar);
    }
    
    public void addEventos(Controller l) {
        jmiAbrir.addActionListener(l);
        jmiGuardar.addActionListener(l);
        compilar.addActionListener(l);
    }
    
}

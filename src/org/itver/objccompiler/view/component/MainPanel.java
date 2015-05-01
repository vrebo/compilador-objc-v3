/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.objccompiler.view.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.itver.componentlibrary.component.CodeEditor;
import org.itver.componentlibrary.component.OutputPane2;
import org.itver.objccompiler.controller.Controller;

/**
 *
 * @author Adrián
 */
public class MainPanel extends JPanel {

    private JButton jbCompilar;
    private JButton jbLimpiarArea;
    private CodeEditor codeEditor;
    private final OutputPane2 outputAnalisisLexico;
    private final OutputPane2 outputAnalisisSintactico;
    private final OutputPane2 outputAnalisisSemantico;

    public MainPanel() {
        outputAnalisisLexico        = new OutputPane2("Análisis Léxico");
        outputAnalisisSintactico    = new OutputPane2("Análisis Sintáctico");
        outputAnalisisSemantico     = new OutputPane2("Análisis Semántico");
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(getBackground(), 5));
        initComponents();
    }

    public void initListeners(Controller l) {
        jbCompilar.addActionListener(l);
        jbLimpiarArea.addActionListener(l);
        codeEditor.addKeyListener(l);
    }

    private void initComponents() {
        //Iniciar botones
        jbCompilar = new JButton("Compilar");
        jbCompilar.setEnabled(false);
        jbLimpiarArea = new JButton("Limpiar Area");

        //Creación de area de código
        Font fuente = new Font("Droid Sans", Font.PLAIN, 15);
        codeEditor = new CodeEditor();
        codeEditor.setSize(200, 200);
        codeEditor.setFont(fuente);
        codeEditor.setBackGround(Color.BLACK);
        codeEditor.setForeground(Color.GREEN);
        codeEditor.setCaretColor(Color.GREEN);

        JPanel pS = new JPanel();
        pS.add(jbCompilar);
        pS.add(new JLabel(""));
        pS.add(jbLimpiarArea);

        JPanel panelCentro = new JPanel();
        JLabel label = new JLabel("Código");
        label.setFont(new Font("arial", Font.BOLD, 15));
        panelCentro.setLayout(new BorderLayout());
        panelCentro.add(label, BorderLayout.NORTH);
        panelCentro.add(codeEditor, BorderLayout.CENTER);
        panelCentro.add(pS, BorderLayout.SOUTH);        
        
        //Resto de paneles
        JPanel panelSur = new JPanel();
        panelSur.setLayout(new BorderLayout());
        panelSur.setBorder(BorderFactory.createLineBorder(getBackground(), 5));
        panelSur.add(outputAnalisisSemantico, BorderLayout.EAST);
        panelSur.add(outputAnalisisSintactico, BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);
        add(outputAnalisisLexico, BorderLayout.EAST);
        add(panelSur, BorderLayout.SOUTH);
    }

    public void activarBoton(boolean estado) {
        jbCompilar.setEnabled(estado);
    }

    public OutputPane2 getOutputAnalisisLexico() {
        return outputAnalisisLexico;
    }

    public OutputPane2 getOutputAnalisisSintactico() {
        return outputAnalisisSintactico;
    }

    public OutputPane2 getOutputAnalisisSemantico() {
        return outputAnalisisSemantico;
    }

    public CodeEditor getCodeEditor() {
        return codeEditor;
    }

    public void setCodeEditor(CodeEditor codeEditor) {
        this.codeEditor = codeEditor;
    }

}
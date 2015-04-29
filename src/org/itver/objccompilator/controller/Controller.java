package org.itver.objccompilator.controller;

import org.itver.objccompilator.model.compilator.AnalizadorSemantico;
import org.itver.objccompilator.model.compilator.Compilador;
import org.itver.objccompilator.model.compilator.ParseException;
import org.itver.objccompiler.view.component.MainPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import org.itver.objccompilator.model.SourceCode;
import org.itver.util.FileUtilities;
import org.itver.util.Notification;

/**
 *
 * @author Adrián
 */
public class Controller extends KeyAdapter implements ActionListener {

    private final MainPanel panel;
    private SourceCode sourceCode;

    public Controller(MainPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        switch (accion) {
            case "Abrir":
                openSourceCodeFile();
                updateButtonState();
                break;
            case "Guardar":
                saveOnDisk();
                break;
            case "Compilar":
                if (sourceCode == null) {
                    saveOnDisk();
                } else {
                    if (sourceCode.isModified()) {
                        save();
                    }
                }
                compilar();
                break;
            case "Limpiar Area":
                limpiar();
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (sourceCode != null) {
            sourceCode.setModified(true);
        }
        updateButtonState();
    }

    private void updateButtonState() {
        if (!isEmpty()) {
            panel.activarBoton(true);
        } else {
            panel.activarBoton(false);
        }
    }

    private boolean isEmpty() {
        return panel.getCodeEditor().getCode().isEmpty();
    }

    private void limpiar() {
        panel.getCodeEditor().clearCode();
        panel.getOutputAnalisisLexico().clearOutput();
        panel.getOutputAnalisisSintactico().clearOutput();
        panel.getOutputAnalisisSemantico().clearOutput();
        updateButtonState();
    }

    private void saveOnDisk() {
        try {
            String texto = panel.getCodeEditor().getCode();
            JFileChooser chooser = new JFileChooser();
            int opcion = chooser.showSaveDialog(panel);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                sourceCode = new SourceCode(chooser.getSelectedFile());
                FileUtilities.writeToFile(sourceCode.getCodeFile(), texto);
                Notification.info(panel, "Archivo guardado exitosamente");
            }
        } catch (FileNotFoundException ex) {
            Notification.error(panel,
                    "Error al salvar el archivo: " + sourceCode.getCodeFile().getAbsolutePath());
            System.out.println(ex + "\n" + ex.getMessage());
        }
    }

    private void save() {
        try {
            String texto = panel.getCodeEditor().getCode();
            PrintWriter pw = new PrintWriter(sourceCode.getCodeFile());
            FileUtilities.writeToFile(sourceCode.getCodeFile(), texto);
            pw.write(texto);
            pw.flush();
        } catch (FileNotFoundException ex) {
            Notification.error(panel,
                    "Error al salvar el archivo: " + sourceCode.getCodeFile().getAbsolutePath());
            System.err.println("Problema al guardar el código fuente.");
        }
    }

    private void openSourceCodeFile() {
        JFileChooser selectorDeArchivos = new JFileChooser();
        String codigoTexto;
        try {
            int opcion = selectorDeArchivos.showOpenDialog(panel);
            if (opcion == JFileChooser.APPROVE_OPTION) {
                sourceCode = new SourceCode(selectorDeArchivos.getSelectedFile());
                codigoTexto = FileUtilities.readFile(sourceCode.getCodeFile().getAbsolutePath());
                panel.getCodeEditor().setCode(codigoTexto);
            }
        } catch (IOException ex) {
            Notification.error(panel,
                    "Error al abrir el archivo: " + sourceCode.getCodeFile().getAbsolutePath());
            System.out.println(ex + "\n" + ex.getMessage());
        }
    }

    private void compilar() {
        if (sourceCode == null) {
            return;
        }
        try {
            Compilador compilador = new Compilador(sourceCode.getCodeFile());
            Compilador.initLogs();
            compilador.unidadCompilacion();
            AnalizadorSemantico analizadorSemantico = new AnalizadorSemantico(panel.getCodeEditor().getCode());
            analizadorSemantico.ejecutarAnalisisSemantico();

            String analisisLexico = Compilador.getLogAnalisisLexico().toString();
            String analisisSintactico = Compilador.getLogAnalisisSintactico().toString();
            String analisisSemantico = analizadorSemantico.getLogAnalisisSemantico().toString();

            panel.getOutputAnalisisLexico().appendInfoMessage(analisisLexico);
            panel.getOutputAnalisisSintactico().appendInfoMessage(analisisSintactico);
            panel.getOutputAnalisisSemantico().appendInfoMessage(analisisSemantico);

        } catch (FileNotFoundException | ParseException ex) {
            Notification.error(panel,
                    "Error al parsear el código fuente: " + ex.getMessage());
            System.err.println("Tu código produce excepciones de parseo");
        }
    }

}

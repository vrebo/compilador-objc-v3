package org.itver.objccompiler.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Adrián
 */
public class Funcion {

    private String tipo;
    private String identificador;
    private ArrayList<Identificador> argumentos;
    private HashMap<String, Identificador> variablesLocales;
    private boolean definida;

    public Funcion(String tipo, String identificador) {
        this.tipo = tipo;
        this.identificador = identificador;
        argumentos = new ArrayList();
        variablesLocales = new HashMap<>();
        definida = false;
    }

    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the declarada
     */
    public boolean isDefinida() {
        return definida;
    }

    /**
     * @param declarada the declarada to set
     */
    public void setDefinida(boolean declarada) {
        this.definida = declarada;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the variablesLocales
     */
    public HashMap<String, Identificador> getVariablesLocales() {
        return variablesLocales;
    }

    /**
     * @param variablesLocales the variablesLocales to set
     */
    public void setVariablesLocales(HashMap<String, Identificador> variablesLocales) {
        this.variablesLocales = variablesLocales;
    }

    /**
     * @return the argumentos
     */
    public ArrayList<Identificador> getArgumentos() {
        return argumentos;
    }

    /**
     * @param argumentos the argumentos to set
     */
    public void setArgumentos(ArrayList<Identificador> argumentos) {
        this.argumentos = argumentos;
    }

}

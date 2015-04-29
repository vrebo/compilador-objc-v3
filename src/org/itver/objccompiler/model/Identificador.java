/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.objccompiler.model;

/**
 *
 * @author Adrián
 */
public class Identificador {
    
    private final String tipo;
    private final String id;
    
    public Identificador(String tipo, String id) {
        this.id = id;
        this.tipo = tipo;
    }
    
    public String getId() {
        return id;
    }
    
    public String getTipo() {
        return tipo;
        
    }
    
}

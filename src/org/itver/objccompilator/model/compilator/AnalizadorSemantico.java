/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itver.objccompilator.model.compilator;

import org.itver.objccompilator.model.Identificador;
import org.itver.objccompilator.model.Funcion;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Adrián
 */
public class AnalizadorSemantico {

    private final ArrayList<String> tiposDatos;
    private final ArrayList<String> operadores;
    private String codigo;
    private StringBuilder logAnalisisSemantico;

    public AnalizadorSemantico(String codigo) {
        tiposDatos = getTiposDatos();
        operadores = getOperadores();
        this.codigo = codigo;
    }

    public void ejecutarAnalisisSemantico() {
        HashMap<String, Identificador> variables = new HashMap();
        HashMap<String, Funcion> funciones = new HashMap();
        logAnalisisSemantico = new StringBuilder();
        int fin, finDefinicion, finArgumentos, inicioArgumentos;
        ArrayList<Identificador> argumentos;
        HashMap<String, Identificador> variablesLocales;
        procesarCodigo();
        String[] tokens = codigo.split("[ ]+");
        for (int i = 0; i < tokens.length; i++) {
            if (tiposDatos.contains(tokens[i].trim())) {
                String tipo = tokens[i].trim();
                if (esFuncion(i, tokens)) {
                    String nombreFuncion = tokens[i + 1];
                    argumentos = new ArrayList();
                    inicioArgumentos = i + 2;
                    finArgumentos = encontrarFinArgumentosFuncion(i, tokens);
                    if (esDefinicionFuncion(finArgumentos, tokens)) {
                        System.out.println("Definicion Funcion");
                        variablesLocales = new HashMap<>();
                        finDefinicion = encontrarFinDefinicionFuncion(finArgumentos + 1, tokens);
                        agregarArgumentos(inicioArgumentos, finArgumentos, tokens, argumentos);
                        for (int j = finArgumentos; j < finDefinicion; j++) {
                            if (tiposDatos.contains(tokens[j].trim())) {
                                agregarVariablesLocales(tokens, j, variablesLocales, argumentos, logAnalisisSemantico, logAnalisisSemantico);
                            }
                        }
                        Funcion funcion = new Funcion(tipo, nombreFuncion);
                        funcion.setDefinida(true);
                        funcion.setArgumentos(argumentos);
                        funcion.setVariablesLocales(variablesLocales);
                        ArrayList<Identificador> aux = funcion.getArgumentos();
                        String args = "";
                        args = getArgs(aux, args);
                        if (!funciones.containsKey(funcion.getIdentificador())) {
                            System.out.println("Funcion " + funcion.getIdentificador()
                                    + " agregada con parámetros " + args);
                            logAnalisisSemantico.append("Funcion "
                                    + "").append(funcion.getIdentificador()).append(" agregada con parámetros ").append(args).append("\n");
                            funciones.put(funcion.getIdentificador(), funcion);
                        } else {
                            ArrayList<Identificador> aux2
                                    = funciones.get(funcion.getIdentificador()).getArgumentos();
                            String args2 = "";
                            args2 = getArgs(aux2, args2);
                            if (!args.equals(args2)) {
                                System.out.println("Funcion " + funcion.getIdentificador()
                                        + " agregada con parámetros " + args);
                                logAnalisisSemantico.append("Funcion ").append(funcion.getIdentificador()).append(" agregada con parámetros ").append(args).append("\n");
                                funciones.put(funcion.getIdentificador(), funcion);
                            } else if (!funciones.get(funcion.getIdentificador()).isDefinida()) {
                                funciones.get(funcion.getIdentificador()).setDefinida(true);
                                System.out.println("Funcion definida (previamente declarada) "
                                        + funcion.getIdentificador()
                                        + " agregada con parámetros " + args);
                                logAnalisisSemantico.append("Funcion definida (previamente declarada) ").append(funcion.getIdentificador()).append(" agregada con parámetros ").append(args).append("\n");
                                funciones.put(funcion.getIdentificador(), funcion);
                            } else {
                                logAnalisisSemantico.append("Funcion ").append(funcion.getIdentificador()).append(" ya existente con argumentos ").append(args).append("\n");
                            }
                        }
                        i = finDefinicion;
                    } else {
                        boolean flag = false;
                        System.out.println("Declaracion Funcion");
                        agregarArgumentos(inicioArgumentos, finArgumentos, tokens, argumentos);
                        Funcion funcion = new Funcion(tipo, nombreFuncion);
                        funcion.setArgumentos(argumentos);
                        funcion.setVariablesLocales(new HashMap<>());
                        funcion.setDefinida(false);
                        ArrayList<Identificador> aux = funcion.getArgumentos();
                        String args = "";
                        args = getArgs(aux, args);
                        if (!funciones.containsKey(funcion.getIdentificador())) {
                            System.out.println("Funcion " + funcion.getIdentificador()
                                    + " agregada con parámetros " + args);
                            logAnalisisSemantico.append("Funcion ").append(funcion.getIdentificador()).append(" agregada con parámetros ").append(args).append("\n");
                            funciones.put(funcion.getIdentificador(), funcion);
                            flag = true;
                        } else {
                            ArrayList<Identificador> aux2
                                    = funciones.get(funcion.getIdentificador()).getArgumentos();
                            String args2 = "";
                            args2 = getArgs(aux2, args2);
                            if (!args.equals(args2)) {
                                System.out.println("Funcion " + funcion.getIdentificador()
                                        + " agregada con parámetros " + args);
                                logAnalisisSemantico.append("Funcion ").append(funcion.getIdentificador()).append(" agregada con parámetros ").append(args).append("\n");
                                funciones.put(funcion.getIdentificador(), funcion);
                                flag = true;
                            }
                        }
                        if (!flag) {
                            logAnalisisSemantico.append("Funcion ").append(funcion.getIdentificador()).append(" ya existente con parametros ").append(args).append("\n");
                        }
                        i = finArgumentos;
                    }
                } else {
                    System.out.println("Variables");
                    boolean bandera = true;
                    fin = encontrarFinDeclaracionesVariables(i, tokens);
                    for (int j = i; j < fin; j++) {
                        if (tokens[j].trim().equals(",")) {
                            bandera = true;
                        }
                        if (bandera) {
                            String identificador = tokens[j + 1].trim();
                            Identificador id = new Identificador(tipo, identificador);
                            if (!variables.containsKey(id.getId())) {
                                System.out.println("Variable " + id.getId()
                                        + " de tipo " + id.getTipo() + " agregada");
                                logAnalisisSemantico.append("Variable ").append(id.getId()).append(" de tipo ").append(id.getTipo()).append(" agregada").append("\n");
                                variables.put(identificador, id);
                            } else {
                                System.out.println("Variable " + id.getId()
                                        + " ya contenida de tipo " + variables.get(id.getId()).getTipo());
                                logAnalisisSemantico.append("Variable ").append(id.getId()).append(" ya contenida de tipo ").append(variables.get(id.getId()).getTipo()).append("\n");
                            }
                            bandera = false;
                        }
                    }
                    i = fin;
                }
            }
        }
    }

    private String getArgs(ArrayList<Identificador> aux, String args) {
        StringBuilder sb = new StringBuilder();
        int tamanio = aux.size();
        if (tamanio != 0) {
            for (int i = 0; i < aux.size() - 1; i++) {
                sb.append(aux.get(i).getTipo()).append(", ");
            }
            sb.append(aux.get(tamanio - 1).getTipo());
        }

        args = aux.stream().map((aux1) -> aux1.getTipo()).reduce(args, String::concat);
        return sb.toString();
    }

    private void agregarVariablesLocales(String[] tokens, int j,
            HashMap<String, Identificador> variablesLocales, ArrayList<Identificador> argumentos,
            StringBuilder aceptados, StringBuilder errores) {
        int fin;
        String tipoLocal = tokens[j].trim();
        boolean bandera = true;
        fin = encontrarFinDeclaracionesVariables(j, tokens);
        for (int k = j; k < fin; k++) {
            if (tokens[k].trim().equals(",")) {
                bandera = true;
            }
            if (bandera) {
                String identificador = tokens[k + 1].trim();
                Identificador id = new Identificador(tipoLocal, identificador);
                boolean contenido = false;
                for (Identificador argumento : argumentos) {
                    if (argumento.getId().equals(id.getId())) {
                        contenido = true;
                    }
                }
                if (!variablesLocales.containsKey(id.getId()) && !contenido) {
                    System.out.println("Variable Local " + id.getId()
                            + " de tipo " + id.getTipo() + " agregada");
                    aceptados.append("Variable Local ").append(id.getId()).append(" de tipo ").append(id.getTipo()).append(" agregada").append("\n");
                    variablesLocales.put(identificador, id);
                } else {
                    System.out.println("Variable Local " + id.getId()
                            + " ya contenida");
                    errores.append("Variable Local ").append(id.getId()).append(" ya contenida").append("\n");
                }
                bandera = false;
            }
        }
    }

    private void agregarArgumentos(int inicioArgumentos, int finArgumentos,
            String[] tokens, ArrayList<Identificador> argumentos) {
        for (int j = inicioArgumentos; j < finArgumentos; j++) {
            if (tiposDatos.contains(tokens[j].trim())) {
                String tipo = tokens[j];
                String identificador = tokens[j + 1];
                Identificador id = new Identificador(tipo, identificador);
                System.out.println("Parámetro " + id.getId()
                        + " de tipo " + id.getTipo() + " agregado");
                argumentos.add(id);
            }
        }
    }

    private int encontrarFinDeclaracionesVariables(int indice, String[] tokens) {
        for (int i = indice; i < tokens.length; i++) {
            if (tokens[i].trim().equals(";")) {
                return i;
            }
        }
        return 0;
    }

    private int encontrarFinDefinicionFuncion(int index, String[] tokens) {
        for (int i = index; i < tokens.length; i++) {
            if (tokens[i].trim().equals("}")) {
                return i;
            }
        }
        return 0;
    }

    private int encontrarFinArgumentosFuncion(int index, String[] tokens) {
        for (int i = index; i < tokens.length; i++) {
            if (tokens[i].trim().equals(")")) {
                return i;
            }
        }
        return 0;
    }

    private boolean esDefinicionFuncion(int index, String[] tokens) {
        return tokens[index + 1].trim().equals("{");
    }

    private boolean esFuncion(int index, String[] tokens) {
        return tokens[index + 2].trim().equals("(");
    }

    private ArrayList<String> getTiposDatos() {
        ArrayList<String> array = new ArrayList();
        array.add("int");
        array.add("double");
        array.add("char");
        array.add("String");
        array.add("float");
        array.add("boolean");
        array.add("void");
        return array;
    }

    private void procesarCodigo() {
        codigo = codigo.replaceAll("\n", " ");
        codigo = codigo.replaceAll("\\(", " ( ");
        codigo = codigo.replaceAll("\\)", " ) ");
        codigo = codigo.replaceAll(",", " , ");
        codigo = codigo.replaceAll(";", " ;");
        codigo = codigo.replaceAll("\\{", " { ");
        codigo = codigo.replaceAll("\\}", " } ");
        operadores.stream().forEach((operadore) -> {
            codigo = codigo.replaceAll(operadore, " " + operadore + " ");
        });
    }

    private ArrayList<String> getOperadores() {
        ArrayList<String> array = new ArrayList();
        array.add("\\+");
        array.add("\\++");
        array.add("\\-");
        array.add("\\--");
        array.add("\\*");
        array.add("\\/");
        array.add("\\=");
        array.add("\\+=");
        array.add("\\-=");
        array.add("\\*=");
        array.add("\\/=");
        return array;
    }

    public StringBuilder getLogAnalisisSemantico() {
        return logAnalisisSemantico;
    }

}

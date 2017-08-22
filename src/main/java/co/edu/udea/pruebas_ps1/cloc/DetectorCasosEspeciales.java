/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.cloc;

import java.util.Stack;

/**
 * Clase responsable de detectar lineas de código que contienen dos o más
 * instrucciones
 *
 * @author Jhonatan Orozco Blandón
 * @date 2017/08/21
 * @version 1
 */
public class DetectorCasosEspeciales {

    /**
     * Método que se encarga de detectar si una línea de código continen
     * múltiple declariación de variables del mismo tipo
     *
     * @param linea
     * @return El número de instrucciones que contiene la línea.
     */
    public int detectarMultipleCreacionVariables(String linea) {
        int numeroCaracteres = linea.length();
        int instrucciones = 0;
        Stack<Character> pila = new Stack<>();
        for (int i = 0; i < numeroCaracteres; i++) {
            char caracter = linea.charAt(i);
            switch (caracter) {
                case '(':
                case '{':
                case '[':
                    pila.push(caracter);
                    break;
                case ')':
                case '}':
                case ']':
                    pila.pop();
                    break;
                case ',':
                case ';':
                    if (pila.isEmpty()) {
                        instrucciones++;
                    }
                    break;
            }
        }
        if (!pila.isEmpty()) {
            return 0;
        }
        return instrucciones;
    }

    
    /**
     * Método que detecta si se trata de una línea con la palabra reservada for 
     * y además, reconoce si alguna de las intrucciones del for se encuentra 
     * vacia. Se considera el for sin ninguna instrucción como una línea de 
     * código.
     * @param linea
     * @return El número de instrucciones de for
     */
    public int detectarInstruccionFor(String linea) {
        boolean existefor = linea.contains("for");
        int numeroCaracteres = linea.length();
        int instrucciones=0;
        String resultado = "";
        boolean bandera=false;
        if (existefor) {
            for (int i = 0; i < numeroCaracteres; i++) {
                char caracter = linea.charAt(i);
                switch (caracter) {
                    case '(':
                        bandera = true;
                        break;
                    case ')':
                        bandera=false;
                        break;
                    default:
                        if(bandera){
                            resultado=resultado.concat(String.valueOf(caracter));
                        }
                }
            }
            bandera=false;
            String[] partes=resultado.split(";");
            int numeroPartes=partes.length;
            for (int i = 0; i < numeroPartes; i++) {
                partes[i]=partes[i].replaceAll("\\s+","");
                if(!partes[i].isEmpty()){
                    instrucciones++;
                    bandera=true;
                }
            }
            if(!bandera){
                return 1;
            }
        }
        return instrucciones;

    }
}

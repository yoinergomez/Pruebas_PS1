/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.util.excepcion;

/**
 * Es la clase encargada demanejar los errores concernientes a las reglas del
 * negocio
 * @author Jhonatan Orozco Blandón
 * @date 2017/08/21
 * @version 1
 */
public class ValidacionPS1 extends Exception{

    /**
     * Constructor de la clase.
     * @param arg0 El mensaje asociado a la excepción.
     */
    public ValidacionPS1(String arg0) {
        super(arg0);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.comprobar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jhonatan Orozco Blandón
 * @date 2017/08/21
 * @version 1
 */
public class DetectorCasosEspecialesTest {
    
     private DetectorCasosEspeciales detector;

    @Before
    public void inicializar() {
        detector = new DetectorCasosEspeciales();
    }
    
    /**
     * Prueba de una línea de código con mútiple declaración de variables cada
     * una separada por comas.
     */
    @Test
    public void testDetectarMultipleCreacionVariables(){
        String linea="int x,y,z;";
        int numeroInstrucciones=detector.detectarMultipleCreacionVariables(linea);
        assertEquals(3,numeroInstrucciones );
    }
    
    
    /**
     * Prueba de una línea de código que inicializa una variable por medio de 
     * un método que contiene más de un parámetro 
     */
    @Test
    public void testComaEntreParentesis(){
        String linea="int x= Integer.sum(5,10);";
        int numeroInstrucciones=detector.detectarMultipleCreacionVariables(linea);
        assertEquals(1,numeroInstrucciones );
    }
    
    /**
     * Prueba de una línea de código con declaración de variables del mismo tipo
     * pero con diferente inicialización.
     */
    @Test
    public void testDInicializacionDeDistintoTipo(){
        String linea="int x= Integer.sum(5,10), y=6;";
        int numeroInstrucciones=detector.detectarMultipleCreacionVariables(linea);
        assertEquals(2,numeroInstrucciones );
    }
    
    /**
     * Prueba con una línea de código que incializa un vector por medio de llaves.
     */
    @Test
    public void testInicializacionConLLaves(){
        String linea="int[] a={1,2},b=new int[]{},c={3,4,5};";
        int numeroInstrucciones=detector.detectarMultipleCreacionVariables(linea);
        assertEquals(3,numeroInstrucciones);
    }
    
    
    
}

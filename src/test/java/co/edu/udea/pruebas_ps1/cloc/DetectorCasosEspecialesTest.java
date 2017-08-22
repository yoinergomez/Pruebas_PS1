/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.cloc;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase que contienen los casos de prueba para DectectorCasosEspeciales
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
    
    
    /**
     * Prueba con una línea de código distinta a la declaración de variables. En
     * este caso en particular se prueba con la definición de un método. Se espera
     * que retorne cero, ya que ese tipo de línea no le compete.
     */
    @Test
    public void testLineaDistintaADeclaracionVariables(){
         String linea="public void escribirResultadosClaseLOC"
                 + "(Sheet s, ClaseLOC clase, int numeroFilas)\n" +
"            throws FileNotFoundException, IOException, URISyntaxException {;";
        int numeroInstrucciones=detector.detectarMultipleCreacionVariables(linea);
        assertEquals(0,numeroInstrucciones);
    }
    
    /**
     * Prueba con una línea de código que tiene un for.
     */
    @Test
    public void testDetectarInstruccionFor(){
        String linea="for(int i=0;i<3;i++){";
        int numeroInstrucciones=detector.detectarInstruccionFor(linea);
        assertEquals(3,numeroInstrucciones);
    }
    
    /**
     * Prueba con una línea de código que tiene un for sin la inicialización de 
     * la varable controladora.
     */
    @Test
    public void testForSinInicializacion(){
        String linea="for(  ;i<3;i++){";
        int numeroInstrucciones=detector.detectarInstruccionFor(linea);
        assertEquals(2,numeroInstrucciones);
    }
    
    /**
     * Prueba con una línea de código que tiene un for sin el incremento de 
     * la varable controladora.
     */
    @Test
    public void testForSinIncremento(){
        String linea="for( int i=0 ;i<3;  ){";
        int numeroInstrucciones=detector.detectarInstruccionFor(linea);
        assertEquals(2,numeroInstrucciones);
    }
    
    /**
     * Prueba con una línea de código que tiene un for con solomante la condición
     * de parada del ciclo.
     */
    @Test
    public void testForConSoloElCondicional(){
        String linea="for( ;i<10 ; ){";
        int numeroInstrucciones=detector.detectarInstruccionFor(linea);
        assertEquals(1,numeroInstrucciones);
    }
    
    /**
     * Prueba con una línea de código que tiene un for sin instrucciones.
     */
    @Test
    public void testForSinInstrucciones(){
        String linea="for( ; ;){";
        int numeroInstrucciones=detector.detectarInstruccionFor(linea);
        assertEquals(1,numeroInstrucciones);
    }
    
}

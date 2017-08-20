/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.estadistica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Es la clase que contiene las pruebas unitarias para la clase Estadistica.java
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/19
 * @version v1
 */
public class EstadisticaTest {
    
    public EstadisticaTest() {
    }

    @Test
    public void testCrearConstructorVacio() {
        Estadistica estadistica = new Estadistica();
        assertEquals(estadistica.getNumeroLineas(), 0);
    }
    
    @Test
    public void testCrearConstructorConParametros() {
        Estadistica estadistica = new Estadistica("Ejemplo", 5, 5);
        assertEquals(estadistica.getNumeroMetodos(), 5);
    }
    
    @Test
    public void testComprobarSetMetodo() {
        Estadistica estadistica = new Estadistica();
        estadistica.setNumeroMetodos(10);
        assertEquals(estadistica.getNumeroMetodos(), 10);
    }
    
    @Test
    public void testComprobarSetLineasCodigo() {
        Estadistica estadistica = new Estadistica();
        estadistica.setNumeroLineas(10);
        assertEquals(estadistica.getNumeroLineas(), 10);
    }
    
    @Test
    public void testComprobarSetNombre() {
        Estadistica estadistica = new Estadistica();
        estadistica.setNombre("Ejemplo");
        assertEquals(estadistica.getNombre(), "Ejemplo");
    }
    
}

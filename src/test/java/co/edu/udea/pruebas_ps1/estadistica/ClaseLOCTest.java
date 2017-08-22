package co.edu.udea.pruebas_ps1.estadistica;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Es la clase que contiene las pruebas unitarias para la clase ClaseLOC.java
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/19
 * @version v1
 */
public class ClaseLOCTest {
    
    public ClaseLOCTest() {
    }

    @Test
    public void testCrearConstructorVacio() {
        ClaseLOC estadistica = new ClaseLOC();
        assertEquals(estadistica.getNumeroLineas(), 0);
    }
    
    @Test
    public void testCrearConstructorConParametros() {
        ClaseLOC estadistica = new ClaseLOC("Ejemplo", 5, 5);
        assertEquals(estadistica.getNumeroMetodos(), 5);
    }
    
    @Test
    public void testComprobarSetMetodo() {
        ClaseLOC estadistica = new ClaseLOC();
        estadistica.setNumeroMetodos(10);
        assertEquals(estadistica.getNumeroMetodos(), 10);
    }
    
    @Test
    public void testComprobarSetLineasCodigo() {
        ClaseLOC estadistica = new ClaseLOC();
        estadistica.setNumeroLineas(10);
        assertEquals(estadistica.getNumeroLineas(), 10);
    }
    
    @Test
    public void testComprobarSetNombre() {
        ClaseLOC estadistica = new ClaseLOC();
        estadistica.setNombre("Ejemplo");
        assertEquals(estadistica.getNombre(), "Ejemplo");
    }
    
}

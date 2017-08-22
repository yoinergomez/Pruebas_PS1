package co.edu.udea.pruebas_ps1.comprobar;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Es la clase que contiene las pruebas unitarias para la clase Analizar.java
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/19
 * @version v1
 */
public class AnalizarTest {
    Analizar instancia;
    
    public AnalizarTest() {
    }
    
    @Before
    public void setUp() {
        instancia = new Analizar();
    }

    @Test
    public void testComprobarClase() {
        assertTrue(instancia.comprobarClase("public class Ejemplo"));
    }
    
    @Test
    public void testComprobarClaseErronea() {
        assertFalse(instancia.comprobarClase("public static void Cuenta"));
    }
    
    @Test
    public void testComprobarClaseSinAlcance() {
        assertTrue(instancia.comprobarClase("class Cuenta"));
    }
    
    @Test
    public void testComprobarMetodo() {
        assertTrue(instancia.comprobarMetodo("public static void hacerAlgo(){"));
    }
    
    @Test
    public void testComprobarMetodoConEspacios() {
        assertTrue(instancia.comprobarMetodo("public static void "
                + "hacer(String tempo)   {"));
    }
    
    @Test
    public void testComprobarMetodoConThrows(){
        assertTrue(instancia.comprobarMetodo("public void writeList()"
                + "  throws IndexOutOfBoundsException, IOException   {"));
    }
    @Test
    public void testComprobarMetodoConMalThrows(){
        assertFalse(instancia.comprobarMetodo("public void writeList()"
                + "  throws IndexOutOfBoundsException, IOException   "));
    }
    
    
}

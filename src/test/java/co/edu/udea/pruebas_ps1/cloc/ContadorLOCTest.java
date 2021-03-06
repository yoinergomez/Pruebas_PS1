package co.edu.udea.pruebas_ps1.cloc;

import co.edu.udea.pruebas_ps1.modelo.ClaseLOC;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Es la clase que contiene las pruebas unitarias para la clase ContadorLOC.java
 *
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/19
 * @version v1
 */
public class ContadorLOCTest {

    ContadorLOC instancia;

    public ContadorLOCTest() {
    }

    @Before
    public void setUp() {
        instancia = new ContadorLOC();
    }
    
    /**
     *Pruebas para comprobar si una linea es el inicio de una clase (caso feliz)
     */
    @Test
    public void testComprobarInicioClase() {
        boolean resultado = instancia.esInicioClase("package "
                + "co.edu.udea.pruebas_ps1.cloc;");
        assertTrue(resultado);
    }
    
    /**
     *Pruebas para comprobar si una linea no es el inicio de una clase
     */
    @Test
    public void testComprobarInicioClaseErronea() {
        boolean resultado = instancia.esInicioClase("co.edu.udea.pruebas_ps1.cloc;");
        assertFalse(resultado);
    }
    
    /**
     * Pruebas para comprobar si una linea es una clase (caso feliz)
     */
    @Test
    public void testComprobarClase() {
        ClaseLOC loc = instancia.comprobarClase("public class Ejemplo");
        assertEquals("Ejemplo", loc.getNombre());
    }
    
    /**
     * Pruebas para comprobar si una linea no es una clase
     */
    @Test
    public void testComprobarClaseErronea() {
        ClaseLOC loc = instancia.comprobarClase("public static void Cuenta");
        assertEquals(null, loc);
    }

    /**
     * Prueba para comprobar una linea que es una clase pero no esta definido 
     * el alcance
     */
    @Test
    public void testComprobarClaseSinAlcance() {
        ClaseLOC loc = instancia.comprobarClase("class Cuenta");
        assertEquals("Cuenta", loc.getNombre());
    }
    
    /**
     * Comprobar cuando el nombre de una clase esta seguido de un abre corchete
     */
    @Test
    public void testComprobarClaseConCorchete() {
        ClaseLOC loc = instancia.comprobarClase("class Cuenta{");
        assertEquals("Cuenta", loc.getNombre());
    }
    
    /**
     * Comprobar que el método guarde el número de lineas cuando detecta que 
     * es una clase
     */
    @Test
    public void testComprobarNumeroLineasClase() {
        ClaseLOC loc = instancia.comprobarClase("class Otro");
        assertEquals(1, loc.getNumeroLineas());
    }
    
    /**
     * Comprueba si una linea es un método (caso feliz)
     */
    @Test
    public void testComprobarMetodo() {
        assertTrue(instancia.comprobarMetodo("public static void hacerAlgo(){"));
    }
    
    /**
     * Comprueba un método cuando hay espacios después del cierre del argumento
     */
    @Test
    public void testComprobarMetodoConEspacios() {
        assertTrue(instancia.comprobarMetodo("public static void "
                + "hacer(String tempo)   {"));
    }
    
    /**
     * Comprueba un método que tiene throws
     */
    @Test
    public void testComprobarMetodoConThrows() {
        assertTrue(instancia.comprobarMetodo("public void writeList()"
                + "  throws IndexOutOfBoundsException, IOException   {"));
    }

    /**
     * Comprueba un método contruido erroneamente
     */
    @Test
    public void testComprobarMetodoConMalThrows() {
        assertFalse(instancia.comprobarMetodo("public void writeList()"
                + "  throws IndexOutOfBoundsException, IOException   "));
    }

    /**
     * Prueba para ignorar un comentario simple del método 'cargarInstruccion'
     */
    @Test
    public void testIgnorarComentario() {
        final String LINEA = "       // Esto es un comentario";
        String linea = instancia.cargarInstruccion(LINEA);
        assertNull(linea);
    }
    
    /**
     * Prueba para ignorar un bloque de comentario del método 'cargarInstruccion'
     */
    @Test
    public void testIgnorarBloqueComentario() {
        final String LINEA = "       /* Esto es un comentario";
        final String LINEA2 = "      *  ";
        final String LINEA3 = "      */ ";
        String linea = instancia.cargarInstruccion(LINEA);
        String linea2 = instancia.cargarInstruccion(LINEA2);
        String linea3 = instancia.cargarInstruccion(LINEA3);
 
        assertTrue(linea==null && linea2==null && linea3==null);
    }
    
    /**
     * Prueba para ignorar una línea con espacios en blanco
     */
    @Test
    public void testIgnorarLineaEspacios() {
        final String LINEA = "  ";
        String linea = instancia.cargarInstruccion(LINEA);
        assertNull(linea);
    }
    
    /**
     * Prueba para ignorar una línea vacia
     */
    @Test
    public void testIgnorarLineaVacia() {
        final String LINEA = "";
        String linea = instancia.cargarInstruccion(LINEA);
        assertNull(linea);
    }
    
    /**
     * Prueba para ignorar un cierre de instrucción, es decir, ignora
     * el cierre de una función o clase '}'
     */
    @Test
    public void testIgnorarCierreInstruccion() {
        final String LINEA = "\t } ";
        String linea = instancia.cargarInstruccion(LINEA);
        assertNull(linea);
    }
    
    /**
     * Prueba para ignorar un cierre de instrucción con una sentencia
     * seguida después del cierre
     */
    @Test
    public void testIgnorarCierreInstruccionConSentencia() {
        final String LINEA = "\t } int a;";
        String linea = instancia.cargarInstruccion(LINEA);
        assertNull(linea);
    }
    
    /**
     * Prueba para retornar una anotacion
     */
    @Test
    public void testRetornarAnotacion() {
        final String LINEA = "\t @Test";
        String linea = instancia.cargarInstruccion(LINEA);
        assertEquals("@Test", linea);
    }
    
    /**
     * Prueba para retornar una declaración de una función o clase
     */
    @Test
    public void testRetornarAperturaSimple() {
        final String LINEA = "\t\t public void testRetornarAperturaSimple() {\t";
        String linea = instancia.cargarInstruccion(LINEA);
        assertEquals("public void testRetornarAperturaSimple() {", linea);
    }
    
    /**
     * Prueba para retornar una declaración de una función o clase
     * definida en múltiples líneas
     */
    @Test
    public void testRetornarAperturaMultilinea() {
        final String LINEA = "public void testRetornarAperturaSimple()throws"
                + " FileNotFoundException,ValidacionPS0, URISyntaxException {";
        String lineas[] = {"\t\t public void testRetornarAperturaSimple() \t",
            "\t throws FileNotFoundException,",
            " ValidacionPS0, URISyntaxException {"
        };
        String res1 = instancia.cargarInstruccion(lineas[0]);
        String res2 = instancia.cargarInstruccion(lineas[1]);
        String res3 = instancia.cargarInstruccion(lineas[2]);

        assertTrue(res1.equals("...") && res2.equals("...") && res3.equals(LINEA));
    }
    
    /**
     * Prueba para retornar una declaración de un arreglo
     * definida en múltiples líneas
     */
    @Test
    public void testRetornarDeclaracionArreglo() {
        final String LINEA = "String[ ] nombre = {\"María\",\"Gerson\"};";
        String lineas[] = {"\t\t String[ ] nombre = { \t",
            "\t \"María\",",
            " \"Gerson\"};"
        };
        String res1 = instancia.cargarInstruccion(lineas[0]);
        String res2 = instancia.cargarInstruccion(lineas[1]);
        String res3 = instancia.cargarInstruccion(lineas[2]);
    
        assertTrue(res1.equals("...") && res2.equals("...") && res3.equals(LINEA));
    }

}

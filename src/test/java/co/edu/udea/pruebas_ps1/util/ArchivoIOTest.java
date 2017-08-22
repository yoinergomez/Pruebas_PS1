/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.util;

import co.edu.udea.pruebas_ps1.util.excepcion.ValidacionPS1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.SystemUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pc1
 */
public class ArchivoIOTest {

    private ArchivoIO archivoIO;

    @Before
    public void inicializar() {
        archivoIO = new ArchivoIO();
    }

    /**
     * Método para obtener el la ruta de recurso que se quiere encontrar,
     * dependiendo del sistema operativo donde se despliegue el programa.
     *
     * @param nombreRecurso El nombre del recurso
     * @return La ruta modificada de acuerdo al sistem operativo
     * @throws URISyntaxException
     */
    public String corregirPath(String nombreRecurso) throws URISyntaxException {
        String ruta = this.getClass().getClassLoader().getResource(nombreRecurso)
                .toURI().toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            return ruta.substring(6);
        }
        return ruta.substring(5);
    }

    /**
     * Prueba para abrir un archivo existente.
     *
     * @throws URISyntaxException
     * @throws FileNotFoundException
     * @throws ValidacionPS1
     */
    @Test
    public void testArchivoExistente() throws URISyntaxException,
            FileNotFoundException, ValidacionPS1 {
        String ruta = corregirPath("prueba.txt");
        File f = archivoIO.encontrarArchivo(ruta);
        assertTrue(f.exists());
    }

    /**
     * Prueba para abrir un archivo inexistente.
     *
     * @throws ValidacionPS1
     * @throws URISyntaxException
     * @throws FileNotFoundException
     */
    @Test(expected = FileNotFoundException.class)
    public void testArchivoInexistente() throws
            ValidacionPS1, URISyntaxException, FileNotFoundException {
        String ruta = "esteArchivoNoExiste.xls";
        File f = archivoIO.encontrarArchivo(ruta);
    }

    /**
     * Prueba para abrir un archivo con la extensión .txt
     *
     * @throws FileNotFoundException
     * @throws ValidacionPS1
     * @throws URISyntaxException
     */
    @Test
    public void testAbrirArchivotxt() throws FileNotFoundException,
            ValidacionPS1, URISyntaxException {
        String ruta = corregirPath("prueba.txt");
        File f = archivoIO.encontrarArchivo(ruta);
        String ext = FilenameUtils.getExtension(f.getName());
        assertArrayEquals("txt".toCharArray(), ext.toCharArray());
    }

    /**
     * Prueba para abrir un archivo distinto a .txt. Se espera una excepción
     * cuando esto ocurra.
     *
     * @throws FileNotFoundException
     * @throws ValidacionPS1
     * @throws java.net.URISyntaxException
     */
    @Test(expected = ValidacionPS1.class)
    public void testAbrirArchivoDistintotAtxt() throws FileNotFoundException,
            ValidacionPS1, URISyntaxException {
        String ruta = corregirPath("prueba.docx");
        archivoIO.encontrarArchivo(ruta);
    }

    /**
     * Prueba para leer laprimera línea del archivo
     * @throws URISyntaxException
     * @throws ValidacionPS1
     * @throws IOException 
     */
    @Test
    public void testLeerPrimeraLinea() throws URISyntaxException,
            ValidacionPS1, IOException {
        String ejemplo = "Primera linea";
        String ruta = corregirPath("archivoConUnaLinea.txt");
        String resultado = archivoIO.leerArchivo(ruta);
        assertArrayEquals(ejemplo.toCharArray(), resultado.toCharArray());

    }
    
    /**
     * Prueba para leer un archivo que tiene múltiples lineas
     * @throws URISyntaxException
     * @throws ValidacionPS1
     * @throws IOException 
     */
    @Test
    public void testLeerMultiplesLineas() throws URISyntaxException, 
            ValidacionPS1,IOException{
        String ejemplo = "Primera linea-Segunda linea-Tercera linea";
        String ruta = corregirPath("archivoConMultiplesLineas.txt");
        String resultado = archivoIO.leerArchivo(ruta);
        assertArrayEquals(ejemplo.toCharArray(), resultado.toCharArray());   
    }
    
    /**
     * Prueba para leer un archivo que tiene múltiples líneas ycon la inclusión
     * de líneas en blanco.Se espera con esta prueba que el programa omita las 
     * lineas en blanco.
     * @throws URISyntaxException
     * @throws ValidacionPS1
     * @throws IOException 
     */
    @Test
    public void testLeerDatosConLineasEnBlanco() throws URISyntaxException, 
            ValidacionPS1,IOException{
        String ejemplo = "Primera linea-Segunda linea-Tercera linea";
        String ruta = corregirPath("archivoConMultiplesLineas.txt");
        String resultado = archivoIO.leerArchivo(ruta);
        assertArrayEquals(ejemplo.toCharArray(), resultado.toCharArray());   
    }

    
    /**
     * Prueba para ignorar un comentario simple del método 'cargarInstruccion' 
     *
     * @author Yoiner Gómez - yoiner.gomez22@gmail.com
     * @date 2017/08/11
     * @version v1
     */
    @Test
    public void testIgnorarLineaComentario() {
        final String LINEA = "// Esto es un comentario";
        archivoIO.cargarInstruccion(LINEA);
        
        
    }
}

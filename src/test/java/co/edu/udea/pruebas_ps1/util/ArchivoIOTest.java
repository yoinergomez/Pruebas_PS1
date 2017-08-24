/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.util;

import co.edu.udea.pruebas_ps1.modelo.ClaseLOC;
import co.edu.udea.pruebas_ps1.util.excepcion.ValidacionPS1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.SystemUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase que contienen los casos de prueba para ArchivoIO
 * @author Jhonatan Orozco Blandón
 * @date 2017/21/08
 * @version 1
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
     * Prueba para leer la primera línea del archivo
     *
     * @throws URISyntaxException
     * @throws ValidacionPS1
     * @throws IOException
     */
//    @Test
//    public void testLeerPrimeraLinea() throws URISyntaxException,
//            ValidacionPS1, IOException {
//        String ruta = corregirPath("archivoConUnaClase.txt");
//        ArrayList<ClaseLOC> resultado = archivoIO.leerArchivo(ruta);
//        assertEquals(4, resultado.get(0).getNumeroLineas());
//
//    }

    /**
     * Prueba para leer clase con métodos
     *
     * @throws URISyntaxException
     * @throws ValidacionPS1
     * @throws IOException
     */
    @Test
    public void testLeerClaseConMetodos() throws URISyntaxException,
            ValidacionPS1, IOException {
        String ruta = corregirPath("claseConMetodos.txt");
        ArrayList<ClaseLOC> resultado = archivoIO.leerArchivo(ruta);
        assertEquals(1, resultado.get(0).getNumeroMetodos());
    }

    /**
     * Prueba para leer un archivo que tiene múltiples líneas ycon la inclusión
     * de líneas en blanco.Se espera con esta prueba que el programa omita las
     * lineas en blanco.
     *
     * @throws URISyntaxException
     * @throws ValidacionPS1
     * @throws IOException
     */
//    @Test
//    public void testLeerDatosConLineasEnBlanco() throws URISyntaxException,
//            ValidacionPS1, IOException {
//        String ejemplo = "Primera linea-Segunda linea-Tercera linea";
//        String ruta = corregirPath("archivoConMultiplesLineas.txt");
//        String resultado = archivoIO.leerArchivo(ruta);
//        assertArrayEquals(ejemplo.toCharArray(), resultado.toCharArray());
//    }

    /**
     * Prueba para escribir el LOC de una clase en el archivo de Excel
     * @throws IOException
     * @throws FileNotFoundException
     * @throws URISyntaxException 
     */
    @Test
    public void testEscribirClaseLOCEnExcel() throws IOException,
            FileNotFoundException, URISyntaxException {
        ClaseLOC clase = new ClaseLOC();
        clase.setNombre("Clase A");
        clase.setNumeroMetodos(2);
        clase.setNumeroLineas(20);
        ArrayList<ClaseLOC> clases = new ArrayList();
        clases.add(clase);
        File f = archivoIO.escribirResultadosPrograma(clases);
        assertTrue(f.exists());
    }
    
    /**
     * Prueba para escribir el LOC de múltiples clases en el archivo de excel.
     * @throws IOException
     * @throws FileNotFoundException
     * @throws URISyntaxException 
     */
    @Test
    public void testEscribirResultadosProgramaLOC() throws IOException,
            FileNotFoundException, URISyntaxException {
        ClaseLOC clase = new ClaseLOC();
        ArrayList<ClaseLOC> clases = new ArrayList();
        clase.setNombre("Clase A");
        clase.setNumeroMetodos(2);
        clase.setNumeroLineas(23);
        clases.add(clase);

        clase = new ClaseLOC();
        clase.setNombre("Clase B");
        clase.setNumeroMetodos(4);
        clase.setNumeroLineas(38);
        clases.add(clase);
        
        clase = new ClaseLOC();
        clase.setNombre("Clase C");
        clase.setNumeroMetodos(3);
        clase.setNumeroLineas(44);
        clases.add(clase);
        
        File f = archivoIO.escribirResultadosPrograma(clases);
        assertTrue(f.exists());
    }

}

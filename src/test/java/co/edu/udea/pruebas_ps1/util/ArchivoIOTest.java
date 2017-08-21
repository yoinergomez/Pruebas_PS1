/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.util;

import co.edu.udea.pruebas_ps1.util.excepcion.ValidacionPS1;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import org.apache.commons.lang.SystemUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
     * @param nombreRecurso El nombre del recurso
     * @return La ruta modificada de acuerdo al sistem operativo
     * @throws URISyntaxException 
     */
    public String corregirPath(String nombreRecurso) throws URISyntaxException {
        String path = this.getClass().getClassLoader().getResource(nombreRecurso)
                .toURI().toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            return path.substring(6);
        }
        return path.substring(5);
    }

    /**
     * Prueba para abrir un archivo existente.
     * @throws URISyntaxException
     * @throws FileNotFoundException
     * @throws ValidacionPS1 
     */
    @Test
    public void testArchivoExistente() throws URISyntaxException, 
            FileNotFoundException, ValidacionPS1 {
        String ruta = corregirPath("prueba.txt");
        File f =archivoIO.encontrarArchivo(ruta);
        assertTrue(f.exists());
    }
    
    /**
     * Prueba para abrir un archivo inexistente.
     * @throws ValidacionPS1
     * @throws URISyntaxException
     * @throws FileNotFoundException 
     */
    @Test(expected = FileNotFoundException.class)
    public void testArchivoInexistente() throws
            ValidacionPS1, URISyntaxException, FileNotFoundException {
        String ruta = "esteArchivoNoExiste.xls";
         File f =archivoIO.encontrarArchivo(ruta);
    }

}

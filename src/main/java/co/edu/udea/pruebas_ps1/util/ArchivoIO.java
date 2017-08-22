/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.util;

import co.edu.udea.pruebas_ps1.util.excepcion.ValidacionPS1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Pc1
 */
public class ArchivoIO {

    /**
     * Encuentra el archivo dependiendo la ruta, además de validar de que el 
     * archivo cumpla con la extensión .txt
     * @param rutaArchivo La ruta del archivo 
     * @return El archivo que se encontró de acuerdo a la ruta.
     * @throws FileNotFoundException
     * @throws ValidacionPS1 
     */
    public File encontrarArchivo(String rutaArchivo) throws FileNotFoundException,
            ValidacionPS1 {
        String extArchivo;
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            throw new FileNotFoundException("El archivo no se puede abrir");
        }
        extArchivo = FilenameUtils.getExtension(archivo.getName());
        if ("txt".compareTo(extArchivo) != 0) {
            throw new ValidacionPS1("La extensión es inválida");
        }

        return archivo;
    }
    
    public void cargarInstruccion(String bloqueTexto) {
        
    }

}

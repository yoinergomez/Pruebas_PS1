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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import co.edu.udea.pruebas_ps1.modelo.ClaseLOC;
import java.net.URISyntaxException;

/**
 * Clase encargada de manejar la lectura y escritura en archivos
 *
 * @author Jhonatan Orozco Blandón
 * @date 2017/08/21
 * @version 1
 *
 */
public class ArchivoIO {

    /**
     * Encuentra el archivo dependiendo la ruta, además de validar de que el
     * archivo cumpla con la extensión .txt
     *
     * @param rutaArchivo La ruta del archivo
     * @return El archivo que se encontró de acuerdo a la ruta.
     * @throws FileNotFoundException
     * @throws ValidacionPS1
     */
    private int numeroLineas;

    /**
     * Método que encuentra el archivo buscado por medio de la ruta y que 
     * verifica que la extensión sea .txt
     * @param rutaArchivo
     * @return
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

    /**
     * Método que lee los datos de archivo que se ingresa por medio de la ruta
     * @param rutaArchivo
     * @return EL texto que se encuentra en el archivo
     * @throws FileNotFoundException
     * @throws ValidacionPS1
     * @throws IOException 
     */
    public String leerArchivo(String rutaArchivo) throws FileNotFoundException,
            ValidacionPS1, IOException {
        String cadena;
        String textoArchivo = "";
        numeroLineas = 0;
        File archivo = encontrarArchivo(rutaArchivo);
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            textoArchivo = textoArchivo.concat(cadena);
            numeroLineas++;
        }
        b.close();
        return textoArchivo;
    }

    /**
     * Método que escribe en la hoja de Excel el objeto de la clase ClaseLOC
     * @param s
     * @param clase
     * @param numeroFilas
     * @throws FileNotFoundException
     * @throws IOException
     * @throws URISyntaxException 
     */
    public void escribirResultadosClaseLOC(Sheet s, ClaseLOC clase, int numeroFilas)
            throws FileNotFoundException, IOException, URISyntaxException {
        int numeroCeldas = 0;
        Row r = s.createRow(numeroFilas);
        Cell c = r.createCell(numeroCeldas);
        c.setCellValue(clase.getNombre());
        numeroCeldas++;
        c = r.createCell(numeroCeldas);
        c.setCellValue(clase.getNumeroMetodos());
        numeroCeldas++;
        c = r.createCell(numeroCeldas);
        c.setCellValue(clase.getNumeroLineas());
    }
    
    /**
     * Método que crea el encabezado en la hoja de Excel
     * @param s 
     */
    private void crearEncabezadoExcel(Sheet s){
        int numeroCeldas = 0;
        Row r = s.createRow(0);
        Cell c = r.createCell(numeroCeldas);
        c.setCellValue("Nombre de la clase");
        numeroCeldas++;
        c = r.createCell(numeroCeldas);
        c.setCellValue("Número de métodos");
        numeroCeldas++;
        c = r.createCell(numeroCeldas);
        c.setCellValue("Tamaño de la clase");
        numeroCeldas++;
        c = r.createCell(numeroCeldas);
        c.setCellValue("Total");
    }

    
    /**
     * Método que escribe en la hoja de Excel la lista de objetos de tipo 
     * ClaseLOC
     * @param clases
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws URISyntaxException 
     */
    public File escribirResultadosPrograma(ArrayList<ClaseLOC> clases) throws
            IOException, FileNotFoundException, URISyntaxException {
        int numeroVariables = clases.size();
        int totalLineas = 0;
        Workbook w = new HSSFWorkbook();
        Sheet s = w.createSheet();
        String rutaProyecto;
        crearEncabezadoExcel(s);
        for (int i = 0; i < numeroVariables; i++) {
            ClaseLOC clase = clases.get(i);
            totalLineas = totalLineas + clase.getNumeroLineas();
            escribirResultadosClaseLOC(s, clase, i + 1);
        }
        Row r = s.createRow(numeroVariables+1);
        Cell c = r.createCell(3);
        c.setCellValue(totalLineas);
        ajustarColumnasExcel(s);

        rutaProyecto = ArchivoIO.class.getProtectionDomain().
                getCodeSource().getLocation().toURI().getPath();
        Date date = new Date();

        String nombreArchivo = "resultado " + date.getTime()
                + ".xls";
        rutaProyecto = rutaProyecto.concat(nombreArchivo);
        FileOutputStream outputStream = new FileOutputStream(rutaProyecto);
        w.write(outputStream);
        File f = new File(rutaProyecto);
        return f;
    }
    
    /**
     * Método que ajusta las columnas del Excel de acuerdo a lo longitud de las
     * palabras que se guardan en la hoja.
     * @param s 
     */
    private void ajustarColumnasExcel(Sheet s){
        s.autoSizeColumn(0);
        s.autoSizeColumn(1);
        s.autoSizeColumn(2);
        s.autoSizeColumn(3);
    }
}

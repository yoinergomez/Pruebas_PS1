package co.edu.udea.pruebas_ps1.principal;

import co.edu.udea.pruebas_ps1.util.ArchivoIO;
import co.edu.udea.pruebas_ps1.util.excepcion.ValidacionPS1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Es la clase principal que se encarga de ejecutar el proyecto.
 *
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/11
 * @version v1
 */
public class Principal {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws co.edu.udea.pruebas_ps1.util.excepcion.ValidacionPS1
     */
    public static void main(String[] args) throws IOException, ValidacionPS1 {
       ArchivoIO archivo = new ArchivoIO();
        try {
            
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Introduce el path del archivo de excel.");
            System.out.println("ejemplo: C:\\Users\\Laptop\\Downloads\\archivo.xls: ");
            System.out.println("path: ");
            
            String path = br.readLine();
            archivo.leerArchivo(path);
            
            //System.out.println("Revise los resultados en la ruta:" + f.getAbsolutePath());
            
            isr.close();
            br.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } 
    }
    
}

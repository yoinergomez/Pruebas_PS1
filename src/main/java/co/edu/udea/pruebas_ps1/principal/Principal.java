package co.edu.udea.pruebas_ps1.principal;

import co.edu.udea.pruebas_ps1.modelo.ClaseLOC;
import co.edu.udea.pruebas_ps1.util.ArchivoIO;
import co.edu.udea.pruebas_ps1.util.excepcion.ValidacionPS1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.apache.commons.lang.SystemUtils;

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
    public static void main(String[] args) throws IOException, ValidacionPS1, URISyntaxException {
       ArchivoIO archivo = new ArchivoIO();
        try {
            
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Introduce el path del archivo de excel.");
            System.out.println("ejemplo: C:\\Users\\Laptop\\Downloads\\archivo.xls: ");
            System.out.println("path: ");
            
            String path = br.readLine();
            //String path = "C:\\Users\\Esteban\\workspace\\Pruebas_PS1\\src\\main\\resources\\archivoConMultiplesClasesMetodos.txt";
            ArrayList<ClaseLOC> resultado = archivo.leerArchivo(path);
            File f = archivo.escribirResultadosPrograma(resultado);
            System.out.println("El archivo creado quedo almacenado en la siguiente ruta:\n"+f.getAbsolutePath());
            
            //System.out.println("Revise los resultados en la ruta:" + f.getAbsolutePath());
            
            isr.close();
            br.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } 
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

    
}

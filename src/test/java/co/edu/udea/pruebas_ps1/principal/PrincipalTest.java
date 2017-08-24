/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.principal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import org.apache.commons.lang.SystemUtils;
import org.junit.Test;

/**
 * Es la clase para hacer los test de la clase Main.
 *
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/11
 * @version v1
 */
public class PrincipalTest {
    
    public PrincipalTest() {
    }
    
    public String corregirPath(String nombreRecurso) throws URISyntaxException {
        String path = this.getClass().getClassLoader().getResource(nombreRecurso)
                .toURI().toString();
        if (SystemUtils.IS_OS_WINDOWS) {
            return path.substring(6);
        }
        return path.substring(5);
    }

    /**
     * Test of main method, of class Principal.
     * @throws java.lang.Exception
     */
    @Test
    public void testMain() throws Exception {
        String data = corregirPath("archivoConUnaClase.txt");
        String[] args = null;
        final InputStream original = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Principal.main(args);
        System.setIn(original);
    }
    
}

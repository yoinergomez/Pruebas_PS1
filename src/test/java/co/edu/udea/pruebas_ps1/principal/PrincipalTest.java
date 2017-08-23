/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.principal;

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

    /**
     * Test of main method, of class Principal.
     * @throws java.lang.Exception
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = {"Rutas"};
        Principal.main(args);
    }
    
}

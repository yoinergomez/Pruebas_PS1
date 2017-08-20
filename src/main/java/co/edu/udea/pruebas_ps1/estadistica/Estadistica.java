/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps1.estadistica;

/**
 * Almacena la cantidad de linea de código, cantidad de métodos y el nombre 
 * de una clase
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/19
 * @version v1
 */
public class Estadistica {
    private String nombre;
    private int numeroLineas;
    private int numeroMetodos;

    public Estadistica(String nombre, int numeroLineas, int numeroMetodos) {
        this.nombre = nombre;
        this.numeroLineas = numeroLineas;
        this.numeroMetodos = numeroMetodos;
    }

    public Estadistica() {
        this.nombre = null;
        this.numeroLineas = 0;
        this.numeroMetodos = 0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroLineas() {
        return numeroLineas;
    }

    public void setNumeroLineas(int numeroLineas) {
        this.numeroLineas = numeroLineas;
    }

    public int getNumeroMetodos() {
        return numeroMetodos;
    }

    public void setNumeroMetodos(int numeroMetodos) {
        this.numeroMetodos = numeroMetodos;
    }
    
}

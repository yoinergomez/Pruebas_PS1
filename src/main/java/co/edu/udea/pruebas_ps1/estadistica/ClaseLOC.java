package co.edu.udea.pruebas_ps1.estadistica;

/**
 * Almacena la cantidad de linea de código, cantidad de métodos y el nombre 
 * de una clase
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/19
 * @version v1
 */
public class ClaseLOC {
    private String nombre;
    private int numeroLineas;
    private int numeroMetodos;

    public ClaseLOC(String nombre, int numeroLineas, int numeroMetodos) {
        this.nombre = nombre;
        this.numeroLineas = numeroLineas;
        this.numeroMetodos = numeroMetodos;
    }

    public ClaseLOC() {
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

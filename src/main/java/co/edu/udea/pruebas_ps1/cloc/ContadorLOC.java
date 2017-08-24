package co.edu.udea.pruebas_ps1.cloc;

import co.edu.udea.pruebas_ps1.modelo.ClaseLOC;

/**
 * Es la clase encargada de verificar si una sentencia es una clase o un método
 *
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/19
 * @version v1
 */
public class ContadorLOC {

    private String multiLinea;

    public ContadorLOC() {
        this.multiLinea = new String();
    }

    /**
     * Verifica si una sentencia es un clase
     *
     * @param linea a comprobar
     * @return true si es una clase o false en otro caso
     */
    
    /**
     * 
     * @param linea
     * @return 
     */
    public ClaseLOC comprobarClase(String linea) {
        ClaseLOC loc = null;
        if(linea.startsWith("@")){
            return loc;
        }
        String aux[] = linea.split(" ");
        int ubicacion;   
        if (aux[0].equals("class")) {
            ubicacion = aux[1].indexOf("{");
            if(ubicacion != -1){
                aux[1] = aux[1].substring(0, ubicacion);
            }
            loc = new ClaseLOC(aux[1], 1, 0);
        } else if (aux[1].equals("class")) {
            ubicacion = aux[1].indexOf("{");
            if(ubicacion != -1){
                aux[2] = aux[2].substring(0, ubicacion);
            }
            loc = new ClaseLOC(aux[2], 1, 0);
        }
        return loc;
    }
    
    /**
     * Método para saber si una linea es el inicio de una clase
     * @param linea
     * @return true si es el inicio y false en caso contrario
     */
    public boolean esInicioClase(String linea){
        String aux[] = linea.split(" ");
        return aux[0].equals("package");
    }

    /**
     * Verifica si una linea es un método
     *
     * @param linea a verificar
     * @return true si es un meétodo o false en caso contrario
     */
    public boolean comprobarMetodo(String linea) {
        String aux;
        if (linea.contains("throws")) {
            int posicion = linea.indexOf("throws");
            int end = linea.indexOf("{");
            aux = linea.substring(0, posicion);
            if (end != -1) {
                aux = aux + "{";
            }
            aux = aux.replaceAll("\\s+", "");
        } else {
            aux = linea.replaceAll("\\s+", "");
        }
        return aux.contains("){");
    }

    /**
     * Comprueba si el argumento 'linea' es un comentario
     *
     * @param linea
     * @return
     */
    private boolean esComentario(String linea) {
        if (linea.startsWith("//")) {
            return true;
        }
        if (linea.startsWith("/*")) {
            return true;
        }
        if (linea.startsWith("*/")) {
            return true;
        }
        return linea.startsWith("*");
    }

    /**
     * Comprueba si el argumento 'linea' es un cierre de instrucción, es decir,
     * ignora el cierre de una función o clase '}'
     *
     * @param linea
     * @return
     */
    private boolean esCierreSentencia(String linea) {
        String sub = linea.substring(linea.indexOf("}") + 1).trim();
        return (linea.charAt(0) == '}') || esComentario(sub);
    }

    /**
     * Comprueba si el argumento 'linea' es el final de una sentencia
     * finalizando con un ";" o "{" siendo el último, el caso para las clases y
     * métodos
     *
     * @param linea
     * @return
     */
    private boolean esFinalInstruccion(String linea) {

        if (esDeclaracionArreglo(linea)) {
            return false;
        }
        return linea.endsWith("{") || linea.endsWith(";");
    }

    /**
     * Verifica si el argumento ingresado es una declaración de un arreglo
     *
     * @param linea
     * @return
     */
    private boolean esDeclaracionArreglo(String linea) {
        String lineaSinEspacios = linea.replaceAll("\\s", "");
        int index = lineaSinEspacios.indexOf("{") - 1;
        if (index >= 0) {
            return lineaSinEspacios.substring(index).startsWith("=");
        }
        return false;
    }

    /**
     * Retorna toda una sentencia en una sola fila, si el argumento no es 
     * una sentencia completa la función retorna "..." lo que indica que debe
     * ingresarse una nueva línea
     * @param linea
     * @return 
     */
    public String cargarInstruccion(String linea) {
        linea = linea.trim();
        if (linea.isEmpty()) { //Línea en blanco
            return null;
        }
        if (esComentario(linea)) {
            return null;
        }
        if (esCierreSentencia(linea)) {
            return null;
        }
        if(linea.startsWith("@")){
            return linea;
        }
        if (!esFinalInstruccion(linea)) {
            multiLinea += linea;
            return "...";
        } else if (multiLinea != null) {
            linea = multiLinea + linea;
            multiLinea = "";
        }
        return linea;
    }
}

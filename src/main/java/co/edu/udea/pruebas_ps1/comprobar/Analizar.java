package co.edu.udea.pruebas_ps1.comprobar;

/**
 * Es la clase encargada de verificar si una sentencia es una clase o un método
 *
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/19
 * @version v1
 */
public class Analizar {

    private String multiLinea;

    public Analizar() {
        this.multiLinea = new String();
    }

    /**
     * Verifica si una sentencia es un clase
     *
     * @param linea a comprobar
     * @return true si es una clase o false en otro caso
     */
    public boolean comprobarClase(String linea) {
        String aux[] = linea.split(" ");
        if (aux[0].equals("class")) {
            return true;
        } else if (aux[1].equals("class")) {
            return true;
        }
        return false;
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
            System.out.println("aux:" + aux);
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

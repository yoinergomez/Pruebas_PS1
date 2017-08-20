package co.edu.udea.pruebas_ps1.comprobar;

/**
 * Es la clase encargada de verificar si una sentencia es una clase o un método
 * @author Frank Castrillón - castrillonfrank114@gmail.com
 * @date 2017/08/19
 * @version v1
 */
public class Analizar {
    
    public boolean comprobarClase(String linea){
        String aux[] = linea.split(" ");
        if (aux[0].equals("class")){
            return true;
        }else if (aux[1].equals("class")){
            return true;
        }
        return false;
    }
    
    public boolean comprobarMetodo(String linea){
        String aux;
        if (linea.contains("throws")){
            int posicion = linea.indexOf("throws");
            int end = linea.indexOf("{");
            aux = linea.substring(0, posicion);
            if(end != -1){
             aux = aux + "{";   
            }
            System.out.println("aux:"+aux);
            aux = aux.replaceAll("\\s+","");
        }else{
            aux = linea.replaceAll("\\s+","");
        }
        return aux.contains("){");
    }
}

import java.util.*;
import java.io.*;
/**
 * Write a description of class MedellinMapa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MedellinMapa
{
    private static ArrayList<Pairs> mapaMedellin;
    private static double maxNumber = 0;
    private static double mimNumber = 2147483647;
    
    public static void armarGrafo(String archivo) throws FileNotFoundException, IOException {
        FileReader f = new FileReader(archivo);
        BufferedReader ficheroLectura = new BufferedReader(f);
        leerNodosIniciales(ficheroLectura);
        //leerArcosNodos(ficheroLectura);
        ficheroLectura.close();  
    }
    
    
    /*
     * Codigo basado en:
     * https://geekytheory.com/como-leer-un-fichero-en-java
     * 
     */
    public static void leerNodosIniciales(BufferedReader ficheroLectura) throws FileNotFoundException, IOException {
        String cadena;
        while((cadena = ficheroLectura.readLine())!="\n") {
            ArrayList<String> test = new ArrayList<String>();
            
            for(String s: cadena.split(" ")){
                test.add(s);
            }
            
            if(test.size() == 1){break;}
            
            double idNode = Double.parseDouble(test.get(0));
            double cordenadaX = Double.parseDouble(test.get(1));
            double cordenadaY = Double.parseDouble(test.get(2));
            
            if (idNode > maxNumber)maxNumber = idNode;
            if (idNode < mimNumber)mimNumber = idNode;
            
            System.out.println(idNode);
            
            mapaMedellin.add(new Pairs(new Nodo(idNode, cordenadaX, cordenadaY)));
        }
        System.out.println(maxNumber+ " " + mimNumber +" " +(maxNumber-mimNumber) );
    }
    
    public static void leerArcosNodos(BufferedReader ficheroLectura) throws FileNotFoundException, IOException {
        String cadena;

        while((cadena = ficheroLectura.readLine())!=null) {
            ArrayList<String> test = new ArrayList<String>();
            
            for(String s: cadena.split(" ")){
                test.add(s);
            }
            
            if(test.size() == 1){break;}
            
            
        }
    }

    public static void main(String[] args) throws IOException {
        mapaMedellin = new  ArrayList<Pairs>();
        armarGrafo("C:/Users/Juan Gonzalo Quiroz/Documents/GitHub/st0247-201610012010/laboratorios/lab01/codigo/Parte-1/medellin_colombia-grande-Cambiada.txt");
    }

}

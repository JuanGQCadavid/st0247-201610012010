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
    private static ArrayList<ArrayList<Pairs>> mapaMedellin;
    private static double maxNumber = 0;
    private static double mimNumber = 2147483647;
    
    public static void armarGrafo(String archivo) throws FileNotFoundException, IOException {
        FileReader f = new FileReader(archivo);
        BufferedReader ficheroLectura = new BufferedReader(f);
        leerNodosIniciales(ficheroLectura);
        leerArcosNodos(ficheroLectura);
        ficheroLectura.close(); 
    }

    
    /*
     * Codigo basado en:
     * https://geekytheory.com/como-leer-un-fichero-en-java
     * 
     */
    public static void leerNodosIniciales(BufferedReader ficheroLectura) throws FileNotFoundException, IOException {
        String cadena;
        int times = 0;
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
            times++;
            addNodeB(new Pairs(new Nodo(idNode, cordenadaX, cordenadaY)),calcularHash(test.get(0)));
        }
        //cadena = ficheroLectura.readLine();
        //System.out.println(cadena);
        //System.out.println(maxNumber+ " " + mimNumber +" " +(maxNumber-mimNumber) );
        //System.out.println(times);
    }
    
    public static void addNodeB(Pairs newPair, int pos){
        (mapaMedellin.get(pos)).add(newPair);
    }
    
    public static void leerArcosNodos(BufferedReader ficheroLectura) throws FileNotFoundException, IOException {
        String cadena;

        while((cadena = ficheroLectura.readLine())!=null) {
            ArrayList<String> test = new ArrayList<String>();
            
            for(String s: cadena.split(" ")){
                test.add(s);
            }
            
            if(test.size() == 1){break;}
            
            double idNodeBase = Double.parseDouble(test.get(0));
            double idNodeTo = Double.parseDouble(test.get(1));
            double length = Double.parseDouble(test.get(2));
            String name = "desconocido";
            
            if(test.size() == 4)name = test.get(3);
            ArrayList<Double> data = new ArrayList<Double>();
            
            data.add(idNodeBase);data.add(idNodeTo);
            data.add(length);
            
            Pairs actualPair = foundPair(mapaMedellin.get(calcularHash(test.get(0))),idNodeBase);
            
            actualPair.addNodeFromMe(idNodeTo,length, name);
            
        }
    }
    
    public static int calcularHash(String line){
        int Number = Integer.parseInt(line.substring(line.length() - 1));
        return Number;
    }
    
    public static Pairs foundPair(ArrayList<Pairs> mapaMedellinPos,Double idNodeBase){
        for(Pairs actualPair : mapaMedellinPos){
            Nodo actualNode = actualPair.getNodoBase();
            if(actualNode.getIdNode() == idNodeBase)return actualPair;
        }
        return null;
    }
    
    

    public static void main(String[] args) throws IOException {
        mapaMedellin = new  ArrayList<ArrayList<Pairs>> ();
        for(int i = 0; i < 10;i++){
            mapaMedellin.add(new ArrayList<Pairs>());
        }
        armarGrafo("C:/Users/jquiro12/Desktop/st0247-201610012010-master/Laboratorios/lab01/codigo/Medellin/medellin_colombia-grande-Cambiada.txt");
    }

}

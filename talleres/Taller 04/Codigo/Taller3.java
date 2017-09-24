 

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #3
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller3 {
    /*
     * 1.   Escriba un método para verificar si puede poner 
     * una reina en determinada posición. Recuerde que debido 
     * a la forma como representamos los tableros es imposible 
     * tener dos reinas en una misma fila, por lo que no necesita
     * verificar esta condición. El parámetro r hace referencia 
     * a la fila, y el c a la columna.
     */
    
    private static boolean puedoPonerReina(int r, int c, int[] tablero) {
        /*
         * Vamos a validar que
         * 
         * Horizontal = Si la pos de reians pasada sean diferentes
         *  a la reina acutal
         *      i != j
         * 
         * Vertical en ambos direcciones =  pos + i o pos -i 
         */
        int revez = 0;
        
        for(int pos = c; pos >0; pos--){
          revez++;
          if( tablero[pos-1] + revez == r ||  tablero[pos-1] - revez == r ) return false;
          
          if(tablero[pos-1] == r) return false;
        }
        
        return true;
    }
    
    public static void testeo(){

    
    }
    
    public static int nReinas(int n) {
        int [] tablero = new int[n];
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) tablero[j] = -1;
            if (nReinas(i, 0, tablero)){imprimirTablero(tablero);count++;}
        } 
        
        
        //
       
        return count;
        
    }
    
    private static boolean nReinas(int r, int c, int[] tablero) {
        if (r == tablero.length){
            if(c == 0){
                return false;
            }
            tablero[c] = -1;
            return  nReinas(tablero[c-1] + 1,c-1,tablero);
            
        }
        
        if(c == tablero.length) return true;
        
        
        if(puedoPonerReina(r,c,tablero)){
            tablero[c] = r;
            return  nReinas(0,c+1,tablero);
        }else{

            return nReinas(r+1, c ,tablero);

        }        
    }
    
    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    public static ArrayList<Integer> camino(Digraph g, int inicio, int fin) {
        ArrayList<Integer> caminoDFS = new ArrayList<Integer>();
        
        if(dfs(g,inicio,fin,  new boolean[g.size()] , caminoDFS)){
            return caminoDFS;
        }
       
        return null;
        // complete...
    }

    // recomendacion
    private static boolean dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {
        visitados[nodo] = true;
        list.add(nodo);
        
        if(nodo == objetivo) return true;
       
        ArrayList<Integer> susesores = g.getSuccessors(nodo);
        
        for(int i = 0; i <= susesores.size(); i++ ){
            if(visitados[i] = false){
                dfs(g, susesores.get(i),objetivo, visitados,list);
            }
        }
        
        for()
    }

}

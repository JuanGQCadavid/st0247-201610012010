import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller4 {
    
    //Primero
    public static int recorrido(Digraph g) {
        // complete...
    }

    // recomendacion
    private static int recorrido(Digraph g, int v, int[] unvisited) {
        // complete...
    }

    // recomendacion
    private static int[] removeAt(int k, int a[]) {
        // complete...
    }

    public static int costoMinimo(Digraph g, int inicio, int fin) {
        // complete...
    }

    // recomendacion
    private static void dfs(Digraph g, int v, int[] costo, boolean [] visitados) {
        visitados[v] = true;
        
        boolean estado = true;
        if(v == 0){
            for(boolean estadoF: visitados){
                if(!estadoF) estado = false;
            }
            
            if(estado){
                
            }
        }
        
        ArrayList<Integer> sucesores = g.getSuccessors(v);
        for(int pos : sucesores){
            if(!visitados[pos]){
                dfs(g, pos,costo);
            }
        }
        
        
    }

}

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #3
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller3 {
    public static void main(String[] args) {
        DigraphAL g = new DigraphAL(12);
		g.addArc(7, 11, 1);
		g.addArc(7, 8, 1);
		g.addArc(5, 11, 1);
		g.addArc(3, 8, 1);
		g.addArc(3, 10, 1);
		g.addArc(11, 2, 1);
		g.addArc(11, 9, 1);
		g.addArc(11, 10, 1);
		g.addArc(8, 9, 1);
		
		ArrayList<Integer> result = camino(g, 3,9);
		
		for(int i: result){
		    System.out.println(i);
		}
        
    
    }
    public static boolean llegamos = false;
    
    public static ArrayList<Integer> camino(Digraph g, int inicio, int fin) {
        ArrayList<Integer> result  = new ArrayList<Integer>();
        boolean visitados[] = new boolean[g.size()];
        result.add(inicio);
        llegamos = false;
        if (dfs( g, inicio,fin, visitados, result))return result;
        return null;
        
    }

    // recomendacion
    
    private static boolean dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {
        // Parada
        
        if(nodo == objetivo) return true;
        
        ArrayList<Integer> successors = g.getSuccessors(nodo);
        
        if(successors != null){
            for(int nodoSucesor: successors ){
                if(llegamos == true) break;
                if(!visitados[nodoSucesor]){
                    list.add(nodoSucesor);
                    visitados[nodoSucesor] = true;
                    if(dfs(g,nodoSucesor, objetivo, visitados, list)){
                        llegamos =  true;
                    }
                   
                 }
           
         }
        }else{
            int size =list.size();
            list.remove(size-1);
            return false;
        
        }
        
        if(!llegamos){
            int size =list.size();
            list.remove(size-1);
        }
        
        return llegamos;
        
         
         
    }

}

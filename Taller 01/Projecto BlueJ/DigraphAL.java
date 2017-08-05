import java.util.*;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAL extends Digraph {
    // complete...
    
    ArrayList<ArrayList<Pair<Integer,Integer>>> listaAdj;

    public DigraphAL(int size) {
        super(size);
        
        listaAdj = new ArrayList<ArrayList<Pair<Integer,Integer>>>();
        
        ArrayList<Pair<Integer,Integer>> listaAux;
        
        for(int i = 0; i < size; ++i){
            listaAux = new ArrayList<Pair<Integer,Integer>>();
            for(int j = 0;j < size; ++i){
                listaAux.add(new Pair(j,0));
            }
            listaAdj.add(listaAux);
        }
        
        
        // complete...
    }

    public void addArc(int source, int destination, int weight) {
        // complete...
        // recuerde: grafo dirigido!
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        // complete...
        // recuerde: null si no hay!
        
        if(){
        
        }
        return null;
    }

    public int getWeight(int source, int destination) {
        // complete...
        return 0;
    }

}

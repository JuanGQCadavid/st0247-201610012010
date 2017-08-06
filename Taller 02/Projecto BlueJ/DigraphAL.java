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
            listaAdj.add(listaAux);
        }
        
        
        // complete...
    }

    public void addArc(int source, int destination, int weight) {
        // complete...
        // recuerde: grafo dirigido!
        
        (listaAdj.get(source)).add(new Pair<Integer,Integer> (destination,weight));
        
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        // complete...
        // recuerde: null si no hay!
        
        if(!listaAdj.get(vertex).isEmpty()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            
            for(Pair<Integer, Integer> pair : listaAdj.get(vertex)){
                temp.add(pair.first);
            }
            
            
            Collections.sort(temp);
            
            return temp;
        
        }
        return null;
    }
    
    public int getWeight(int source, int destination) {
        // complete...
        
        for(Pair<Integer,Integer> pair: listaAdj.get(source)){
            if(pair.first == destination){
                return pair.second;
            }
        }
        
        return 0;
    }

}

import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, <su nombre>
 */
public class DigraphAM extends Digraph {
    // complete..
    int matrizAD [][];
    public DigraphAM(int size) {
        super(size);
        matrizAD = new int [size][size];
    }

    public void addArc(int source, int destination, int weight) {
        // complete...
        // recuerde: grafo dirigido!
        matrizAD[source][destination] = weight;
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        // complete...
        // recuerde: null si no hay!
        
        ArrayList<Integer> successors  = new ArrayList<Integer>();
        
        for(int i = 0; i < matrizAD.length; ++i){
            if (matrizAD[vertex][i] != 0){
                successors.add(i);            
            }
        }
        
        if (successors.size() > 0){
            return successors;
        }
        return null;
    }

    public int getWeight(int source, int destination) {
        // complete...
        return matrizAD[source][destination];
    }

}

import java.util.*;

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
        if (weight == 0){
            matrizAD[source][destination] = 1;
        }else{
            matrizAD[source][destination] = weight;
        }
        
        
        //System.out.println(matrizAD[source][destination]);
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        // complete...
        // recuerde: null si no hay!
        //System.out.println("Quibo");
        ArrayList<Integer> successors  = new ArrayList<Integer>();
        
        for(int i = 0; i < matrizAD.length; ++i){
            //System.out.println(matrizAD[vertex][i]);
            //System.out.println("Quibo");
            if (matrizAD[vertex][i] != 0){
                successors.add(i);            
            }
        }
        
        if (successors.size() > 0){
            Collections.sort(successors);
            
            return successors;
        }
        return null;
    }

    public int getWeight(int source, int destination) {
        // complete...
        return matrizAD[source][destination];
    }

}

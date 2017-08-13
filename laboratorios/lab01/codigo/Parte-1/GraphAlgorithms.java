
/**
 * Write a description of class GraphAlgorithms here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GraphAlgorithms
{
    // instance variables - replace the example below with your own

    /**
     * Este metodo calcula cual es el vertice de un grafo
     * que tiene mas sucesores.
     * 
     * @param Graph Bigraph -> A Bigraph without caring about
     * its implementation (It could be AL or AM).
     * @return The node with more successors. 
     */
    public int maxSuccessores(Graph Bigraph)
    {
        int max = -1;
        int maxIndex = 0;
        
        for(int index = 0; index < Bigraph.size(); ++index){
            if(Bigraph.getSuccessors(index).size() >= max){
                max = Bigraph.getSuccessors(index).size();
                maxIndex = index;
            }
        }
        
        return maxIndex;
    }
}

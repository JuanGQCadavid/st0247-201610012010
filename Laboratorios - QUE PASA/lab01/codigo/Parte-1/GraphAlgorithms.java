import java.util.*;
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
    public static int maxSuccessores(Graph Bigraph)
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
    
    /**
     * Este metodo calcula cual es el vertice de un grafo
     * que tiene mas sucesores.
     * 
     * @param Graph Bigraph -> A Bigraph without caring about
     * its implementation (It could be AL or AM).
     * @return The node with more successors. 
     */
    public static void ciclos()
    {
        
       DigraphAL biGraphAL = new DigraphAL(6);
       biGraphAL.addArc(0,1,10);
       biGraphAL.addArc(0,2,3);
       biGraphAL.addArc(1,2,1);
       biGraphAL.addArc(1,3,2);
       biGraphAL.addArc(2,1,4);
       biGraphAL.addArc(2,3,8);
       biGraphAL.addArc(2,4,2);
       biGraphAL.addArc(3,4,7);
       biGraphAL.addArc(4,3,9);
       
       
       for(int i = 0; i<biGraphAL.size();i++){
           for(int j = 0; j <biGraphAL.size();j++){
               ArrayList<Integer> result = DigraphAlgorithms.getPath(DigraphAlgorithms.dijsktra(biGraphAL,j),j,i);
               System.out.println(result.size());
           }
       }       
       
       System.out.println("s");
    }
    
}

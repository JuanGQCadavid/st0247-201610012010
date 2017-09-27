import java.util.*;
/**
 * Write a description of class MapColoring here.
 * 
 * @author Juan Gonzalo Quiroz Cadavid  
 * @version September 13, 2017
 */
public class MapColoring
{
    
    public static boolean coloring(int node, boolean [][] graph, boolean [][]colorsGraph){
        //Get colors free to use
        boolean colors []= ObtenerColoresDisponibles( node,  graph,colorsGraph);
        //Get my partners
        ArrayList<Integer> successors = getSuccesors(node,graph);
        /*
         * if theren't one free to use, then return false.
         */
        if(!checkColors(colors))
            return false;
        
         /*
          * Color by color, we'll check waht would happend if I put
          * this color on the node, and continue with my partners
          */
        for(int index = 0; index < colors.length; ++index)
            // Is this color fre?
            if(colors[index]){
                //so put me that color
                colorsGraph[node][index] = true;
                //and lets go down to my partners
                for(int indexP : successors){
                    //is My Nearest partner already free? (Without any color)? 
                    if(!checkColors(colorsGraph[indexP])){
                        //Try with them
                        if(coloring(indexP, graph,colorsGraph))
                            return true;
                    }
                }
                
                /*
                 * If we are still here, that means that ..
                 * we this color it doesn't work..
                 * let's try another color.
                 */ 
                
                /*
                 * Upss.. First lets clean this new Mess
                 */
                colorsGraph[node][index] = false;
                
            }
            
        /*
         * Really NIGGA?
         * 
         * none works for me?..
         * 
         * let's clean all these mess and come back...
         * maybe if who callme change her color i would
         * work...
         * 
         */
        return false;
        
            
            
    }
    
    /*
     * Returns true if there are almost 1
     * color free to be use.
     * 
     * @param boolean [] List with the colors
     * 
     * @return boolean
     */
    public static boolean checkColors(boolean []colors){
        for(int i = 0; i < colors.length; ++i)
            if(colors[i])
                return true;
        
        return false;
    }
    
    /*
     * this method compute and return an Array
     * with the colors witch is not in use by anyother
     * partner
     * 
     * @param int A node's index
     * @param int [][] A Graph represented by Adjacency Matrix.
     * 
     * @raturn ArrayList<Integer>
     * 
     */
    public static boolean[] ObtenerColoresDisponibles(int node, boolean [][] graph, boolean [][]colorsGraph){
        ArrayList<Integer> successorIndex = getSuccesors( node, graph);
        boolean colors []= new boolean [colorsGraph[0].length];
        
        /*
         * We're going to put every stated on true
         */
        
        for (int i = 0; i < colors.length; ++ i)
            colors[i]= true;
        
        /*
         * We are going to check every Node's successors  
         */
        for(int successor : successorIndex){
            /*
             * One by One we are going to check wich color this
             * node doesn't use.
             */
            for(int i = 0; i < colorsGraph[0].length; ++i){
                if(colorsGraph[successor][i])
                    /*
                     * If some successor has already used this color
                     * then; this one is no possible to choose;
                     */
                    
                    colors[i] = false;
            }
            
        }
        
        return colors;
        
    }
    
    
    /*
     * This Method computes and return an ArrayList.
     * those one contain the Node's Partne´s index.
     * 
     * @param int the Node's Index
     * @param int [][] A graph represented by Adjacecy Matrix.
     * 
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> getSuccesors(int node, boolean [][] graph){
        ArrayList<Integer> successorIndex = new ArrayList<Integer>();
        
        for(int i = 0; i< graph.length; ++i)
           
            if(graph[node][i] == true)successorIndex.add(i);
        
        return (successorIndex == null) ? null:successorIndex ;
    
    }
    
    
}

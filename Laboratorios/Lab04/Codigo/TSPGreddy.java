import java.util.*;

public class TSPGreddy{
    private Digraph graph;
    private int INDEX;
    public TSPGreddy(Digraph graph){
	this.graph = graph;
    }
    public void setIndex(int INDEX){
	this.INDEX = INDEX;
    }
    public int[]  getTSPMap(){
	int size = graph.size(),
	    index = INDEX;
    	boolean isIndexIn = false;
	ArrayList<Integer> successors;
	int result [] = new int[size];

	boolean[] visited = new boolean[size];

	
	for(int i = 0; i < size; i++){
	    visited[index] = true;
	    
	    successors = graph.getSuccessors(index);
	    //Select the short one.
	    int min = Integer.MAX_VALUE; // MAX
	    int indexMin = -1;
	    //Lets Find the Shortest one.
	    for(int node: successors){
		
		if(!visited[node] &&
		   graph.getWeight(index,node) < min){
		    min = graph.getWeight(index,node);
		    indexMin = node;
		}
		if(node == INDEX)
		    isIndexIn = true;
	    }

	    //Min Represent the shortest node.

	    //Validation
	    if(min == Integer.MAX_VALUE){
		//Is the index on the table?
		if(isIndexIn){
		    //have We visited all nodes?
		    for(boolean isVisited : visited)
			if(!isVisited)
			    return null;
		    result[index] = INDEX;
		    
		    return result;
		}else{
		    return null;
		}

	    }

	    System.out.println("Min of " + index + " is "+ min);
  	    result[index] = indexMin;
	    index = indexMin;
	    isIndexIn = false;
	}
	return result;
         
    }

}

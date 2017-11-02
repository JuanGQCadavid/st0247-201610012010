import java.util.*;
import java.math.*;

public class Held_Karp {
    private BitMap bitMap;
    private Digraph diGraph;
    // Pair <Father, size>
    private Pair<Integer,Integer> [][] hk;
    private int node_Vertex = 0;

    

    
    public Held_Karp(Digraph diGraph){
	this.diGraph = diGraph;
	bitMap = new BitMap();
	createMatrix();
	held_Karp();
    }

    private void held_Karp(){
	boolean [] subsSet = {true,true,true,true};
	Pair<Integer,Integer> result = seLeTiene(0,subsSet);
	System.out.println(result.second);
    }
    //                                    Index
    //El pair final a retornar es el de [0,{1,2,3}];
    private Pair<Integer,Integer> seLeTiene(int index,boolean [] subGroup)
    {


	/*
	 * Sera que este valor ya fue calculado
	 * y estara esperando en la tabla?
	 */
	if(hk[index][bitMap.getNumber(subGroup)] != null){
	    /*
	     * Si seño! ya estaba calculado
	     * Que hermosura no?,retorne  ese retoño
	     */
	    return (hk[index][bitMap.getNumber(subGroup)]);
		
	}

	/*
	 * Mijo nos toco meternos en el fango
	 * a ver, veamos primero si sale
	 * de una y dejamos de pendejaiar con
	 * ese.
	 */

	if(bitMap.getLength(subGroup) == 0){
	    /* vean pues, salio con que es
	     * de la forma [1,0], que maravilla
	     * estamos en el fondo! jajajaj
	     */

	    //Estara  ya guardado?

	    if(hk[index][node_Vertex] != null){
		// mas hermoso no puede ser.
		return hk[index][node_Vertex];
	    }
	    /*
	     * Patron.. no esta calculado..
	     * ¿ Que no que?! Calculen a ese hp YA MISMO.
	     */
	    
	    
	    int distance = 0;
	    //Veamos desde el nodo Vertice a este cuanto es

	    distance += diGraph.getWeight(node_Vertex,index);

	    /* 
	     * Listo patron.
	     * Y entonces? se va a guardar solo?
	     * CUADREME ESO YA MISMO!.
	     */

	    Pair<Integer,Integer> newBaby =
		new Pair<Integer,Integer>(node_Vertex, distance);

	    hk[index][node_Vertex] = newBaby;
	    return newBaby;
		 
	}
	
	/*
	 * Ahhh no esta calculado, comencemos
	 * a descomponerlo.
	 */
	    
	ArrayList<Pair<Integer,Integer>> results =
	    new ArrayList<Pair<Integer,Integer>>();
	
	for(int i = 0; i < subGroup.length; i++){
	    if(!subGroup[i]) continue;

	    subGroup[i] = false;
	    int newIndex = i + 1;
	    //FUCK
	    /*
	     * Y este hp que? ya estara o todavia nada?
	     */

	    if(hk[newIndex][bitMap.getNumber(subGroup)] != null)
		/*
		 * Eh que maravilla ome, ya esta calculado
		 * agregemoslo para despues ver si es la
		 * mejor Opcion
		 */
		results.add(hk[newIndex][bitMap.getNumber(subGroup)]);
	    else{
		/*
		 * Que no que?
		 * Despejeme eso ya Mismmo.
		 */
		Pair <Integer,Integer> newPair =
		    seLeTiene(newIndex,subGroup);
		/*
		 * Jefe, despejado..
		 * Listo, consruyan el nuevo posible
		 * Vertice, y guardelo como Opcion..
		 * No se les olvide sumar Distancias..
		 */
		int distance = diGraph.getWeight(newIndex, index) +
		    newPair.second;
		
		
		results.add(new Pair<Integer,Integer>(newIndex, distance));
				
	    }

	    

	    subGroup[i] = true;


	}
	
	if(results.size() == 1)
	    return results.get(0);
	
	hk[index][bitMap.getNumber(subGroup)] = getMinimun(results);
	return hk[index][bitMap.getNumber(subGroup)];

    }

    private Pair<Integer,Integer> getMinimun(ArrayList<Pair<Integer,Integer>> array){
	
	int min = Integer.MAX_VALUE;
	Pair<Integer,Integer> minPair = null;;
	int distance = 0;
	
	for(Pair<Integer,Integer> pairs : array){

	    distance = pairs.second;
	    
	    if(distance < min){
		minPair = pairs;
		min = distance;
	    }
	}
	

	return minPair;
	
	
    }

    public Pair<Integer,Integer> [][]  getHeld_Karp_Matrix(){
	return hk;
    }

    public Pair<Integer,Integer>  getHeld_Karp_ValueDoingMatrix(){
	held_Karp();
	return hk[node_Vertex][hk.length];
    }

    /*
     * This method create our 
     * matrix; wich one, we are
     * going to use through the
     * whole program.
     *
     * Rows = diGraph size!
     * Columns = 2 ^ (digraphSize - 1)
     * This is because we don't need to
     * make combinations with the node
     * vertex (in other words, we are't including
     * the vertex node.)
     */
    private void createMatrix(){
	int m_Rows, m_Columns;

	m_Rows = diGraph.size();
	m_Columns =(int) Math.pow(2,m_Rows - 1 );
	
	hk = new Pair<Integer,Integer> [m_Rows][m_Columns];
    } 
}

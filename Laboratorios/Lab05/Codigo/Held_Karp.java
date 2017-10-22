import java.util.*;
import java.math.*;

public class Held_Karp {
    private BitMap bitMap;
    private Digraph diGraph;
    // Pair <Father, size>
    private Pair<int,int> [][] hk;
    private int node_Vertex = 0;
    
    public Held_Karp(Digraph diGraph, int node_Vertex = 0){
	this.diGraph = diGraph;
	bitMap = new bitMap();
	this.node_Vertex = node_Vertex;
	createMatrix();
	held_Karp();
    }

    private void held_Karp(){
	seLeTiene(0,[1,1,1]);
    }
    private Pair<int,int> seLeTiene(int index, boolean [] subGroup){
	for(int i = index; i < subGroup.length; i++){
	    subGroup[i] = false;
	    
	    if(hk[i][bitMap.getNumber(subGroup)] != null){
		// Ya calculado previamente
		return hk[i][bitMap.getNumber(subGroup)];
		
	    }else{
		
		if(subGroup.length() == 1){
		    // node_Vertex -> index
		    int distance = biGraph.getWeigth
			(node_Vertex,index);

		    hk[i][bitMap.getNumber(subGroup)] =
			new Pair(index,distance);

		    return hk[i][bitMap.getNumber(subGroup)];
		    //Directo
		}else{
		    //No es directo y lo vamos a calcular.
		    Pair father = seLeTiene(index +1, subGroup);
		    int distance = biGraph.getWeigth
			(father.first,index) + father.second;
		    
		    hk[i][bitMap.getNumber(subGroup)] =
			new Pair(index,distance);

		    return hk[i][bitMap.getNumber(subGroup)];
		}
		
	    }
	    subGroup[i] = true;
	}
    }
    //                                    Index
    //El pair final a retornar es el de [0,{1,2,3}];
    private Pair<int,int> seLeTiene(int index,boolean [] subGroup){


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

	if(bitMap.getLength() == 0){
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

	    distance += biGraph.getWeigth
		(node_Vertex,index);

	    /* 
	     * Listo patron.
	     * Y entonces? se va a guardar solo?
	     * CUADREME ESO YA MISMO!.
	     */

	    Pair<int, int > newBaby =
		new Pair<int,int>(node_Vertex, distance);

	    hk[index][node_Vertex] = newBaby;
	    return newBaby;
		 
	}
	
	/*
	 * Ahhh no esta calculado, comencemos
	 * a descomponerlo.
	 */
	    
	ArrayList<Pair<int,int>> results =
	    new ArratList<Pair<int,int>>();
	
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
		Pair <int,int> newPair = seLeTiene(newIndex,subGroup);
		/*
		 * Jefe, despejado..
		 * Listo, consruyan el nuevo posible
		 * Vertice, y guardelo como Opcion..
		 * No se les olvide sumar Distancias..
		 */
		distance = diGraph.getWeigth
		    (newIndex, index)+ newPair.second;
		
		
		results.add(new Pair<int,int> (newIndex, distance));
				
	    }

	    

	    subGroup[i] = true;


	}
	
	if(results.size() == 1)
	    return results.get(0);
	
	hk[index][bitMap.getNumber(subGroup)] = getMinimun(results);
	return hk[index][bitMap.getNumber(subGroup)];

    }

    private Pair<int,int> getMinimun(ArrayList<Pair<int,int>> array){
	
	int min = Integer.MAX_VALUE;
	Pair<int,int> minPair;
	int distance = 0;
	
	for(Pair<int,int> pairs : array){

	    distance = pairs.second;
	    
	    if(distance < min){
		minPair = pairs;
		min = distance;
	    }
	}
	

	return minPair;
	
	
    }









    
    public int[][]  getHeld_Karp_Matrix(){
	return hk_M;
    }

    public int  getHeld_Karp_ValueDoingMatrix(){
	held_Karp();
	return jk_M[node_Vertex][jk_M.length];
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

	m_Rows = diGraph.getSize();
	m_Columns = Math.pow(2,m_Rows -1 );
	
	hk_M = new int [m_Rows][m_Columns];
    } 
}

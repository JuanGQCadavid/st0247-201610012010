import java.util.*;

public class MedellinGraphTools {

    private MedellinGraph medalloGraph;
    private ArrayList<NodeContainer>  medalloContainer;

    private ArrayList<NodeContainer> medellinElite;

    
    public MedellinGraphTools(){}
    
    public MedellinGraphTools (MedellinGraph medalloGraph){
	this.medalloGraph = medalloGraph;
	medalloContainer = medalloGraph.getContainerNodes();
	
    }

    /*
     * Este metodo lo que haces es lo siguiente.

     * Escoge los nodos que son iniciales, osea
     * no hay ningun nodo que valla a ellos, pero ellos
     * (los iniciales) si van al menos un nodo.

     * luego computara el reduce partiendo desde ese nodo.

     * La idea es que el reduceMANANGER simplifique todo
     * lo que pueda, pero si hay nodos que no son disponibles
     * desde este nodo inicial, entonces lo hara desde los otros 
     * nodos iniciales, con esto nos aseguramos que todos esten
     * visitados, para colmo al final se rectificara que no falte 
     * ninguno por visitar.
     */
    public void reduceCEO(){
	medellinElite = new ArrayList<NodeContainer>();
	ArrayList<NodeContainer> inital_nodes = getInitialNodes();
	for(NodeContainer actual_initial_node : inital_nodes ){
	    reduceMANANGER(actual_initial_node);
	}

	//ArrayList<NodeContainer> validar =  validar();
	/*

	 * la unica forma que no este validado es que sea
	 * un nodo desconectado, entonces no nos importa.
	if(validar != null)
	    for(NodeContainer pendiente : validar){
		reduceMANANGER(pendiente);
	    }
	*/
    }


    /*
     * Este metodo buscara en el Arreglo original, en el mapa
     * cuales nodos no estan siendo conectados por alguien mas
     * y estos conectan a Alguien, osea un punto de inicio.
     */
    public ArrayList<NodeContainer> getInitialNodes(){

	ArrayList<NodeContainer>inital_nodes = new ArrayList<NodeContainer>();

	for(NodeContainer actualNode: medalloContainer){
	    if((actualNode.getAncestors()).size() == 0 && //Si es un nodo inicial.
	       (actualNode.getSuccessorsEdge()).size() != 0){
		initial_nodes.add(actualNode);
	    }//esto por que no puede estar vacio
	}

	return inital_nodes;

    }
    /*
     * Quien hace la Magia.
     */
    public void reduceMANANGER(NodeContainer initial_node){
	//Inicializacion
	Queue<NodeContainer> the_waiting_list = new LinkedList();
	the_waiting_list.add(initial_node);

	//peek returns null if the queue is alredy empty
	while(the_waiting_list.peek() != null){
	    //Sacamos el primer elemento en la lista
	    NodeContainer me = the_waiting_list.poll();
	    //encontraremos sus hijos
	    ArrayList<NodeContainer> my_childrens = me.getSuccessorsEdge();
	    // Veamos si son doble calsada o unidireccional
	    ArrayList<Pair<NodeContainer, boolean>> those_Mather_Fuckers =
		identifyThoseMatherFuckers(my_childrens, me);
	    /*
	     * no estamos interesados en saber si mis hijos son
	     * una intercepcion, de eso se dara cuenta mi esclavo y
	     * me lo retornara tal ccual, y yo hare la conexion 
	     * solo me importa saber como estamos el y yo de direcciones
	     * (su sentido) Para que mi esclavo pueda trabajar bien.
	     */


	    /*
	     * Ahora, ya tenemos mis hijos y sus direcciones, el esclavo
	     * sera el responsable de entregarme el ultimo nodo al cual
	     * puedo reducir, me conecto con el y lo guardo en la cola,
	     * para poder ver mas tarde sus hijos, funciona tipo BFS
	     */
	    for(Pair<NodeContainer,boolean> one_of_those_mather_fuckers :
		    those_Mather_Fuckers){

		NodeContainer the_mather_fucker =
		    one_of_those_mather_fuckers.getKey();
		boolean the_mather_fuckers_direction =
		    one_of_those_mather_fuckers.getValue();
		/*
		 * Now I'm gonna get the most possible node
		 * how could be reach by reducing the path
		 * betweent my soon and he.
		 * Yes, i'm gonna forget my soon
		 * If god wish
		 */
		
		/*
		 * my newest soon comes without the connection
		 * from how was before on the path that connects him. 
		 */
		NodeContainer my_new_soon_reduce =
		    reduceSLAVE(the_mather_fucker,
				the_mather_fuckers_direction, me);
		/*
		 * So, i'm going to make the connections.
		 */

		/*
		 * now i have 2 ideas, one is to connect then here and
		 * add them here; or, by the way i'm finding the new soon
		 * I go elimiating the middle nodes, from connections to
		 * ArrayList place. I'm gonna do the second one. 
		 */

		/*
		 * Now we can supposed that the middle nodes
		 * are dead and I have the connection with my
		 * new soon, so.. Lets just add him to the Queue.
		 */
		the_waiting_list.add(my_new_soon_reduce);
	    }
	}	
	
	
    }

    /*
     * Este metodo cataloga cada hijo,
     * si es unidireccional sera 0, de lo
     * contrario sera 1;
     */
    public ArrayList<Pair<NodeContainer, boolean>>
	identifyThoseMatherFuckers(ArrayList<NodeContainer> my_childrens,
				   NodeContainer me){
	
	ArrayList<Pair<NodeContainer, boolean>> result =
	    new ArrayList<Pair<NodeContainer, boolean>>();
	
	//Por cada hijo, voy a ver su estado
	for(NodeContainer my_actual_child : my_childrens){
	    //Primero miraremos si es de doble via
	    boolean done = false;
	    for(NodeContainer grand_ch: my_actual_child.getSuccessorsEdge()){
		// Si alguno de mis nietos, soy yo, entonces es doble via
		if(grand_ch == me){
		    result.add(new Pair<NodeContainer,boolean>(my_actual_child, true));
		    //Ya sabemos que eres!
		    done = true;
		    break;
		}
		    
	    }
	    //lo encontramos?
	    if(!done)
		//no? pues debe ser solo una via
		result.add(new Pair<NodeContainer,boolean>(my_actual_child, false));
	    
	    
	}
	//We're done.
	return result;
	
    }

    /*
     * Why am i the Slave? :'(
     *
     * So, my goal is:
     * Find the Longest node container on the path that could
     * be reduce; by the time, kill the middle mathe fuckers by
     *     * The connections between them
     *     * The ArrayList place
     * 
     */
    public NodeContainer reduceSLAVE(NodeContainer the_mather_fucker,
				     boolean the_mather_fuckers_direction,
				     NodeContainer me){
	//if(the_mather_fuckers_direction){// that means if it's double way

	NodeContainer my_new_successor;
	
	if(the_mather_fuckers_direction)//That means if it's doublle way
	    my_new_successor = slave_Double(the_mather_fucker, me);
	else
	    my_new_successor = slave_One(the_mather_fucker,me);	

	
	
    }
    
    public NodeContainer reduce_One(NodeContainer the_mather_fucker, NodeContainer me){

	NodeContainer actual_Container = the_mather_fucker;
	NodeContainer nodeTemp;
	ArrayList<Edge<NodeContainer,String>> actual_Container_successors;
        ArrayList<Edge<NodeContainer,String>> actual_Container_ancestor;
	
	while(true){
	    
	    actual_Container_successors =
		the_mather_fucker.getSuccessorsEdge();
	    actual_Container_ancestor =
		the_mather_fucker.getAncestors();
		
	    if(actual_Container_successors.size() > 1)
		return actual_Container;
	    if(actual_Container_ancestor.size() > 1)
		return actual_Container;
	    
	    actual_Container = actual_Container_successors.get(0);
	    
	    
	    
	}

    }
    
    public void setMedellinGraph(MedellinGraph medalloGraph){
	this.medalloGraph = medalloGraph;
	medalloContainer = medalloGraph.getContainerNodes();
    }

    public void  nodesDisconnected(){
	int countA = 0,
	    countD = 0;
	String disconeccted = "",
	    ancestors = "";
	
	for(NodeContainer nodeC : medalloContainer){
	    
	     if((nodeC.getAncestors()).size() == 0 &&
		(nodeC.getSuccessorsEdge()).size() != 0){

		 countA ++;
		 ancestors  += "Without anc: " +
		     (nodeC.getBaseNode()).getIdNodeString()
		     + "\n";
	     }
	}
    
	    /* if((nodeC.getAncestors()).size() == 0 &&
	       ( nodeC.getSuccessorsEdge()).size() == 0){

		disconeccted += "Disconected: " +
		    ( nodeC.getBaseNode()).getIdNodeString()
		    + "\n";
		countD++;
	    }
	    /*
	       
	    
	}
	    */
    

	System.out.println("Total nodes: " + medalloContainer.size());
	System.out.println("Anc Count:" + countA + "\n" + ancestors);
	
	//System.out.println("Disc Count:" + countD  + "\n" + disconeccted);
	
	
    }
    public void checkIfAllIsConnected(){
	

    }

}

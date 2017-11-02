import java.util.*;
import java.text.*;
import java.lang.Math.*;
public class MedellinGraph{
    private NodeContainer nodeStart;

    //Hash Table per Names "EAFIT", "UPB"
    private ArrayList<Pair> hashNames;

    private ArrayList<ArrayList<NodeContainer>> hashCordenadas;
    
    private ArrayList<NodeContainer> containerNodes;

    private int MAX_NODE = 60175732;


    //Edges
    private ArrayList<Edge> medellinEdgs;
    private ArrayList<Pair> hashEdgeNames;
    
    
    public MedellinGraph(){
	containerNodes = new ArrayList<NodeContainer>();
	hashNames = new ArrayList<Pair>();
	nodeStart = null;
	startHashMap();
    }

    public MedellinGraph(NodeContainer nodeStart){
	containerNodes = new ArrayList<NodeContainer>();
	hashNames = new ArrayList<Pair>();
        addContanierNode(nodeStart);
	this.nodeStart = nodeStart;
	startHashMap();
    }

    public void startHashMap(){
	hashCordenadas = new ArrayList<ArrayList<NodeContainer>>();

	for(int i = 0; i <= 100; i++){
	    hashCordenadas.add(new ArrayList<NodeContainer>());
	}
    }

    public void organizePerCordenadas(NodeContainer newNodeCont){
	Node node_in_container = newNodeCont.getBaseNode();

	double cX = node_in_container.getCordenadaX();
	double cY = node_in_container.getCordenadaY();
	int head = (int)(cX);
	
	int index =(int) ( (cX - head) * 100 );

	(hashCordenadas.get(index)).add(newNodeCont);
	
    }

    public int a_star(NodeContainer node_from, NodeContainer node_to){
	ArrayList<PairH<NodeContainer,Integer>> next = new
	    ArrayList<PairH<NodeContainer,Integer>>();

	next.add(new PairH<NodeContainer,Integer>(node_from,0));

	while(next.size() > 0){
	    PairH<NodeContainer,Integer> actualPair = next.get(0);
	    //OJOOOOOOOOOOOOOOO
	    if(actualPair.first == node_to)
		return actualPair.second;

	    for(NodeContainer nodes :
		    node_from.getSuccessorsContainer()){
		next.add(new PairH<NodeContainer,Integer>
			 (nodes,actualPair.second + 1));
		
	    }

	    next = ordernarArray(next, node_from, node_to);
	}

	return -1;

    }
    //Pair of Node, Distance
    public ArrayList<PairH<NodeContainer, Integer>> ordernarArray
	(ArrayList<PairH<NodeContainer, Integer>> next,
	 NodeContainer node_from,
	 NodeContainer node_to){

	double toX = (node_to.getBaseNode()).getCordenadaX();
	double toY = (node_to.getBaseNode()).getCordenadaY();
	double fromX = 0,
	    fromY = 0;
	int index = 1;
       
	double distanceHere;
	
	double distance  = Double.MAX_VALUE;

        ArrayList<PairH<NodeContainer, Integer>> result = new
	    ArrayList<PairH<NodeContainer, Integer>>();

	double leng [] = new double[next.size()]; 
	boolean visited [] = new boolean[next.size()];


	//Le sacamos la distancia de cada nodo con respecto al
	// nodo a buscar
	
	for(int p = 1; p < next.size(); p++){
		
	    fromX = (((next.get(p)).first).getBaseNode()).getCordenadaX();
	    fromY = (((next.get(p)).first).getBaseNode()).getCordenadaY();

	    distanceHere = Math.abs(toX - fromX)  +
		Math.abs(toY - fromY);
	    
	    leng[p] = distanceHere;
	    visited[p] = false;
	}


	//los ordenaremos de menor distancia a mayor
	
	for(int i = 1; i < next.size(); i++){
	    for(int j = 1; j < next.size(); j++){
		if(leng[j] < distance && !visited[j]){
		    distance = leng[j];
		    index = j;
		}
	    }
	    visited[index] = true;
	    result.add(next.get(index));
	    distance = Double.MAX_VALUE;
	}
	// no se que pasa con el index
	return result;
	
	// | Xo - X | + |Yo - Y|
	
    } 

    public NodeContainer foundPerCordenadas(double cX, double cY){
	//FALTA
       
	int head = (int)(cX);
	
	int index =(int) ( (cX - head) * 100 );

	ArrayList<NodeContainer> possible
	    = hashCordenadas.get(index);
	double distance = Double.MAX_VALUE;
	NodeContainer isThis = null;
	
	for(NodeContainer nodeAc : possible ){
	    double cXN = (nodeAc.getBaseNode()).getCordenadaX();
	    double cYN = (nodeAc.getBaseNode()).getCordenadaY();
	    
	    if (cXN == cX && cYN == cY){
		return nodeAc;

	    }else{
		double distanceHere = Math.abs(cX - cXN)  +
		    Math.abs(cY - cYN);
		if(distanceHere < distance){
		    distance = distanceHere;
		    isThis = nodeAc;
		}
		
	    }
	   
	}
	return isThis;
	
	
    }
    public void addContanierNode(NodeContainer newContainer){
	containerNodes.add(newContainer);
	Node baseNode = newContainer.getBaseNode();
	//Hash name
	organizePerName(newContainer,baseNode.getName());
	organizePerCordenadas(newContainer);
	//implemantar Tabla Hash.
    }
    
    
    public void connectContainer(double idContainerFrom,
				 double idContainerTo,
				 double distance,
				 String name){
	
	NodeContainer nodeContainerFrom = foundNodeContainer
	    (idContainerFrom);
	
	NodeContainer nodeContainerTo = foundNodeContainer
	    (idContainerTo);
	

	if(nodeContainerTo == null || nodeContainerFrom == null){
	    System.err.println("IMPOSSIBLE! ONE OF THEN DOESN'T EXIST");
	    return;
	}

	
	nodeContainerFrom.addSuccessor(new Edge(nodeContainerTo,
						distance,
						name));
	nodeContainerTo.addAncestors(new Edge (nodeContainerFrom,
					       distance,
					       name));
    }

    public NodeContainer foundNodeContainer(double idNodeContainer){
	//https://stackoverflow.com/questions/9102318/cast-double-to-integer-in-java
	
	int result =(int) idNodeContainer - MAX_NODE;
	NodeContainer nodeContainer;
	
	if(result < containerNodes.size()){
	     nodeContainer = containerNodes.get(result);
	    
	    if(nodeContainer.getIdContainer() != idNodeContainer)
		nodeContainer = lookForNodeContainer(idNodeContainer);
	    
	}else
	    nodeContainer =
		lookForNodeContainer(idNodeContainer);
	
	return nodeContainer;

    }



    //https://ideone.com/rnCxcP -> For Test Propouse.
    public NodeContainer lookForNodeContainer (double idContainerLookFor){
	
	NodeContainer result;

	int indexL = 0, indexR = containerNodes.size(),Operation = 0;
	
	
	while(containerNodes.get(Operation).getIdContainer() !=
	      idContainerLookFor){

	    Operation = ((indexR-indexL)/2) + indexL;
	    if(Operation <= 0)return null;
	    
	    if(idContainerLookFor <=
	       containerNodes.get(Operation).getIdContainer()){
		indexR = Operation;
	    }else{
		indexL = Operation; 
	    }
	    
	    
	}

	result = containerNodes.get(Operation);
	return result;
    }

    public void addNodeToContainerNode(double idNode, double cordenadaY,
				       double cordenadaX, String name){
	//Create.
	NodeContainer newNodeCont = new NodeContainer
	    (idNode, cordenadaY, cordenadaX, name);

	//Add.
	containerNodes.add(newNodeCont);

	//Hash
	organizePerName(newNodeCont, name);
	organizePerCordenadas(newNodeCont);
    }

    public void organizePerName(NodeContainer newNodeC, String nameBase){
	for(Pair pair : hashNames){
	    if(nameBase.equals(pair.getKey())){
		pair.addNodeContainer(newNodeC);
		return;
	    }
	}

	//Add the new Name

	Pair newPair = new Pair(nameBase, newNodeC);

	hashNames.add(newPair);

	
    }

    public ArrayList<NodeContainer> getContainerNodes(){
	return containerNodes;
    }

    
    
    


}

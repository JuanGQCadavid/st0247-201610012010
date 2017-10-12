import java.util.*;
import java.text.*;
public class MedellinGraph{
    private NodeContainer nodeStart;

    //Hash Table per Names "EAFIT", "UPB"
    private ArrayList<Pair> hashNames;

    private ArrayList<NodeContainer> containerNodes;

    private int MAX_NODE = 60175732;


    //Edges
    private ArrayList<Edge> medellinEdgs;
    private ArrayList<Pair> hashEdgeNames;
    
    
    public MedellinGraph(){
	containerNodes = new ArrayList<NodeContainer>();
	hashNames = new ArrayList<Pair>();
	nodeStart = null;
    }

    public MedellinGraph(NodeContainer nodeStart){
	containerNodes = new ArrayList<NodeContainer>();
	hashNames = new ArrayList<Pair>();
        addContanierNode(nodeStart);
	this.nodeStart = nodeStart;
    }

    
    public void addContanierNode(NodeContainer newContainer){
	containerNodes.add(newContainer);
	Node baseNode = newContainer.getBaseNode();
	organizePerName(newContainer,baseNode.getName());
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


    public void addEdge(NodeContainer NodeC,double distance,
			String name){
	//??

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

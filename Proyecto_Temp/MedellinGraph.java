import java.util.*;

public class MedellinGraph{
    private NodeContainer nodeStart;

    //Hash Table per Names "EAFIT", "UPB"
    private ArrayList<Pair> hashNames;

    private ArrayList<NodeContainer> containerNodes;
    
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
	
	
	return;
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

    public void testConections(){
	String result = "";
	for(NodeContainer actualNode: containerNodes){
	    Node baseNode = actualNode.getBaseNode();
	    result += "ID -> " + baseNode.getIdNodeString() +
			       "Y -> " + baseNode.getCordenadaY() +
			       "X -> " + baseNode.getCordenadaX()
		+ "/n";

	    
	}
	System.out.println(result);
    }


    


}

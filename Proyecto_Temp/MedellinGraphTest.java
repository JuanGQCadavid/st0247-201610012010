import java.util.*;

public class MedellinGraphTest{

    private MedellinGraph medalloGraph;
    
    public MedellinGraphTest( MedellinGraph medalloGraph){
	this.medalloGraph = medalloGraph;
    }
    public MedellinGraphTest(){}
    
    public  void testNodes(){
	printDataFromContainer( medalloGraph.getContainerNodes() );
	
	return;
    }

    public void testConnections(double idContainer){
	NodeContainer nodeContainer = medalloGraph.lookForNodeContainer
	    (idContainer);

	ArrayList<NodeContainer> successors =
	    nodeContainer.getSuccessorsContainer();
	ArrayList<NodeContainer> ancestors =
	    nodeContainer.getAncestorsContainer();

	System.out.println("--- Successors ---");
	printDataFromContainer(successors);
	
	System.out.println("--- Ancestors ---");
	printDataFromContainer(ancestors);
    }

    public void printDataFromContainer(ArrayList<NodeContainer> arrayNodes){
	for(NodeContainer actualNode: arrayNodes){
	    
	    Node baseNode = actualNode.getBaseNode();
	    System.out.println( "ID -> " + baseNode.getIdNodeString() +
			       " Y -> " + baseNode.getCordenadaY() +
				" X ->" + baseNode.getCordenadaX());

	}

	
    }

    public void setMedellinGraph(MedellinGraph medellinGraph){
	medalloGraph = medellinGraph;
    }


}

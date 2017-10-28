import java.util.*;

public class NodeContainer{
    private double idContainer;
    /*
     * 0 - No Deffined
     * 1 - only one direction
     * 2 - Bi-Directional
     */
    private int type;
    private Node nodeBase;
    //Esta variable es solo por el metodo de Reducir
    private boolean visited;

    private ArrayList<Edge<NodeContainer,String>> successors;
    private ArrayList<Edge<NodeContainer,String>> ancestors;


    public NodeContainer(double idNode, double cordenadaY,
			 double cordenadaX,String nombre){
	
	this.nodeBase = new Node(idNode, cordenadaY,
				 cordenadaX, nombre);
	this.idContainer = idNode;
	this.type = 0;

	successors = new ArrayList<Edge<NodeContainer,String>>();
	ancestors = new ArrayList<Edge<NodeContainer,String>>();

    }

    public NodeContainer(Node nodeBase){
	
	this.nodeBase = nodeBase;
	this.idContainer = nodeBase.getIdNode();
	this.type = 0;

	successors = new ArrayList<Edge<NodeContainer,String>>();
	ancestors = new ArrayList<Edge<NodeContainer,String>>();

    }

    public double getIdContainer(){
	return idContainer;
    }
    public void setIdContanier(double idContainer){
	this.idContainer = idContainer;
    }

    public int getType(){
	return type;
    }
    public void setType(int type){
	this.type = type;
    }

    public Node getBaseNode(){
	return nodeBase;
    }
    public void setBaseNode(Node nodeBase){
	this.nodeBase = nodeBase;
    }


    public ArrayList<NodeContainer> getSuccessorsContainer(){
	ArrayList<NodeContainer> nodes = new
	    ArrayList<NodeContainer>();

	for(Edge<NodeContainer,String> edge: successors){
	    nodes.add(edge.getEdgeNodeContainer());
	}

	return nodes;
    }

    
    public ArrayList<Edge<NodeContainer,String>> getSuccessorsEdge(){
	return successors;
    }
    public void addSuccessor(Edge<NodeContainer,String> newNode){
	successors.add(newNode);
    }


    public ArrayList<NodeContainer> getAncestorsContainer(){
	ArrayList<NodeContainer> nodes = new
	    ArrayList<NodeContainer>();

	for(Edge<NodeContainer,String> edge: ancestors){
	    nodes.add(edge.getEdgeNodeContainer());
	}

	return nodes;
    }
    
    public ArrayList<Edge<NodeContainer,String>> getAncestors(){
	return ancestors;
    }
    public void addAncestors(Edge<NodeContainer,String> newNode){
	ancestors.add(newNode);
    }
    


}

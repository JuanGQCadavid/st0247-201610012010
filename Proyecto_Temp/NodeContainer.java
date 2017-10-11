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

    private ArrayList<Edge> successors;
    private ArrayList<Edge> ancestors;


    public NodeContainer(double idNode, double cordenadaY,
			 double cordenadaX,String nombre){
	
	this.nodeBase = new Node(idNode, cordenadaY,
				 cordenadaX, nombre);
	this.idContainer = idNode;
	this.type = 0;
	this.successors = null;
	this.ancestors = null;

    }

    public NodeContainer(Node nodeBase){
	
	this.nodeBase = nodeBase;
	this.idContainer = nodeBase.getIdNode();
	this.type = 0;
	this.successors = null;
	this.ancestors = null;

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

    public Node getNodeBase(){
	return nodeBase;
    }
    public void setNodeBase(Node nodeBase){
	this.nodeBase = nodeBase;
    }


    public ArrayList<NodeContainer> getSuccessorsContainer(){
	ArrayList<NodeContainer> nodes = new
	    ArrayList<NodeContainer>();

	for(Edge edge: successors){
	    nodes.add(edge.getEdgeNodeContainer());
	}

	return nodes;
    }

    
    public ArrayList<Edge> getSuccessorsEdge(){
	return successors;
    }
    public void addSuccessor(Edge newNode){
	successors.add(newNode);
    }


    public ArrayList<NodeContainer> getAncestorsContainer(){
	ArrayList<NodeContainer> nodes = new
	    ArrayList<NodeContainer>();

	for(Edge edge: ancestors){
	    nodes.add(edge.getEdgeNodeContainer());
	}

	return nodes;
    }
    
    public ArrayList<Edge> getAncestors(){
	return ancestors;
    }
    public void addAncestors(Edge newNode){
	ancestors.add(newNode);
    }
    


}

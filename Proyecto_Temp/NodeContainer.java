import java.util.*;
import Node;

public class NodeContainer{
    private double idContainer;
    /*
     * 0 - No Deffined
     * 1 - only one direction
     * 2 - Bi-Directional
     */
    private int type;
    private Node nodeBase;

    private Arraylist<Edge> successors;
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

    public int getIdContainer(){
	return idContainer;
    }
    public void setIdContanier(int idContainer){
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

    public ArrayList<Node> getSuccessors(){
	return successors;
    }
    public void addSuccessor(Node newNode){
	this.successor.add(newNode);
    }
    public ArrayList<Node> getAncestors(){
	return ancestors;
    }
    public void addAncestors(Node newNode){
	this.ancestors.add(newNode);
    }
    


}

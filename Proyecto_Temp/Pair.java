import java.util.*;
/*
 * The main propuse of this class
 * is to work like a Hash.
 * This class save all the Nodes which
 * name is the Same.
 *
 * Example: Every Node with the name EAFIT will be together with
 * the Key EAFIT.
 *
 */


public class Pair{
    private String nameKey;
    private ArrayList<NodeContainer> nodesContainers;

    public Pair(String nameKey, ArrayList<NodeContainer> nodesContainers ){
	this.nameKey = nameKey;
	this.nodesContainers = nodesContainers;
    }


    public Pair(String nameKey ){
	this.nameKey = nameKey;
        nodesContainers = new ArrayList<NodeContainer>();
    }


    public Pair(String nameKey, NodeContainer newNode){
	this.nameKey = nameKey;
        nodesContainers = new ArrayList<NodeContainer>();
	nodesContainers.add(newNode);
    }

    public void setKey(String nameKey){
	this.nameKey = nameKey;
    }

    public String getKey(){
	return nameKey;
    }

    public void addNodeContainer(NodeContainer newNode){
	nodesContainers.add(newNode);
    }

    public NodeContainer getFirstNodeContainer(){
	if(nodesContainers == null) return null;
	if(nodesContainers.size()==0)return null;

	return nodesContainers.get(0);
    }
}


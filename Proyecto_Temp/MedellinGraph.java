import java.util.*;
import javafx.util.*;
import NodeContainer;
import Node;

public class MedellinGraph{
    private Node nodeStart;

    //Hash Table per Names "EAFIT", "UPB"
    private ArrayList<Pair<String, Node>> hashNames;

    private ArrayList<NodeContainer> containerNodes;
    
    public MedellinGraph(){}

    public void addContanierNode(NodeContainer newContainer){
	this.containerNodes.add(newContainer);

	//implemantar Tabla Hash.
    }
    public void connectContainer(double idContainerFrom,
				 double idContainerTo,
				 double distance,
				 String name){
	
	

    }


}

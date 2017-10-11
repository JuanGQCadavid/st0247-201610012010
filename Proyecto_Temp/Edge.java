
public class Edge {
    private NodeContainer edgeNodeContainer;
    private double edgeLength;
    private String edgeName;

    public Edge(NodeContainer edgeNodeContainer,
		double edgeLength,
		String edgeName){
	this.edgeNodeContainer = edgeNodeContainer;
	this.edgeLength = edgeLength;
	this.edgeName = edgeName;
    }

    public void setNodeContainer(NodeContainer nodeContainer){
	this.edgeNodeContainer = nodeContainer;
    }


    public NodeContainer getEdgeNodeContainer(){
	return edgeNodeContainer;
    }



    public void setEdgeLength(double edgeLength){
	this.edgeLength = edgeLength;
    }


    public double getEdgeLength(){
	return edgeLength;
    }


    public void setEdgeName(String edgeName){
	this.edgeName = edgeName;
    }


    public String getEdgeName(){
	return edgeName;
    }
    

    

}

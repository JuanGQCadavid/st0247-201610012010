public class Edge<ObjectContainer, ObjectName> {
    private ObjectContainer edgeNodeContainer;
    private double edgeLength;
    private ObjectName edgeName;

    public Edge(ObjectContainer edgeNodeContainer,
		double edgeLength,
		ObjectName edgeName){
	this.edgeNodeContainer = edgeNodeContainer;
	this.edgeLength = edgeLength;
	this.edgeName = edgeName;
    }

    public void setNodeContainer(ObjectContainer nodeContainer){
	this.edgeNodeContainer = nodeContainer;
    }


    public ObjectContainer getEdgeNodeContainer(){
	return edgeNodeContainer;
    }



    public void setEdgeLength(double edgeLength){
	this.edgeLength = edgeLength;
    }


    public double getEdgeLength(){
	return edgeLength;
    }


    public void setEdgeName(ObjectName edgeName){
	this.edgeName = edgeName;
    }


    public ObjectName getEdgeName(){
	return edgeName;
    }
    

    

}

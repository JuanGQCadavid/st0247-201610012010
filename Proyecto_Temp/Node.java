

public class Node{
    private double idNode;
    private double cordenadaY;
    private double cordenadaX;
    private String nombre;

    public Node(double idNode, double cordenadaY, double cordenadaX,
		String nombre){
	this.idNode = idNode;
	this.cordenadaY = cordenadaY;
	this.cordenadaX = cordenadaX;
	this.nombre = nombre;

    }

    public double getIdNode(){
	return idNode;
    }
    public void setIdNode(double idNode){
	this.idNode = idNode;
    }


    public double getCordenadaY(){
	return cordenadaY;
    }
    public void setCordenadaY(double cordenadaY){
	this.cordenadaY = cordenadaY;
    }


    public double getCordenadaX(){
	return cordenadaX;
    }
    public void setCordenadaX (double cordenadaX){
	this.cordenadaX = cordenadaX;
    }

    public String getNombre(){
	return nombre;
    }
    public void setNombre(String nombre){
	this.nombre = nombre;
    }



    
    
	

}

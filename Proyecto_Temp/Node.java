import java.util.*;
import java.text.*;

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
    public String  getIdNodeString(){
	/*
	 * Code provide by https://stackoverflow.com/questions/16098046/how-to-print-double-value-without-scientific-notation-using-java
	 */
	
	DecimalFormat df = new DecimalFormat("#");
	df.setMaximumFractionDigits(0);
	String result = df.format(idNode);
	return result;
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

    public String getName(){
	return nombre;
    }
    public void setName(String nombre){
	this.nombre = nombre;
    }
    



    
    
	

}

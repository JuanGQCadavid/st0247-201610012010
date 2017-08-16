import java.util.*;
/**
 * Write a description of class Nodos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nodo

{
    private double idNode;
    private double cordenadaX;
    private double cordenadaY;
    
    public Nodo(double idNode, double cordenadaX, double cordenadaY) {
        this.idNode = idNode;
        this.cordenadaX = cordenadaX;
        this.cordenadaY = cordenadaY;
    }

    public Nodo() {
    }

    public double getIdNode() {
        return idNode;
    }

    public void setIdNode(double idNode) {
        this.idNode = idNode;
    }

    public double getCordenadaX() {
        return cordenadaX;
    }

    public void setCordenadaX(double cordenadaX) {
        this.cordenadaX = cordenadaX;
    }

    public double getCordenadaY() {
        return cordenadaY;
    }

    public void setCordenadaY(double cordenadaY) {
        this.cordenadaY = cordenadaY;
    }
    
    
    
    
    
}

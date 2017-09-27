import java.util.*;
/**
 * Write a description of class Pairs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pairs
{
    private Nodo nodoBase;
    //private ArrayList<ArrayList<Arco>> hashNodes;
    private ArrayList<Arco> hashNodes;
    private double idNodeBase;

    
    public Pairs(Nodo nodoBase,ArrayList<Arco> hashNodes) {
        this.nodoBase = nodoBase;
        this.hashNodes = hashNodes;
        this.idNodeBase = nodoBase.getIdNode();
       
    }
    
    public Pairs(Nodo nodoBase) {
        this.nodoBase = nodoBase;
        this.hashNodes = new ArrayList<Arco>();
        this.idNodeBase = nodoBase.getIdNode();
    }
    
    public void addNodeFromMe(Double idNodeTo, Double length, String name){
        hashNodes.add(new Arco(idNodeTo, length,name));
        
    }
    
  
  
    public Nodo getNodoBase() {
        return nodoBase;
    }

    public void setNodoBase(Nodo nodoBase) {
        this.nodoBase = nodoBase;
    }

    public ArrayList<Arco> getHashNodes() {
        return hashNodes;
    }

    public void setHashNodes(ArrayList<Arco> hashNodes) {
        this.hashNodes = hashNodes;
    }
}

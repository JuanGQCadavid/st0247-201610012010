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
    private ArrayList<ArrayList<Arco>> hashNodes;

    
    public Pairs(Nodo nodoBase,ArrayList<ArrayList<Arco>> hashNodes) {
        this.nodoBase = nodoBase;
        this.hashNodes = hashNodes;
    }
    
    public Pairs(Nodo nodoBase) {
        this.nodoBase = nodoBase;
        this.hashNodes = new ArrayList<ArrayList<Arco>>();
    }
  
  
    public Nodo getNodoBase() {
        return nodoBase;
    }

    public void setNodoBase(Nodo nodoBase) {
        this.nodoBase = nodoBase;
    }

    public ArrayList<ArrayList<Arco>> getHashNodes() {
        return hashNodes;
    }

    public void setHashNodes(ArrayList<ArrayList<Arco>> hashNodes) {
        this.hashNodes = hashNodes;
    }
}

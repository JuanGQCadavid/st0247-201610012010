
/**
 * Clase Pareja para poder hacer una lista que tenga dos valores en sus nodos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pareja
{
    private int vertice;
    private int peso;
    /*
     * @param int v -> nodo Vertice.
     * @param int p -> peso para llegar al nodo vertice.
     * 
     * constructor por defecto.
     * 
     */
    public Pareja(int v,int p) {vertice = v; peso = p;}
    
    
    /*
     * Retorna el vertice
     * 
     * @return int vertice;
     */
    public int  getVertice(){
        return vertice;
    }
    
    /*
     * Retorna el peso
     * 
     * @return int peso;
     */
    public int getPeso(){
        return peso;
    }
    
    /*
     * @param int vertice -> Nodo vertice.
     * 
     * establece el valor al nodo Vertice.
     */
    public void setVertice(int vertice){
        this.vertice = vertice;
    }
    
    /*
     * @param int vertice -> valor del Peso al nodo vertice.
     * 
     * establece el valor a peso.
     */
    public void setPeso(int peso){
        this.peso = peso;
    }
    
    
}

import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * 
 * @author Mauricio Toro & Juan Gonzalo Quiroz Cadavid
 * @version 1
 */
public class DigraphAM extends Graph
{
   private int graphAM[][]; 
   
   /*
    * @param int size -> Indica el tamaño de la Matriz de Adj.
    * 
    * Este Constructor creara la Matriz de tamaño @param size
    */
   public DigraphAM(int size){
       super(size);
       graphAM = new int[size][size];
   }
   
   
   /*
    * @param int source -> El indice del nodo base.
    * @param int destination -> El indice del nodo conectado con el base.
    * 
    * Calcula el tamaño del arco que hay entre 
    * el nodo source y el nodo destination.
    * 
    * @return int tamaño del arco de conexion entre ambos nodos.
    */
   public int getWeight(int source, int destination)
   {
       return graphAM[source][destination];
   }
   
   
   /*
    * @param int source -> indice del nodo base.
    * @param int destination -> indice del nodo a conectar con el nodo base.
    * @param int weigth -> valor de la longitud del arco entre ambos nodos.
    * 
    * addArc Hace la coneccion entre el nodo source y
    * el nodo destination, añadiendole a ese arco el valor
    * de weight.
    */
   
   public void addArc(int source, int destination, int weight)
   {
       graphAM[source][destination] = weight;
   }
   
   
  /*
   * @param int vertex -> El indice del nodo base.
   * 
   * getSuccessors obtiene todo los indices de los nodos
   * sucesores que tiene el nodo base, los introduce en
   * un array list.
   * 
   * @return ArrayList<Integer> de todos los indices de nodos sucesores.
   */
   public ArrayList<Integer> getSuccessors(int vertex)
   {
       //Array list con todos los sucesores de Vertex
       ArrayList<Integer> successors = new ArrayList<Integer>();
       //Obtendremos todos los indicadores vertices 
       for(int index = 0; index < graphAM.length; ++index){
           //Si el valor del arco es 0 entonces no hay conexion.
           if(graphAM[index][0] > 0)successors.add(index);
       } 
       
       return successors;
   }
}

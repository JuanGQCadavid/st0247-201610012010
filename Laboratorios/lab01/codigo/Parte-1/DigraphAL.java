import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 * 
 * @author Juan Gonzalo Quiroz Cadavid, Mauricio Toro 
 * @version 1
 */
public class DigraphAL extends Graph
{
   ArrayList<ArrayList<Pareja>> graphAL;
   /*
    * @param size -> La cantidad de nodos del grafo.
    * Almacena los nodos desde 0 a size-1.
    * 
    * Nota: Este paso es importante para no tener
    * errores mas adelante al apuntar a un espacio
    * no declarado.
    * 
    */
   public DigraphAL(int size)
   {
       super(size);
       graphAL = new ArrayList<ArrayList<Pareja>>();
       for(int index=0; index < size; ++index){
           //Creamos uno nuevo cada iteracion para qeu despues cuando
           //se modofique el arrayList no se modifique en general.
           ArrayList<Pareja> graphAUX = new ArrayList<Pareja>();
           graphAL.add(graphAUX);
       }
     
   }
   
   
   /*
    * @param source -> indice Nodo base.
    * @param destination -> indice Nodo a conectar con nodo base.
    * @param weigth -> valor de la longitud del arco.
    * 
    * Se generara un vinculo de Nodo base a Nodo destino.
    * 
    */
   public void addArc(int source, int destination, int weight)
   {
       //Obtenemos el ArrayList de todos los sucesores de source.
       ArrayList<Pareja> arrayAUX = graphAL.get(source);
       
       //creamos la pareja Destino - Tamaño
       Pareja nuevaPareja = new Pareja(destination,weight);
       //Verificamops que no este la pareja.
       if(!arrayAUX.contains(nuevaPareja)){
          
           //Añadimos la nueva pareja
           arrayAUX.add(new Pareja(destination,weight));
           //Actualizamos el arrayList.
           graphAL.set(source,arrayAUX);
       }else{
           System.out.println("Hmmm");
       }
       
   }
   
    
   
   public int getWeight(int source, int destination)
   {
      ArrayList<Pareja> arregloParejas = graphAL.get(source);      
      for(Pareja parejaActual: arregloParejas){
          if(parejaActual.getVertice() == destination) return parejaActual.getPeso();
      }
      return 0;
   }

  
   public ArrayList<Integer> getSuccessors(int vertice)
   {
       ArrayList<Pareja> sucesoresParejas = graphAL.get(vertice);
       ArrayList<Integer> successors = new ArrayList<Integer>();
       for(Pareja parejaActual : sucesoresParejas){
           successors.add(parejaActual.getVertice());
       }
       
       return successors;
   }
}

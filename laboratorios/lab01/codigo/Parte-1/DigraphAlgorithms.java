import java.util.ArrayList;
import java.util.Arrays;
/**
 * This class contains algorithms for digraphs
 * Adapted from: http://cs.fit.edu/~ryan/java/programs/graph/Dijkstra-java.html
 * @author Mauricio Toro
 * @version 1
 */
public class DigraphAlgorithms
{
        private static int minVertex (int [] dist, boolean [] v) {
        int x = Integer.MAX_VALUE;
        int y = -1;   // graph not connected, or no unvisited vertices
        for (int i=0; i<dist.length; i++) {
           if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
        }
        return y;
     }
  
     /*
      * @param Graph graph
      * @param int node base.
      * 
      * This Algorihms computed all the Phats from 
      * node Source to every Node into the graph.
      * 
      * and if there are other way to connect one node
      * to another node more fastly, the Algorithm will
      * change the original path to the fasters one
      * 
      * @return int [] preceeding node in path
      * 
      */
      static int [] dijsktra(Graph dg, int source)
      {
          final int [] dist = new int [dg.size()];  // shortest known distance from "s"
          final int [] pred = new int [dg.size()];  // preceeding node in path
          final boolean [] visited = new boolean [dg.size()]; // all false initially

          for (int i=0; i<dist.length; i++) {
               dist[i] = Integer.MAX_VALUE; //Infinity
          }
          
          dist[source] = 0;
      
          for (int i=0; i<dist.length; i++) {
              final int next = minVertex (dist, visited);
              
              if(next == -1) break;
              visited[next] = true;
      
              // The shortest path to next is dist[next] and via pred[next].
      
              final ArrayList<Integer> n = dg.getSuccessors (next); 
              for (int j=0; j<n.size(); j++) {
                 final int v = n.get(j);
                 final int d = dist[next] + dg.getWeight(next,v);
                 if (dist[v] > d) {
                     dist[v] = d;
                     pred[v] = next;
                 }
              }
          }
          return pred;  // (ignore pred[s]==0!)
     }
  
  
       public static ArrayList getPath (int [] pred, int s, int e) {
        final java.util.ArrayList path = new java.util.ArrayList();
        int x = e;
        while (x!=s) {
           path.add (0, x);
           x = pred[x];
        }
        path.add (0, s);
        return path;
     }
 
     // Código para dibujar el grafo en GraphViz
     // Recomiendo www.webgraphviz.com/
     public static void dibujarGrafo(Graph g)
     {
        System.out.println("digraph Grafo {");
        System.out.println("node [color=cyan, style=filled];");
        int nv = g.size();
        for (int i = 0; i < nv; i++)
        {
           ArrayList<Integer> lista = g.getSuccessors(i);
           for (int j = 0; j < lista.size(); j++)
             System.out.println("\"" + i + "\" -> \"" + lista.get(j) + "\" [ label=\""+ g.getWeight(i,lista.get(j)) +"\"];");
        }
        System.out.println("}");
     }
 
 
     public static void main(String[] args)
     {
         DigraphAL biGraphAL = new DigraphAL(5);
         biGraphAL.addArc(0,1,10);
         biGraphAL.addArc(0,2,3);
         biGraphAL.addArc(1,2,1);
         biGraphAL.addArc(1,3,2);
         biGraphAL.addArc(2,1,4);
         biGraphAL.addArc(2,3,8);
         biGraphAL.addArc(2,4,2);
         biGraphAL.addArc(3,4,7);
         biGraphAL.addArc(4,3,9);
        
         
         DigraphAM biGraphAM = new DigraphAM(5);
         biGraphAM.addArc(0,1,10);
         biGraphAM.addArc(0,2,3);
         biGraphAM.addArc(1,2,1);
         biGraphAM.addArc(1,3,2);
         biGraphAM.addArc(2,1,4);
         biGraphAM.addArc(2,3,8);
         biGraphAM.addArc(2,4,2);
         biGraphAM.addArc(3,4,7);
         biGraphAM.addArc(4,3,9);
         
         System.out.println(getPath(dijsktra(biGraphAM,0),0,3)); 
         System.out.println(getPath(dijsktra(biGraphAL,0),0,3));
         
         System.out.println(getPath(dijsktra(biGraphAL,2),2,3));
         System.out.println(getPath(dijsktra(biGraphAM,2),2,3));
         
         
         System.out.println(getPath(dijsktra(biGraphAL,1),1,4));
         System.out.println(getPath(dijsktra(biGraphAM,1),1,4));
         
         DigraphAlgorithms.dibujarGrafo(biGraphAL);
         
     }
    }

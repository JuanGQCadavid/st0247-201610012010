import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Prueba las implementaciones de DigraphAL y DigraphAM con el grafo del
 * documento.
 * 
 * Ejecute esta clase luego de completar las clases DigraphAL y DigraphAM para
 * tener una idea de si su implementacin est� correcta.
 * 
 * @author Mateo Agudelo
 */
public class Test {
    //Son 11 Nodos
    static final int SIZE = 12;
    //Los vertices, son predeterminados.
    static HashSet<Pair<Integer, Integer>> edges;
    //Son los caminos que hay en el grafo predeterminado (Si, son caminos escritos manualmente)
    static ArrayList<Pair<Integer, Integer>> caminos;
    //Nodos aislados.
    static int[] sinEntradas = { 0, 1, 3, 4, 5, 6, 7 };

    public static void main(String[] args) {
        edges = fillEdges();

        DigraphAM gMatrix = new DigraphAM(SIZE);
        fillGraph(gMatrix);
        System.out.println("DigraphAM (Matriz de Adyacencia):");
        System.out.println("    getWeight() -> " + convert(testWeight(gMatrix)));
        System.out.println("    getSuccesors() -> " + convert(testSuccesors(gMatrix)));

        DigraphAL gList = new DigraphAL(SIZE);
        fillGraph(gList);
        System.out.println("DigraphAL (Listas de Adyacencia):");
        System.out.println("    getWeight() -> " + convert(testWeight(gList)));
        System.out.println("    getSuccesors() -> " + convert(testSuccesors(gList)));

        System.out.println("Recorridos:");
        System.out.println("    DFS -> " + convert(testDFS(gList, gMatrix)));
        System.out.println("    BFS -> " + convert(testBFS(gList, gMatrix)));

        caminos = fillCaminos();
        System.out.println("Hay Camino:");
        System.out.println("    DFS -> " + convert(testHayCaminoDFS(gList, gMatrix)));
        System.out.println("    BFS -> " + convert(testHayCaminoBFS(gList, gMatrix)));
    }

    static HashSet<Pair<Integer, Integer>> fillEdges() {
        /*
         * Se hace las coneciones de los nodos
         * manualmente.
         */
        
        //HashSet es una estructura de datos hash con set, es rapida.
        HashSet<Pair<Integer, Integer>> edges = new HashSet<>();
        
        
        edges.add(Pair.makePair(3, 8));
        edges.add(Pair.makePair(3, 10));
        edges.add(Pair.makePair(5, 11));
        edges.add(Pair.makePair(7, 8));
        edges.add(Pair.makePair(7, 11));
        edges.add(Pair.makePair(8, 9));
        edges.add(Pair.makePair(11, 2));
        edges.add(Pair.makePair(11, 9));
        edges.add(Pair.makePair(11, 10));
        return edges;
    }

    static boolean fillGraph(Digraph g) {
        
        if (edges == null || g == null)
            return false;
        for (Pair<Integer, Integer> p : edges)
            g.addArc(p.first, p.second, 1);
        return true;
    }

    static boolean testWeight(Digraph g) {
        int w;
        /*
         * va a probar todas las combinaciones posibles
         * de vertices que puedan estar en el grafo.
         * 
         */
        for (int i = 0; i < SIZE; ++i)
            for (int j = 0; j < SIZE; ++j) {
                //Saca el tamaño del arco
                w = g.getWeight(i, j);
                //Si el punto de pares alazar i,j existe en el grupo de edges 
                // previamente creado entonces debe tener un uno como tamaño
                // de lo contrario si no esta en ese grupo, entonces debe ser 0.
                if (edges.contains(Pair.makePair(i, j))) {
                    if (w != 1)
                        return false;
                } else {
                    if (w != 0)
                        return false;
                }
            }
        return true;
    }

    static boolean testSuccesors(Digraph g) {
        //Pruebas con valores ya predeterminados.
        
        if (g.getSuccessors(0) != null)
            return false;
        if (g.getSuccessors(1) != null)
            return false;
        if (g.getSuccessors(2) != null)
            return false;
        if (!g.getSuccessors(3).equals(new ArrayList<Integer>(Arrays.asList(8, 10))))
            return false;
        if (g.getSuccessors(4) != null)
            return false;
        if (!g.getSuccessors(5).equals(new ArrayList<Integer>(Arrays.asList(11))))
            return false;
        if (g.getSuccessors(6) != null)
            return false;
        if (!g.getSuccessors(7).equals(new ArrayList<Integer>(Arrays.asList(8, 11))))
            return false;
        if (!g.getSuccessors(8).equals(new ArrayList<Integer>(Arrays.asList(9))))
            return false;
        if (g.getSuccessors(9) != null)
            return false;
        if (g.getSuccessors(10) != null)
            return false;
        if (!g.getSuccessors(11).equals(new ArrayList<Integer>(Arrays.asList(2, 9, 10))))
            return false;
        return true;
    }

    static boolean testDFS(DigraphAL gList, DigraphAM gMatrix) {
        ArrayList<ArrayList<Integer>> dfs = new ArrayList<>(SIZE);
        //Mandinga sea, Null si no existe un DFS.(si esta solo el nodo inicial.)
        dfs.add(0, null);
        dfs.add(1, null);
        dfs.add(2, null);
        dfs.add(3, new ArrayList<Integer>(Arrays.asList(3, 8, 9, 10)));
        dfs.add(4, null);
        dfs.add(5, new ArrayList<Integer>(Arrays.asList(5, 11, 2, 9, 10)));
        dfs.add(6, null);
        dfs.add(7, new ArrayList<Integer>(Arrays.asList(7, 8, 9, 11, 2, 10)));
        dfs.add(8, new ArrayList<Integer>(Arrays.asList(8, 9)));
        dfs.add(9, null);
        dfs.add(10, null);
        dfs.add(11, new ArrayList<Integer>(Arrays.asList(11, 2, 9, 10)));

        for (int i = 0; i < SIZE; ++i) {
            ArrayList<Integer> dfsList = Recorridos.dfs(gList, i);
            ArrayList<Integer> dfsMatrix = Recorridos.dfs(gMatrix, i);
            //Si el resultado deberia ser null pero varia dependiendo de la estructura de dato.
            if (dfsList == null && dfsMatrix != null || dfsList != null && dfsMatrix == null)
                return false;
            //Si el valor de prueba (La parte del principio dfs.add ... es nulo y el valor que arroja el DFS es diferente )
            //Nota: No validamos con dfsMatrix por que ya ubiera volado por el primer if de comparacion de nulos.
            if (dfs.get(i) == null && dfsList != null || dfs.get(i) != null && dfsList == null)
                return false;
            //Si las dos matrices no son iguales.
            if (dfs.get(i) != null && (!dfsList.equals(dfsMatrix) || !dfs.get(i).equals(dfsList)))
                return false;
        }

        return true;
    }

    static boolean testBFS(DigraphAL gList, DigraphAM gMatrix) {
        
        //Mismo proceso del testDFS.
        ArrayList<ArrayList<Integer>> bfs = new ArrayList<>(SIZE);
        bfs.add(0, null);
        bfs.add(1, null);
        bfs.add(2, null);
        bfs.add(3, new ArrayList<Integer>(Arrays.asList(3, 8, 10, 9)));
        bfs.add(4, null);
        bfs.add(5, new ArrayList<Integer>(Arrays.asList(5, 11, 2, 9, 10)));
        bfs.add(6, null);
        bfs.add(7, new ArrayList<Integer>(Arrays.asList(7, 8, 11, 9, 2, 10)));
        bfs.add(8, new ArrayList<Integer>(Arrays.asList(8, 9)));
        bfs.add(9, null);
        bfs.add(10, null);
        bfs.add(11, new ArrayList<Integer>(Arrays.asList(11, 2, 9, 10)));
        //Falla por la Segunda
        for (int i = 0; i < SIZE; ++i) {
            ArrayList<Integer> bfsList = Recorridos.bfs(gList, i);
            ArrayList<Integer> bfsMatrix = Recorridos.bfs(gMatrix, i);

            if (bfsList == null && bfsMatrix != null || bfsList != null && bfsMatrix == null)
                return false;

            if (bfs.get(i) == null && bfsList != null || bfs.get(i) != null && bfsList == null)
                return false;

            if (bfs.get(i) != null && (!bfsList.equals(bfsMatrix) || !bfs.get(i).equals(bfsList)))
                return false;
        }

        return true;
    }

    private static ArrayList<Pair<Integer, Integer>> fillCaminos() {
        // Caminos predeterminados... Ahh no mijo,jajaja
        ArrayList<Pair<Integer, Integer>> caminos = new ArrayList<>();
        caminos.add(Pair.makePair(7, 8));
        caminos.add(Pair.makePair(7, 11));
        caminos.add(Pair.makePair(7, 2));
        caminos.add(Pair.makePair(7, 9));
        caminos.add(Pair.makePair(7, 10));
        caminos.add(Pair.makePair(3, 8));
        caminos.add(Pair.makePair(3, 9));
        caminos.add(Pair.makePair(3, 10));
        caminos.add(Pair.makePair(8, 9));
        caminos.add(Pair.makePair(11, 2));
        caminos.add(Pair.makePair(11, 9));
        caminos.add(Pair.makePair(11, 10));
        caminos.add(Pair.makePair(5, 11));
        caminos.add(Pair.makePair(5, 2));
        caminos.add(Pair.makePair(5, 9));
        caminos.add(Pair.makePair(5, 10));
        return caminos;
    }

    static boolean testHayCaminoDFS(DigraphAL gList, DigraphAM gMatrix) {
        boolean tmp;
        /*
         * Vamos a comparar si podemos llegar desde cualquier nodo
         * de mi grafo a los nodos que estan aislados, si se puede entonces
         * el programa tiene un error.
         */
        for (int i = 0; i < SIZE; ++i)
            for (int j : sinEntradas) {
                tmp = Recorridos.hayCaminoDFS(gList, i, j);
                //Si no son iguales o si el nodo de partida y el nodo de llegada  no son los mismos (Ya que en ese caso)
                // si habria camino y la respuesta de si hay o no caminos es verdadera (recordemos que no hay caminos por que son nodos aislados)
                if (tmp != Recorridos.hayCaminoDFS(gMatrix, i, j) || (i != j && tmp != false)) {
                    System.out.println("Aislados");
                    return false;
                }
            }
        //va a comparar si hay camino por Matriz pero no por Lista y de ser ambos iguales, va a comparar si son falsos
        // deben ser verdaderos por que Caminos son un arreglo de caminos ya previamente calculados.
        for (Pair<Integer, Integer> p : caminos) {
            tmp = Recorridos.hayCaminoDFS(gList, p.first, p.second);
            if (tmp != Recorridos.hayCaminoDFS(gMatrix, p.first, p.second) || tmp != true) {
                System.out.printf("%d->%d\n");
                return false;
            }
        }

        return true;
    }

    static boolean testHayCaminoBFS(DigraphAL gList, DigraphAM gMatrix) {
        //La misma mierda el testHayCaminoDFS
        boolean tmp;

        for (int i = 0; i < SIZE; ++i)
            for (int j : sinEntradas) {
                tmp = Recorridos.hayCaminoBFS(gList, i, j);
                if (tmp != Recorridos.hayCaminoBFS(gMatrix, i, j) || (i != j && tmp != false)) {
                    System.out.println("Aislados");
                    return false;
                }
            }
            
        for (Pair<Integer, Integer> p : caminos) {
            tmp = Recorridos.hayCaminoBFS(gList, p.first, p.second);
            if (tmp != Recorridos.hayCaminoBFS(gMatrix, p.first, p.second) || tmp != true) {
                System.out.printf("%d->%d\n");
                return false;
            }
        }

        return true;
    }

    static String convert(boolean b) {
        //Muy cache. jajajaja
        return b ? "correcta" : "incorrecta";
    }

}

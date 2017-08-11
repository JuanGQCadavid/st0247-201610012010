import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #2
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller2 {
    
    public static void test(){
            
            ArrayList<String> resultCombi;
            resultCombi = combinations("abc");
            System.out.println("Test Combinaciones ->");
            for(String frase: resultCombi){
                System.out.println(frase);
            }
            
            
            System.out.println("Test Suma de subconjuntos ->");
            int data[] = {2,4,8};
            System.out.println(sumaGrupo(0, data, 6));
            
           System.out.println("Test permutations ->");
           ArrayList<String> result;
            result = permutations("abc");
            
            for(String frase: result){
                System.out.println(frase);
            }
           
            
    }

    public static boolean sumaGrupo(int start, int[] nums, int target) {
        
        if (target == 0){
            return true;
        }
        
        if (start >=nums.length){
            return false;
        }
        
        return sumaGrupo(start +1, nums, target - nums[start] ) || sumaGrupo( start +1 , nums, target);
        // complete...
    }

    public static ArrayList<String> combinations(String s) {
        ArrayList<String> result = new ArrayList<String>();
        
        combinations("", s,result);
        
        return result;
    }

    // recomendacion
    
    private static void combinations(String pre, String pos, ArrayList<String> list) {
        String AUX = "", posSub = "";
        //System.out.println("so");
        if (pos.length() > 0){posSub = pos.substring(1,pos.length());AUX = pre + pos.charAt(0) + "";
            combinations(AUX, posSub,list );
            combinations(pre,posSub,list);
        }else{
            adding(list,pre);
        }
        

        
    }
    
    private static ArrayList<String> adding(ArrayList<String> list, String element){
        list.add(element);
        return list;
    }
    public static ArrayList<String> permutations(String s) {
        ArrayList<String> result = new ArrayList<String>();
        
        permutations("", s,result);
        
        return result;
    }

    // recomendacion
    private static void permutations(String pre, String pos, ArrayList<String> list) {
        if(pos.length() == 0){list.add(pre); return;};
        for(int i = 0; i < pos.length();i++){
            permutations(pre + pos.charAt(i) + "", pos.replace(pos.charAt(i)+ "", ""), list);
        }
    }
    

    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static boolean esValido(int[] tablero) {
        // complete...
        return false;
    }

    public static int queens(int n) {
        // complete...
        return 0;
    }
    

}

import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #2
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller2 {
    
    public static void test(){
        int joder[] = {2,4,8};
        System.out.println(sumaGrupo(0, joder, 6));
        
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
		// complete...
		return null;
	}

	// recomendacion
	private static void combinations(String pre, String pos, ArrayList<String> list) {
		// complete...
	}

	public static ArrayList<String> permutations(String s) {
		// complete...
		return null;
	}

	// recomendacion
	private static void permutations(String pre, String pos, ArrayList<String> list) {
		// complete...
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

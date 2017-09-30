
import java.util.*;
/**
 * Write a description of class N_Queens_BT here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class N_Queens_BT
{
    
    public static void main(String[] args) {
        
        boolean[][] problemsOnTheRoad = leer();
        
        for(boolean[] row: problemsOnTheRoad){
            System.out.println(Arrays.toString(row));
        }
        
        
    }

    public static int gmo(int [] victor, booelan[][]mapa, int posY){
	int count = 0,resp;
	if (posY >= victor.length) return 0;
	
	for(int i = 0; i < victor.length; i++){
	    victor[posY] = i;
	    resp = validarG(victor, mapa,posY);

	    if(resp == 0)continue;
	    if(resp == 1)count += gmo(victor,mapa,posY++);
	    if(resp == 2)count++;
	}
	
	victor[posY] = 0;
	return count;

    }

    public static int validarG(int [] victor, boolean[][] mapa, int posY){
	if(validar(victor, mapa, posY)){
	    if(posY == victor.length()-1) return 2;
	    else return 1;
	}else{
	    return 0;
	}

    }
    
    public static boolean[][] leer(){
        Scanner Leer = new Scanner(System.in);
        int nQueens;
        boolean[][] problemsOnTheRoad;
        String line;
        
        nQueens = Leer.nextInt();
        problemsOnTheRoad = new boolean [nQueens][nQueens];
        
        
        for(int i = 0; i < nQueens; i++){
            line = Leer.nextLine();
            for(int j = 0; j < nQueens; j++){
                if(line.charAt(j) == '*'){
                    problemsOnTheRoad[i][j] = true;
                }
            }
        }
        
        
        
        
        return problemsOnTheRoad;
    }
    public static boolean validar(int[] arrayToCheck, boolean[][] mapa, int posY){
        for (int i = 0; i < arrayToCheck.length ; i++) {
            int count = 1;
            for (int j = i +1; j < arrayToCheck.length ; j++) {
                // Horizontales
                if(arrayToCheck[j] == arrayToCheck[i]) return false;
                //Diagonales
                
                //Arriba
                if(arrayToCheck[i]-count == arrayToCheck[j]) return false;
                
                //Abajo
                if(arrayToCheck[i]+count == arrayToCheck[j]) return false;
                
                count++;
            }
        }
	
	if(!mapa[arrayToCheck[posY]-1][posY]) return true;
        return false;
    
    }
 
    
   
}

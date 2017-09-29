import java.util.*;
/**
 * Write a description of class N_Queens_BF here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class N_Queens_BF
{
    
    public static void main(String[] args) {
        ArrayList<int[]> result = inicializar(4);
        /*/
        for(int[] array: result){
            System.out.println(Arrays.toString(array));
        */
        //Validar
        ArrayList<int[]> rigthSolutions = new ArrayList<int[]>();
        for(int[] array: result){
            if(validar(array)){
                rigthSolutions.add(array);
            }
        }
        
        for(int[] array: rigthSolutions)
            System.out.println(Arrays.toString(array));
        
        
        
    }
    public static int count(int limit){
        
        ArrayList<int[]> result = inicializar(limit);
        ArrayList<int[]> rigthSolutions = new ArrayList<int[]>();
        for(int[] array: result){
            if(validar(array)){
                rigthSolutions.add(array);
            }
        }
        return rigthSolutions.size() == 0 ?  -1: rigthSolutions.size();
        
    }
    
    public static boolean validar(int[] arrayToCheck){
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
        return true;
    
    }
    
    public static ArrayList<int[]>  inicializar(int limit){
        ArrayList<int[]> resultList = new ArrayList<int[]>();
        
        int base [] = new int[limit];
        for (int i = 0; i < limit; i++) {
            base[i] = 1;
        }
        resultList.add(base);
        count(resultList, limit);
        return resultList;
        
    }
    
    public static void count(ArrayList<int[]> resultList, int limit){

        
        int pasado[] = resultList.get(resultList.size()-1);
        
        //Copiar el resultado pasado en uno nuevo
        int [] newArray = Arrays.copyOf(pasado, pasado.length);
        
        //aumentar la Ultima posicion en 1
        int valorAgregar = newArray[0] +1;
        newArray[0] = valorAgregar;
        
        //Guardarlo
        resultList.add(newArray);
        
        //El valor agregado es igual al limite?
        
        if( valorAgregar >= limit ){
            //Si!? acabamos!
            int [] newArrayUP = Arrays.copyOf(newArray, newArray.length);
            
            if(up(1 ,newArrayUP,limit)) {return;}
            //No!? siga pa delante mijo
            else {resultList.add(newArrayUP); count(resultList,limit);}
        }else{
            //berriendo siga!
             count(resultList,limit);
        }
        
        
    }
    
    public static boolean up(int pos,int[] newArrayUP, int limit){
        //System.out.println(Arrays.toString(newArrayUP));
        //La posicion actual es el limite mayor?
        if(pos == newArrayUP.length  ){
            //Coronamos!
            return true;  
        }
        
        //El numero actual es el maximo?
        
        if(newArrayUP[pos] == limit){
            //Pongamos en 0 el pasado
            newArrayUP[pos -1] = 1;
            //Como es el maximo, tenemos que actualizar el siguiente
            return up( pos +1,newArrayUP, limit);
        }else{
            //Pongamos en 0 el pasado
            newArrayUP[pos -1] = 1;
            
            //Sume 1 a este 
            newArrayUP[pos] = newArrayUP[pos] +1;
            
            return false;
        }
    
    
    }
}

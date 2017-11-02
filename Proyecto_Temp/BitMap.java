import java.util.*;
import java.math.*;

public class BitMap{
    
    public BitMap(){}

    /*
     * This method computes the number
     * represented by a binary array ( boolean [] )
     * 
     * @param boolean [] the binary Array
     * @return int -> The number obtained 
     */
    public int getNumber(boolean [] binary){
	int number = 0;
	for(int i = 0; i < binary.length; i++){
	    if(binary[i])
		number += Math.pow(2,i);
	}
	return number;

    }

    public int getNumberUnitary(boolean[] binary){
	for(int i = 0; i < binary.length; i ++)
	    if(binary[i])
		return i;
	return 0;
    }
    public int getLength(boolean [] binary){
	int count = 0;
	for(boolean bool: binary)
	    if(bool)
		count ++;
	return count;
    }

    /*
     * This metodo computes the
     * corresponding Binary of a
     * Number. 
     *
     * @param int number -> The number.
     * @param int size -> This represent the
     * longth of the Binary Array.
     *
     * @return boolean[] a well compute Binary array.
     */

    public boolean[] getBinary(int number, int size){
	boolean [] binary = new boolean[size];

	for(int i = size -1 ; i >= 0; i --){
	    if((number - Math.pow(2,i)) >= 0){
		number -=  Math.pow(2,i);
		binary[i] = true;
	    }

	    if (number == 0)
		break;
		
	}

	return binary;

    }

    


}

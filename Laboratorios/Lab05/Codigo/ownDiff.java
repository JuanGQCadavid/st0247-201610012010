import java.util.*;
import java.lang.*;
import java.math.*;

class ownDiff{
    private int [] str1M;
    private int [] str2M;
    private String str1G;
    private String str2G;

    public ownDiff(String str1, String str2){
	int size1 = str1.length(),
	    size2 = str2.length();

	
	str1M = new int [size1];
	str2M = new int [size2];

	for(int i = 0; i < size1; i++)
	    str1M[i] = -1;

	for(int i = 0; i < size2; i++)
	    str2M[i] = -1;
	
	str1G = str1;
	str2G = str2;

	    
    }

    public int getDiff(){
	return lsc(str1G, str2G);
    }
	
    public  int lsc(String str1,String str2){
	if(str1.length() == 0 || str2.length() == 0)
	    return 0;

	//Dynamic part
	int dynamicAnswer = askDynamicTable(str1,str2); 
	if( dynamicAnswer != -1)
	    return dynamicAnswer;


	// No? ahhh que pesar ome
	// Lets compute it.
	int  match = 0;
		
	if(str1.charAt(str1.length() -1)  ==  str2.charAt(str2.length() -1 )){
	    str1 = str1.substring(0, str1.length() -1 );
	    str2 = str2.substring(0, str2.length() -1 );
 	    match = 1;

	    if(str1.length() == 0 || str2.length() == 0)
		return match;
	    
	    //System.out.println(str1.charAt(str1.length() -1));
			
	}
			
			
	int value = match + Math.max(
				lsc(str1.substring(0, str1.length() - 1), str2) , 
				lsc(str1, str2.substring(0, str2.length() - 1))
				);

	return setDynamicTable(str1,str2,value);
    }

    private int askDynamicTable(String str1, String str2){

	int posS1 = str1.length() -1,
	    posS2 = str2.length()-1;
	if((str1M[ posS1 ] == str2M[ posS2 ]) && str1M[posS1] != -1)
	    return str1M[ posS1 ];
	else
	    return -1;
    }

    private int setDynamicTable(String str1, String str2, int value){
	int posS1 = str1.length() -1,
	    posS2 = str2.length()-1;
	str1M[ posS1 ] = value;
	str2M[ posS2 ] = value;
	
	return value;
        
 


    }
}

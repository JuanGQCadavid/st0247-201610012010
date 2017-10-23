import java.util.*;
import java.lang.*;
import java.math.*;

class ownDiff{
    private String [] str1M;
    private String [] str2M;
    private String str1G;
    private String str2G;

    public ownDiff(String str1, String str2){
	int size1 = str1.length(),
	    size2 = str2.length();

	
	str1M = new String [size1];
	str2M = new String [size2];

	for(int i = 0; i < size1; i++)
	    str1M[i] = "-1";

	for(int i = 0; i < size2; i++)
	    str2M[i] = "-1";
	
	str1G = str1;
	str2G = str2;

	    
    }

    public String  getDiff(){
	String result =lsc(str1G, str2G);
	String newResult ="";

	for(int i = result.length () -1; i>= 0; i--)
	    newResult += "" + result.charAt(i);

	return newResult;
    }
	
    public  String lsc(String str1,String str2){
	if(str1.length() == 0 || str2.length() == 0)
	    return "";

	//String result ="";
	//Dynamic part
	String dynamicAnswer = askDynamicTable(str1,str2); 
	if( !dynamicAnswer.equals("-1"))
	    return dynamicAnswer;

	
	// No? ahhh que pesar ome
	// Lets compute it.
	String  match = "";
		
	if(str1.charAt(str1.length() -1)  ==  str2.charAt(str2.length() -1 )){

	    match += "" + str1.charAt(str1.length() -1);
	    str1 = str1.substring(0, str1.length() -1 );
	    str2 = str2.substring(0, str2.length() -1 );
 	    
	    

	    if(str1.length() == 0 || str2.length() == 0)
		return match;
	    
	    //System.out.println(str1.charAt(str1.length() -1));
			
	}
	

	String left = lsc
	    (str1.substring(0, str1.length() - 1), str2);
	String rigth = lsc
	    (str1,str2.substring(0, str2.length() - 1));
	if(left.length() > rigth.length())
	    match +=left;
	else
	    match += rigth;
	
	//System.out.println(value);
	return setDynamicTable(str1,str2,match);
    }

    private String askDynamicTable(String str1, String str2){

	int posS1 = str1.length() -1,
	    posS2 = str2.length()-1;
	if((str1M[ posS1 ] == str2M[ posS2 ]) && !str1M[posS1].equals("-1"))
	    return str1M[ posS1 ];
	else
	    return "-1";
    }

    private String setDynamicTable(String str1, String str2, String value){
	int posS1 = str1.length() -1,
	    posS2 = str2.length()-1;
	
	str1M[ posS1 ] = value;
	str2M[ posS2 ] = value;
	
	return value;
        
 


    }
}

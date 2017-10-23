import java.util.*;
import java.lang.*;
import java.math.*;

class TestownDiff{
    
    
    public static void main (String[] args){
	
	String str1 = "AGGTAB", str2 = "GXTXAYB";
	ownDiff owe = new ownDiff(str1,str2);
	
	System.out.println(owe.getDiff());
	//System.out.println(lsc(str1,str2));
    }
    /*
    
    public static int lsc(String str1,String str2){
	if(str1.length() == 0 || str2.length() == 0)
	    return 0;
		
	int  match = 0;
		
	if(str1.charAt(str1.length() -1)  ==  str2.charAt(str2.length() -1 )){
	    str1 = str1.substring(0, str1.length() -1 );
	    str2 = str2.substring(0, str2.length() -1 );
 	    match = 1;

	    if(str1.length() == 0 || str2.length() == 0)
		return match;
	
	    //System.out.println(str1.charAt(str1.length() -1));
			
	}
			
			
	return match + Math.max(
				lsc(str1.substring(0, str1.length() - 1), str2) , 
				lsc(str1, str2.substring(0, str2.length() - 1))
				);
		
    }
    */
    
}

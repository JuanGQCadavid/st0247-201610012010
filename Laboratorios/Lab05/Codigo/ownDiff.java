import java.util.*;
import java.lang.*;
import java.math.*;

class ownDiff{
    public static void main (String[] args){
	
	String str1 = "AXYT", str2 = "AYZX";
		
	System.out.println(lsc(str1,str2));
    }
	
    public static int lsc(String str1,String str2){
	if(str1.length() == 0 || str2.length() == 0)
	    return 0;
		
	int  match = 0;
		
	if(str1.charAt(str1.length() -1)  ==  str2.charAt(str2.length() -1 )){
	    match = 1;
	    //System.out.println(str1.charAt(str1.length() -1));
			
	}
			
			
	return match + Math.max(
				lsc(str1.substring(0, str1.length() - 1), str2) , 
				lsc(str1, str2.substring(0, str2.length() - 1))
				);
		
    }
}

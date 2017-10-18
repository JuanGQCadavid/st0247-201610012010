import java.util.*;
import java.math.*;

public class Levennshten_Distance {
    private int del = 1;
    private int insert = 1;
    private int sub = 1;
    
    public Levennshten_Distance (){
	
    }

    public Levennshten_Distance (int del, int substitution, int insert){
	this.del = del;
	this.sub  = substitution;
	this.insert = insert;
    }

    public int getDistance(String str1, String str2){
	int [][] dmyTable  = new int[str1.length + 1][str2.length + 1];

	//Lets fill the first Column
	for(int j  = 0; j < dymTable[0].length; j++)
	    dmyTable[0][j] = j;
	
	//Lets fill the first Row
	for(int i  = 0; i < dymTable.length; i++)
	    dmyTable[i][0] = i;

	int plus = 0;
	for (int i = 1; i < dymTable.length; i ++){

	    for(int j  = 1; j < dymTable[0].length; j++){
		if(str1.charAt(i -1) == str2.charAt(j - 1))
		    plus = 0;
		else
		    plus = 1;

		dymTable[i][j] = Math.min(

					  Math.min(
						   dymTable[i-1][j] + del),
					  dymTable[i][j-1] + insert),
		    dyTable[i-1][j-1]))))))
	    }
	}
    }
}

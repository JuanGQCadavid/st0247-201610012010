import java.util.*;
import java.math.*;

public class Levenshten_Distance {
    private int del = 1;
    private int insert = 1;
    private int sub = 0;
    
    public Levenshten_Distance (){
	
    }

    public Levenshten_Distance (int del, int substitution, int insert){
	this.del = del;
	this.sub  = substitution;
	this.insert = insert;
    }

    public int getDistance(String str1, String str2){
	int [][] dmyTable  = new int[str1.length() + 1][str2.length() + 1];

	//Lets fill the first Column
	for(int j  = 0; j < dmyTable[0].length; j++)
	    dmyTable[0][j] = j;

	matrixToString(dmyTable);
	
	//Lets fill the first Row
	for(int i  = 0; i < dmyTable.length; i++)
	    dmyTable[i][0] = i;

	matrixToString(dmyTable);

	int plus = 0;
	for (int i = 1; i < dmyTable.length; i ++){

	    for(int j  = 1; j < dmyTable[0].length; j++){
		if(str1.charAt(i -1) == str2.charAt(j - 1))
		    plus = 0;
		else
		    plus = 1;

		dmyTable[i][j] = Math.min
		    (Math.min(dmyTable[i-1][j] + del,
			      dmyTable[i][j-1] + insert),
		     dmyTable[i-1][j-1] + (plus + sub));
		
	    }
	}
	matrixToString(dmyTable);
	return dmyTable[ dmyTable.length -1 ][ dmyTable[0].length - 1];

	
    }
    public void matrixToString(int [][] matrix){
	System.out.println("----------------");
	for (int i = 0; i < matrix.length; i ++){
	    for(int j  = 0; j < matrix[0].length; j++){
		System.out.print(" | " + matrix[i][j] );
	    }
	    System.out.println("");
	}

	System.out.println("----------------");
    }
}

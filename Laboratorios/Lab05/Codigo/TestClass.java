import java.util.*;

public class TestClass {

    public static void main(String args[]){
	System.out.println(testLevenshtein("amor", "odio"));
    }

    public static int testLevenshtein(String str1, String str2){
	Levenshten_Distance srLevenshten = new Levenshten_Distance();
	return srLevenshten.getDistance(str1, str2);
	
    }
    

}

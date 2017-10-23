import java.util.*;

public class TestLevenshtein {

    public static void main(String args[]){
	if(args.length  == 0)
	    System.err.println("Ingrese por parametros las dos cadenas");
	else
	    System.out.println(testLevenshtein(args[0], args[1]));
    }

    public static int testLevenshtein(String str1, String str2){
	Levenshten_Distance srLevenshten = new Levenshten_Distance();
	return srLevenshten.getDistance(str1, str2);
    }
    

}

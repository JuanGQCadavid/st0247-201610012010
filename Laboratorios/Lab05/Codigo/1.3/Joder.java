import java.util.*;


public class Joder {

    public static void main(String args []){
	
	ArrayList< ArrayList< Pair<Integer,Integer>> > jo =
	    new ArrayList<ArrayList<Pair<Integer,Integer>>>();

		for(int i = 0; i <= 5; i ++){
		    jo.add(new ArrayList<Pair <Integer,Integer>>());
		}

		
		for(int i = 0; i <= 5; i ++){
		    jo.get(i).add(new Pair<Integer,Integer>(i-1,i));
		}

		
		for(int i = 0; i <= 5; i ++){
		    for(int j = 0; j <= 5; j ++){
			System.out.println(jo.get(i).get(j));
		    }
			
		}
    }
}

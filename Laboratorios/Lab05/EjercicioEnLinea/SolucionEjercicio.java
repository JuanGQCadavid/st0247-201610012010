import java.util.*;
import java.math.*;

import java.io.*;
public class SolucionEjercicio {
    private static  boolean udeBug = false;
    public static void main (String args []){
	int matrix[][];
	BufferedReader br = null;
	FileReader fr = null;
	
	try{

	    if(args.length  == 1){
		fr = new FileReader(args[0]);
		br = new BufferedReader(fr);
	    } else{
		br = new BufferedReader(new InputStreamReader(System.in));
	        
	    }
	    String [] line;
	    int nScenes,
		lenX,lenY,
		posCX, posCY,
		nNodes;


	    line = (br.readLine()).split(" ");
	    nScenes = Integer.parseInt(line[0]);
	
	    while(nScenes > 0){
		ArrayList<Pair<Integer,Integer>> points = new
		    ArrayList<Pair<Integer,Integer>>(); 
		line = (br.readLine()).split(" ");
		/*
		//Map
		line = (sc.nextLine()).split(" ");
		lenX = Integer.parseInt(line[0]);
		lenY = Integer.parseInt(line[1]);

		matrix = new int[lenX][lenY];

		*/
		//Caroline pos

		line = (br.readLine()).split(" ");
		posCX = Integer.parseInt(line[0]);
		posCY = Integer.parseInt(line[1]);
		if(udeBug)
		    System.out.println("Karoline X" +  posCX + " Y " + posCY);
		
		points.add(new Pair<Integer,Integer>(posCX,posCY));
	    
		//Nodes number

		line = (br.readLine()).split(" ");
		nNodes = Integer.parseInt(line[0]);

		/*
		//Per Node
		matrix = new int [nNodes][nNodes];
		*/
	    
	    
		while(nNodes > 0){
		    line = (br.readLine()).split(" ");
		    posCX = Integer.parseInt(line[0]);
		    posCY = Integer.parseInt(line[1]);
	    
		    points.add(new Pair<Integer,Integer>(posCX,posCY));

		    nNodes --;
		}

		//matrix  = makeGraph(nNodes, points);
		Held_Karp_0_1 hk = new Held_Karp_0_1(makeGraph( points)); 
		System.out.println("The shortest path has length " + hk.makeHeld_Karp());
		if(udeBug)
		    hk.printPath();
		nScenes--;
	    
	    }
	
	}catch(IOException e){
	    
	    e.printStackTrace();
	}finally{

	    try{
		if(br != null)
		    br.close();
		if(fr != null)
		    fr.close();
	    }catch(IOException ex){
		ex.printStackTrace();
	    }
	   
	}
	
	
	
    }

    public static Digraph makeGraph(ArrayList<Pair<Integer,Integer>> points){
	
	DigraphAM digraph = new DigraphAM(points.size());
	
	for(int i = 0; i < points.size(); i++){
	    Pair<Integer,Integer> parI = points.get(i);
	    //System.out.println("..........");
	    //System.out.println(i + " : X "+ parI.first + " Y: " +
	    //		       parI.second);
	//   System.out.println("----------");
	    if(udeBug)
		System.out.println(i);
	    for(int j = i + 1; j < points.size(); j++){		
		Pair<Integer,Integer> parJ = points.get(j);

		//	System.out.println(j + " : X "+ parJ.first + " Y: " +
		//		   parJ.second);
	    
		int x = Math.abs(parI.first -
				 parJ.first);
		int y =  Math.abs(parI.second -
				  parJ.second);
 
		int R =  x + y;
		   
		digraph.addArc(i,j,R);
		digraph.addArc(j,i,R);
		if(udeBug)
		    System.out.print(R + " ");
	    }
	    if(udeBug)
		System.out.println("");

	}

	return digraph;

    }
	/*
	if(args.length == 1)
	    matrix = readFile();
	else
	    matrix = readConsole();
    }

    public static int [][] readFile(){
	return null;
    }

	*/
    


}

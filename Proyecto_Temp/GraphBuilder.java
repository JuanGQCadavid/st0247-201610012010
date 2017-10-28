import java.util.*;
import java.nio.*;
import java.io.*;

/*
 * Leer un archivo por paso de
 * Parametros y construir su grafo.
 *
 * Autor: Juan Gonzalo Quiroz Cadavid
*/

public class GraphBuilder{

    private static MedellinGraph medellinGraph;
    private static MedellinGraphTest medellinGraphTest;
    private static MedellinGraphTools medellinTools;
    
    private static boolean uDeBug = false;

    public static void main(String [ ] args){
	//Creat Graph.

	medellinGraph = new MedellinGraph();
	medellinGraphTest = new MedellinGraphTest();
	medellinTools = new MedellinGraphTools();

	//Read the File.
	if(args.length >= 1){
	    if(args.length == 2)
		if(args[1].equals("db"))
		    uDeBug = true;
	    
	    readFile(args[0]);
	}else{
	    System.err.println("Ingrese el nombre del fichero!");
	}
    }



    
    public static void buildNode(String line){
	//Lets split the line.
	String []Test = line.split(" ");

	
	double idNode = Double.parseDouble(Test[0]);
	double cordenadaY = Double.parseDouble(Test[1]);
	double cordenadaX = Double.parseDouble(Test[2]);
	String name = "NoName";
	if(Test.length >= 4){
	    name = "";
	    for(int i = 3; i < Test.length; i++)
		name += Test[i] + " ";
	}

	medellinGraph.addNodeToContainerNode(idNode, cordenadaY,
					     cordenadaX,name);
    }
        public static void connect2Contaniers(String line){
	//Lets split the line.
	String []Test = line.split(" ");

	
	double idContainerFrom = Double.parseDouble(Test[0]);
	double idContainerTo = Double.parseDouble(Test[1]);
	double length = Double.parseDouble(Test[2]);
	String name = "UnKnown";
	
	if(Test.length > 4){
	    name = "";
	    for(int i = 3; i < Test.length; i++)
		name += Test[i] + " ";
	}

	medellinGraph.connectContainer(idContainerFrom, idContainerTo,
				       length,name);
    }
    

    public static void readFile(String fileDirection){

        String fileName = fileDirection;
        String line = null;
        try {
	    
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
	    /*
	     * A centinel, when the moment to read the conections
	     * apper, this Centinel swicht the Operations.
	     */
	    boolean cambio = false;
            while((line = bufferedReader.readLine()) != null) {
		
		if(!cambio){
		    if(line.equals("[BREAK]")){
			cambio = true;
			continue;
		    }
		    
		    buildNode(line);
		}else{
		    
		    connect2Contaniers(line);

		}
                //System.out.println(line);
            }
	    if(uDeBug){
		medellinGraphTest.setMedellinGraph(medellinGraph);
		medellinGraphTest.testConnections(1397149003);
		//		medellinGraphTest.testNodes();
		medellinTools.setMedellinGraph(medellinGraph);
		medellinTools.nodesDisconnected();
	    }
	    bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                   
            // ex.printStackTrace();
        }
    }


    


}

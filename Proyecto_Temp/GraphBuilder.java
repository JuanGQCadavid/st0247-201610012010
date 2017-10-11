import java.util.*;
import java.nio.*;

/*
 * Leer un archivo por paso de
 * Parametros y construir su grafo.
 *
 * Autor: Juan Gonzalo Quiroz Cadavid
*/

public class GraphBuilder{
    
    public static void main(String args[]){
        // The name of the file to open.
        String fileName = args[0];
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
	    boolean cambio = false;
            while((line = bufferedReader.readLine()) != null) {
		if(line =="/n")
		    cambio = true;

		if(!cambio){
		    crearNodo(line)
		}else{

		}
                System.out.println(line);
            }   
         
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
            // Or we could just do this: 
            // ex.printStackTrace();
        }finally{
	    bufferedReader.close();
	}
    }


}

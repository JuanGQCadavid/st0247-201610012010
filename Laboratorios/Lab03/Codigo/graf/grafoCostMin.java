
package graf;

/**
 *
 * @author Alejandro
 */
public class grafoCostMin {
/* Nombramos el metodo publico donde declaramos la matriz del grafo */
    public String busquedaBajoCosto(long [][] entrada){
        /* Declaramos las variables y asignamos valores */
        int vertice = entrada.length;
        long matrizAdy[][] = entrada;
        String camino[][]= new String [vertice][vertice];
        String caminosAux[][] = new String[vertice][vertice];
        String cRecorridos="",cadena = "", caminos = "";
        int i,j,k;
        float temp1, temp2, temp3, temp4, tempx;
        /* creamos los metodos de comprobacion e iniciación */
        for(i=0;i<vertice;i++){
            for(j=0;j<vertice;j++){
                camino[i][j]= "";
                caminosAux[i][j]= "";
            }
        }
        /* comenzamos a recorrer con el fin de comparar, y dar valores. */
        for(k=0;k<vertice;k++){
            for(i=0;i<vertice;i++){
                for(j=0;j<vertice;j++){
                    temp1 = matrizAdy[i][j];
                    temp2 = matrizAdy[i][k];
                    temp3 = matrizAdy[k][j];
                    temp4 = temp2 + temp3;
                    tempx = Math.min(temp1,temp4);
                    if(temp1 != temp4){
                        if(tempx==temp4){
                            cRecorridos="";
                            caminosAux[i][j] = k + "";
                            camino[i][j]= caminoR(i,k,caminosAux,cRecorridos)+ (k+1);
                        }
                    }
                    matrizAdy[i][j]=(long) tempx;
                }
            }
        }
        /* seguimos recorriendo buscando otro camino de menor costo y comparar*/
        for(i=0;i<vertice;i++){
            for(j=0;j<vertice;j++){
                cadena = cadena+"["+ matrizAdy[i][j]+"]";
            }
            cadena = cadena + "\n";
        }
        /* nos aseguramos de que el nodo verdaderamente tenga conexion y si tiene 10 digitos decimos que no hay conexiones */
        for(i=0;i<vertice;i++){
            for(j=0;j<vertice;j++){
                if(matrizAdy[i][j]!= 1000000000){
                    if(i!=j){
                        if(camino[i][j].equals("")){
                            caminos +="["+(i+1)+"---->"+(j+1)+ "]  ["+ (i+1)+ "," + (j+1)+ "]\n";                            
                        }else{
                            caminos +="["+(i+1)+"---->"+(j+1)+ "]  ["+ (i+1)+ "," + camino[i][j]+", " +(j+1)+ "]\n";
                        }
                    }
                }
                
            }
        }
        /*retornamos la cadena con caminos */
        return "[" + cadena + "]\n"+ "Los diferentes caminos mas cortos entre vertices son :\n " + caminos;
    }
    /*retornamos el camino recorrido con menor costo y otros caminos de un punto a otro. */
    public String caminoR(int i, int k, String[][] camAux, String caminoCorrido){
        if(camAux[i][k].equals("")){
            return "";
        }else{
            caminoCorrido += caminoR(i,Integer.parseInt(camAux[i][k].toString()),
                    camAux,
                    caminoCorrido)+(Integer.parseInt(camAux[i][k].toString())+ 1)+ ", ";
            return caminoCorrido;
        }
    }
    
}

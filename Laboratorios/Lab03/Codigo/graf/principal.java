/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graf;

/**
 *
 * @author Alejandro Díaz, Juan Gonzalo
 */
public class principal {
    /* en esta clase creamos los nodos y pasamos parametros. */
    public static void main(String[] args){
        
    long Matriz[][]={{999999999,3,4,9,8,1},
                    {6,0,999999999,2,5,999999999},
                    {999999999,1,0,999999999,3,999999999},
                    {5,999999999,999999999,0,4,999999999},
                    {2,999999999,1,7,0,3},
                    {3,999999999,4,2,999999999,0}};
    grafoCostMin ccamino = new grafoCostMin();
    System.out.println(ccamino.busquedaBajoCosto(Matriz));
    
    }
    
}

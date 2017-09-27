import java.util.*;
/**
 * Write a description of class testDiagraphAL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class testDiagraphAL
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class testDiagraphAL
     */
    public testDiagraphAL()
    {
        // initialise instance variables
        x = 0;
    }

    public static void testWeigth(){
        DigraphAL dgal = new DigraphAL(5);
         dgal.addArc(0,1,10);
         dgal.addArc(0,2,3);
         dgal.addArc(1,2,1);
         dgal.addArc(1,3,2);
         dgal.addArc(2,1,4);
         dgal.addArc(2,3,8);
         dgal.addArc(2,4,2);
         dgal.addArc(3,4,7);
         dgal.addArc(4,3,9);
        
        
       
        System.out.println(dgal.getWeight(0,1) + " = " + 10);
        
        System.out.println(dgal.getWeight(0,2) + " = " + 3);
        
        System.out.println(dgal.getWeight(1,2) + " = " + 1);
        
        System.out.println(dgal.getWeight(1,3) + " = " + 2);
        
        System.out.println(dgal.getWeight(2,1) + " = " + 4);
        
        System.out.println(dgal.getWeight(2,3) + " = " + 8);
        
        System.out.println(dgal.getWeight(2,4) + " = " + 2);
        
        System.out.println(dgal.getWeight(3,4) + " = " + 7);
        
        System.out.println(dgal.getWeight(4,3) + " = " + 9);

        
    }
    
    public static void testMaxSuccessors(){
       GraphAlgorithms objectBase = new  GraphAlgorithms();
        
       DigraphAL biGraphAL = new DigraphAL(5);
       biGraphAL.addArc(0,1,10);
       biGraphAL.addArc(0,2,3);
       biGraphAL.addArc(1,2,1);
       biGraphAL.addArc(1,3,2);
       biGraphAL.addArc(2,1,4);
       biGraphAL.addArc(2,3,8);
       biGraphAL.addArc(2,4,2);
       biGraphAL.addArc(3,4,7);
       biGraphAL.addArc(4,3,9);
       
       
       System.out.println(objectBase.maxSuccessores(biGraphAL));

       
       DigraphAM biGraphAM = new DigraphAM(5);
       biGraphAM.addArc(0,1,10);
       biGraphAM.addArc(0,2,3);
       biGraphAM.addArc(1,2,1);
       biGraphAM.addArc(1,3,2);
       biGraphAM.addArc(2,1,4);
       biGraphAM.addArc(2,3,8);
       biGraphAM.addArc(2,4,2);
       biGraphAM.addArc(3,4,7);
       biGraphAM.addArc(4,3,9);
       
       System.out.println(objectBase.maxSuccessores(biGraphAM));
       
       ArrayList<Integer> Suss = biGraphAL.getSuccessors(2);
       
       
       ArrayList<Integer> Suss2 = biGraphAM.getSuccessors(2);
    }
}

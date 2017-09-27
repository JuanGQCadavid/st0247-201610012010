
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RecorridosTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RecorridosTest
{
    /**
     * Default constructor for test class RecorridosTest
     */
    public RecorridosTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testBFS(){
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
        
        ArrayList<Integer> resultAL = Recorridos.bfs(biGraphAL,0); 
        
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
        
        ArrayList<Integer> resultAM = Recorridos.bfs(biGraphAM,0); 
        
        assertEquals(resultAL.size(),resultAM.size());
        
        for(int number = 0; number < resultAM.size() ; number++){
            String rAL= resultAL.get(number) +"";
            String rAM = resultAM.get(number)+ "";
            
            assertEquals(rAL,rAM);
        }
        
    }
    
    @Test
    public void testDFS(){
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
        
        
        ArrayList<Integer> resultAM = Recorridos.dfs(biGraphAM,3); 
        
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

        ArrayList<Integer> resultAL = Recorridos.dfs(biGraphAL,3); 
        
        
        assertEquals(resultAL.size(),resultAM.size());
        
        for(int number = 0; number < resultAM.size() ; number++){
            String rAL= resultAL.get(number) +"";
            String rAM = resultAM.get(number)+ "";
            
            assertEquals(rAL,rAM);
        }
        
        
    }
}

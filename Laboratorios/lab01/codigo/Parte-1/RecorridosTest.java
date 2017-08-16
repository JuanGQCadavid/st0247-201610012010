
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
    
    public static void testBFS(){
        Graph g = new DigraphAM(8);
        
        //g.addArc(int source, int destination, int weight);
        
        g.addArc(0,4,0);
             
        g.addArc(1,6,0);
        g.addArc(1,5,0);
        
        g.addArc(2,4,0);
        g.addArc(2,1,0);
        g.addArc(2,5,0);
        g.addArc(2,6,0);
        
        g.addArc(3,1,0);
        g.addArc(3,5,0);
        
        g.addArc(4,2,0);
        g.addArc(4,7,0);
        
        g.addArc(5,3,0);
        
        g.addArc(6,7,0);
        g.addArc(6,5,0);
        
        g.addArc(7,6,0);
        g.addArc(7,5,0);
        
        
        ArrayList<Integer> result = Recorridos.bfs(g,0); 
        
        for(int number: result){
            System.out.print(number + " ");
        }
        
        
    }
    
    public static void testDFS(){
        Graph g = new DigraphAM(8);
        
        //g.addArc(int source, int destination, int weight);
        
        g.addArc(0,3,0);
        g.addArc(0,1,0);
             
        g.addArc(1,0,0);
        g.addArc(1,2,0);
        g.addArc(1,5,0);
        
        g.addArc(2,1,0);
        g.addArc(2,5,0);
        g.addArc(2,4,0);
        g.addArc(2,0,0);
        
        //g.addArc(3,1,0);
        
        g.addArc(4,7,0);
        
        //g.addArc(5,3,0);
        
        g.addArc(6,5,0);
        
        //g.addArc(7,6,0);

        
        
        ArrayList<Integer> result = Recorridos.dfs(g,3); 
        
        for(int number: result){
            System.out.print(number + " ");
        }
        
        
    }
}

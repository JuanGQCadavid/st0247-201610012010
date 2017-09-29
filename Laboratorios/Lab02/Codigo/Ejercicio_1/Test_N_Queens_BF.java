

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Test_N_Queens_BF.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Test_N_Queens_BF
{
    /**
     * Default constructor for test class Test_N_Queens_BF
     */
    public Test_N_Queens_BF()
    {
    }
    
    @Test
    public void testGeneral(){
        
		// tomado de
		// https://math.stackexchange.com/questions/1872444/how-many-solutions-are-there-to-an-n-by-n-queens-problem
	int[] soluciones = { -1, 1, 0, 0, 2, 10, 4, 40, 92 };
	for (int i = 1; i <= 8; ++i)
	   if (soluciones[i] != Taller3.nReinas(i)) {
		System.out.println(i + " -> " + Taller3.nReinas(i) + " (expected " + soluciones[i] + ")");
		return false;
}

	return true;	
	
    
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
}

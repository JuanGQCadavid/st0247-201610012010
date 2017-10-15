import static org.junit.Assert.*;
import org.junit.*;

public class TestTSPGreddy{

    
    public  TestTSPGreddy(){}

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
    public void testTSP(){	
        DigraphAL dgal = new DigraphAL(4);
         dgal.addArc(1 , 3 , 1);
	 dgal.addArc(1 , 2 , 3);
	 dgal.addArc(1 , 0 , 5);

	 dgal.addArc(2 , 1 , 5);
	 dgal.addArc(2 , 3 , 3);
	 dgal.addArc(2 , 0 , 8);

	 dgal.addArc(3 , 1 , 4);
	 dgal.addArc(3 , 2 , 6);
	 dgal.addArc(3 , 0 , 5);

	 dgal.addArc(0 , 1 , 1);
	 dgal.addArc(0 , 2 , 3);
	 dgal.addArc(0 , 3 , 7);



	TSPGreddy tsp = new TSPGreddy(dgal);

	tsp.setIndex(0);
	
	int [] result = tsp.getTSPMap();
	int [] answer = {1,3,0,2};
	
	for(int i : result)
	    assertEquals(result[i], answer[i]);

	//With other INDEX
	tsp.setIndex(1);
	
	result = tsp.getTSPMap();
	int [] answer1 = {2,3,1,0};

	assertEquals(result, answer1);

	
	// other INDEX
	tsp.setIndex(2);
	
	result = tsp.getTSPMap();
	int [] answer2 = {2,0,3,1};
	
        
	assertEquals(result, answer2);

	
	//With other INDEX
	tsp.setIndex(3);
	
	result = tsp.getTSPMap();
	int [] answer3 = {3,2,0,1};

	assertEquals(result, answer3);

 	//for(int i : result)
	//	    assertEquals(result[i], answer[i]);
        
    }
    
}

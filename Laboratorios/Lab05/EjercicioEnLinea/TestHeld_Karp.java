import java.util.*;

public class TestHeld_Karp {

    public static void main(String args[] ){
	Digraph digraph = makeGraph();
	Held_Karp_0_1 hk = new Held_Karp_0_1(digraph);
	System.out.println(hk.makeHeld_Karp());
	
    }

    public static Digraph makeGraph(){
	DigraphAM digraph = new DigraphAM(4);

	digraph.addArc( 0, 1, 2);
	digraph.addArc( 0, 2, 9);	
	digraph.addArc( 0, 3, 10);
        
	    
	digraph.addArc( 1, 0, 1);
	digraph.addArc( 1, 2, 6);
	digraph.addArc( 1, 3, 4);
        
	    
	digraph.addArc( 2, 0, 15);
	digraph.addArc( 2, 1, 7);	
	digraph.addArc( 2, 3, 8);
        
	
	digraph.addArc( 3, 0,6);
	digraph.addArc( 3, 1,3);
	digraph.addArc( 3, 2,12);
        	
	return digraph;
    }

}

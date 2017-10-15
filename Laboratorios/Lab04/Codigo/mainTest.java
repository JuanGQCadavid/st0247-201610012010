import java.util.*;
public class mainTest{

    public static void  main (String args [ ] ){
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
	tsp.setIndex(3);
	int [] result = tsp.getTSPMap();

	
	for(int i : result)
	    System.out.println(i);


    }

}

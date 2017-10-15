import java.util.*;

public class N_Rutas_N_Conductores{

    public static void main(String [ ] args){
	Scanner sc = new Scanner(System.in);
	double [] ndr = new double [3];
	double [] dayValues;
	double [] nigthValues;
	String line;
	int size = 0;
	ArrayList<Double> result = new ArrayList<Double>();
	while(true){
	    //Read first line (N D R)
	    line = sc.nextLine();
	    
	    //Save that line in an array.
	    TransformLineToArray(line, ndr);
	    size =(int) ndr[0];
	    if(ndr[0] == 0 && ndr[1] == 0 && ndr[2] == 0)
		break;
	    
	    //Lets Read Day.
	    line = sc.nextLine();
	    //Save that line in an array.
	    dayValues = new double[size];
	    TransformLineToArray(line, dayValues);

	    //Lets Read Day.
	    line = sc.nextLine();
	    //Save that line in an array.
	    nigthValues = new double[size];
	    TransformLineToArray(line, nigthValues);

	    result.add(GreedySolution(ndr,dayValues, nigthValues));
	    

	}

	for(double uniqueR: result){
	    System.out.println(uniqueR);
	}

    }

    public static void TransformLineToArray(String line, double[] array){
	String lineToStringAr [] = line.split(" ");
	int size = array.length;

	for(int i = 0; i < size; i++)
	    array[i] = Double.parseDouble(lineToStringAr[i]);
    }

    public static double GreedySolution(double nrc[], double dayValues[], double[] nigthValues){
	int size = dayValues.length;
	double resultDay = 0;
	double resultNigth = 0;

	//Lets sum the total hours per Segement.
	for(int i = 0; i < size; i++){
	    resultDay += dayValues[i];
	    resultNigth += nigthValues[i];
	}

	//Les restamos la shoras maximas
	resultDay -= nrc[1]; resultNigth -= nrc[1];

	//Al resultado se multiplica por lo que son las horas extras
	resultDay *= nrc[2]; resultNigth *= nrc[2];

	//Se suman para dar el resultado

	double result = resultDay + resultNigth;

	//If the result is Negative, so there aren't extra hours to pay.
	if(result <= 0)
	    return 0;

	return result;

	

    }

}

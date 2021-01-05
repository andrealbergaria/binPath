package binPathJava;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class printTuples {

//private static ArrayList<ArrayList<Tuple>> AllValues = new ArrayList<ArrayList<Tuple>>();  

//private static ArrayList<Integer> positions = new ArrayList<Integer>(); 
//private static ArrayList<ArrayList<Integer>> AllValuesInts  = new ArrayList<ArrayList<Integer>>();

	

/*
 4             8				 16			32
Set B     Set C  	    Set D   		Set E  		Set F
0         (0,0) 0  		(0,0,0) 0    (0,0,0,0) 0  (0,0,0,0,0)
1         (0,1) 1       (0,0,1) 1	 (0,0,0,1) 1  (0,0,0,0,1)
(1,0) 2    	(0,1,0) 2    (0,0,1,0) 2  (0,0,0,1,0) => Set D (3bits)
(1,1) 3    	(0,1,1) 3    (0,0,1,1) 3  (0,0,0,1,1)
							 
				(1,0,0) 4	 (0,1,0,0) 4   (0,0,1,0,0)
				(1,0,1) 5    (0,1,0,1) 5   (0,0,1,0,1) => Set D (3bits)
				(1,1,0) 6    (0,1,1,0) 6   (0,0,1,1,0) 
				(1,1,1) 7    (0,1,1,1) 7   (0,0,1,1,1)
				
							 (1,0,0,0) 8   (0,1,0,0,0)
							 (1,0,0,1) 9   (0,1,0,0,1) => Set E (4bits) plus leading 0,which equals 4bits
							 (1,0,1,0) 10  (0,1,0,1,0)
							 (1,0,1,1) 11  (0,1,0,1,1)
							 
							 (1,1,0,0) 12 (0,1,1,0,0)
							 (1,1,0,1) 13 (0,1,1,0,1) => Set E (4bits) plus leading 0,which equals 4bits
							 (1,1,1,0) 14 (0,1,1,1,0)
							 (1,1,1,1) 15 (0,1,1,1,1) 16combs of leading zeros
							 
							 			  (1,0,0,0,0) => 5bits.just change one at the beggiging
			
		
			8 means it has 8 elements (Set c)
*/
	
	public static ArrayList<Integer> AllValues;
	
	
 

public static void setTuplesInt() {
	
	int iterator=2;
	//1 , 2*1 , 2*2 ,2*3 (2*3 elements)
	for (int it = 0; it < 2*iterator; it++) {
		// First set , set B
		//  array unica
		AllValues.add(new Integer(it));
		
		
	}
	
}
/*public static void setTuples() throws Exception {
	
		
				ArrayList<Tuple> firstPos = new ArrayList<Tuple>();
				Tuple t = new Tuple(0,0,0);
				Tuple t2 = new Tuple(0,0,1);
				firstPos.add(t);
				firstPos.add(t2);
				AllValues.add(firstPos);
				
				setPos(int idx) {
					
				}
				ArrayList<Tuple> secondPos = new ArrayList<Tuple>();
				Tuple t3 = new Tuple(0,1,0);
				Tuple t4 = new Tuple(0,1,1);
				secondPos.add(t3);
				secondPos.add(t4);
				AllValues.add(secondPos);
				
				
				
				ArrayList<Tuple> thirdPos = new ArrayList<Tuple>();
				Tuple t5 = new Tuple(1,0,0);
				Tuple t6 = new Tuple(1,1,0);
				Tuple t7 = new Tuple(1,0,1);
				Tuple t8 = new Tuple(1,1,1);
				thirdPos.add(t5);
				thirdPos.add(t6);
				thirdPos.add(t7);
				thirdPos.add(t8);
				AllValues.add(thirdPos);
				
				Tuple.print(AllValues);
				
					
			}*/
public static void main(String[] args) throws Exception {
	setTuplesInt();
}
private static void print() {
	System.out.println();
	for (Integer auxInt : AllValues) {
			System.out.print(" "+auxInt+",");
	System.out.println();
	}
}
		}


 
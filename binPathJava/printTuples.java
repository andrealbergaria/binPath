package binPathJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import binPathJava.Permutation;



public class printTuples {

	
/*	/ Tuples 3 (from  https://www.mathsisfun.com/combinatorics/combinations-permutations-calculator.html
	{1,2,3} {1,3,2} {2,1,3} {2,3,1} {3,1,2} {3,2,1
	// Tuples 4 (same site)
	1,2,3,4} {1,2,4,3} {1,3,2,4} {1,3,4,2}
	 {1,4,2,3} {1,4,3,2} {2,1,3,4} {2,1,4,3}
	  {2,3,1,4} {2,3,4,1} {2,4,1,3} {2,4,3,1}
	   {3,1,2,4} {3,1,4,2} {3,2,1,4} {3,2,4,1}
	    {3,4,1,2} {3,4,2,1} {4,1,2,3} {4,1,3,2}
	     {4,2,1,3} {4,2,3,1} {4,3,1,2} {4,3,2,1}

	Para obter o algorithm de tuples, start with three elements , then add 1,2,3,4 to prefix it. 5 elements 
	use 4 elements tuples and 1,2,3,4,5 prefixes...then 
		eleemes -> ((1,2,3,4,5,6,7) 3 three elements

	*/
	public static <T> void main(String[] args) {
		if (args.length != 1) {
			System.err.println("need to specify number of elements...it will start with 1");
			System.exit(-1);
		}
		int[] elements = new int[Integer.parseInt(args[0])];
		printTuples(elements);
	}
	
	public static <T> Vector<Integer[]> getThreeElements(Integer[] elements) {
		int[] t = new int[elements.length];
		int g = 0;
		// algorithm set three elements
		for (int i=0; i < elements.length;i++) {
			if (elements[i] >= 1 && elements[i] <= 3) {
				t[g] = elements[i];
				g++;
			}
		}
		
		Vector<Integer[]> retVector = Permutation.permute(elements.length, elements); 
		return retVector;
		
	}
	
	// lic static <T> void printTuples(Vector<T> elementsSet) {
		   Integer[] elements = {1,2,3};
			
		   Vector<Integer[]> tuples_3 = getThreeElements(elements);
		   
		   Vector<Integer[]> result = new Vector<>(tuples_3);
		   // contains, 3tuples, and one more element
		   Integer[] arrayTemp;
			// 
		   	Iterator<Integer[]> it = tuples_3.iterator();
		   			// add the element to the array
		   	// for each tuple, add the elementsSet to it
					while(it.hasNext()) {
						Integer[] currentTuple = it.next();
						
						ArrayList<Integer[]> newTuple = new ArrayList<>();
						newTuple.addAll(currentTuple);
						
						Iterator<?> it2  = elementsSet.iterator();
						while (it2.hasNext()) {
							newTuple
						}
					}
						
					
				}
			}
		
		   			 
				 
				 
				 
			      
			 }
			 
			
		   // Second change
		  }

}

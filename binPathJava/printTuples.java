package binPathJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import binPathJava.Permutation;



public class printTuples {

	
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

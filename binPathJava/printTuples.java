package binPathJava;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import binPathJava.Permutation;
import org.javatuples.*;
/* 
* TUPLES NUMBER
* Unit (one element)
	Pair (two elements)
	Triplet (three elements)
	Quartet (four elements)
	Quintet (five elements)
	Sextet (six elements)
	Septet (seven elements)
	Octet (eight elements)
	Ennead (nine elements)
	Decade (ten elements
*/


public class printTuples {

	// from https://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java	
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
	
		
	
	public static <T> void printTuples(Vector<T> elements) {
		if (elements.size() != 3)
			throw new Exception("not using 3 elemts on tuple");
	
		   
		   Triplet<T,T,T> tup =Triplet.with(elements.get(0),elements.get(1),elements.get(2))  
			
		 
		   
		   
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

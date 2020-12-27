package binPathJava;

import java.lang.reflect.Method;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


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
	public static void main(String[] args) {
		
		Integer[] base = {1,2,3};
		List <List<Integer>> TuplesList = new ArrayList<>();
				// Se forem dois elmeentos
				//ento

	}
	
	/*
	 * 
	 * @return a lista com elementso trocados
*/
	
	public static <T> List< List<Integer> > permutateTuples(int numberOfElems) {
 
		
		/*
		 * row 1 -> 1 2
		 * 			it1   it2
		 * row 2 -> (2,1 (1,2)
		 * row 3 -> (1,2,3)(2,1,3.....
		 *  nunmberOfEleems > 1 
		 */
				
			for (int i=0 ; i < 2; i++) {
			}
			for (int row =2; row < 3;row++) {
				// Adds element to tuples
				for (int add=1 ; add < 2; add++) {
					
				}
			}
			List <List<Integer>> retValue = new ArrayList<>();
			List <List<Integer>> li = new ArrayList<>();
			
				for (List<Integer> tuplo : retValue) {
					for (int idx=1; idx < numberOfElems ;idx++) {
						
						List <Integer> temporaryList  = new ArrayList<>(tuplo);
						temporaryList.add(new Integer(idx));
						retValue.add(temporaryList);
					
					}
				}
				return new ArrayList<List<Integer>>();	
	}
		
}

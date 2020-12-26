package binPathJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.javatuples.*;
import org.javatuples.valueintf.IValue0;

public class printPartitions {

	/**
	 * 
	 * The algorithm is as follow, for example, partition 3, the minimum tuples are (A=1,B=1,C=1)(1,1,1)
   	the elements added must be (1,2), less than 3  (since adding one to 3 would break the parition number)
   	and bigger than zero, because that way would break numbers of summands
   	So for,
   	A = 3
   	A+B = 3
   	A+B+C = 3
   	
   	Possible values
   	A= {1,2} B = {1,2} C={1,2}
   	
   	get all tuples
   	
   	// from https://www.mathsisfun.com/combinatorics/combinations-permutations-calculator.html
	2P3
	{1,1,1} {1,1,2} {1,2,1} {1,2,2} {2,1,1} {2,1,2} {2,2,1} {2,2,2}
   		X										
   	So there is only one possible outcome.
   	
   	For (4 summands , A+B+C+D) 
   	A= {1,2,3} B={1,2,3} C = {1,2,3} D={1,2,3}
   	 
   	A+B+C+D = 4

	
	 */
	
	
	
	public static <T> void printPartitions(int numberOfPartitions,T[] Elems) {
		int max_size_summands = numberOfPartitions-1; 
		
		
	}
	public static void main(String[] args) {
		
	}

}


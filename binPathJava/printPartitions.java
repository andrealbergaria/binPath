package binPathJava;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import Permutations.*;
 

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
	
	
	
	public static Integer[] getRange(int max) {
		Integer[] arr = new Integer[max];
		int v=0;
		for (int i=1; i <= max;i++) {
			arr[v] = new Integer(i);
			v++;
		}
		return arr;
	}
	public static int sumValues(Integer[] arr) {
		int sum=0;
		 
			
		for (int i=0; i < arr.length ; i++) {
			sum+=arr[i];
		}
			return sum;
	}
	 
	public static void checkPart(Integer[] tuple,int partitionNumber) {
		System.out.println("\n Partition number "+partitionNumber);
		int sum;
		sum = sumValues(tuple);
		//Print array
		String tupleString=new String();
		
		tupleString="[ ";
		for(Integer elem : tuple) {
			
			tupleString += elem + " , ";
		}
		tupleString+="] ";
		
		if (sum == partitionNumber)
	 		 out.println("\n Tuple "+tupleString+" is part");
	 	// else
	 	//	out.println("\n Tuple "+tupleString+" is not part");
	 	 
	}
	/*
	 * 
	 * 
	 * List All Permutations
	 */
	public static void ListAllPermutations(List<Integer[]> listOfTuples) {
		for (Integer[] tuple : listOfTuples) 
			listTuple(tuple);
	}
	
	public static void listTuple(Integer[] tuple) {
		System.out.print("\n[");
		for (Integer elem: tuple) {
			System.out.print(elem+",");
		}
		System.out.print("]");
	}
	
	
	/*
	 * @returns list with tuples that are parts 8from partition math theory
	 * 
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("\nNeeds number of summands or partiiton number");
			System.exit(-1);
		}
		
	//	 int maxSummands = Integer.parseInt(args[0]);
		int maxSummands= 4;
			 
         Integer[] tuple;
        Integer[] possibleValuesForTuple;
         
 		 List<Integer[]> listObj;
         
       for (int summand=1; summand <= maxSummands ;summand++) {
    	   
    	   		// Gets the values from 1...summand
        	 	 possibleValuesForTuple = getRange(summand);
        	 	 // Change elems to object because of method permute uses Objecŧ[]
        	 	// listRangeTuple(possibleValuesForTuple);
        	 	 
        	 	 listObj = PermutationWithRepeats.permute(possibleValuesForTuple, summand);
        	 	 //ListAllPermutations(listObj);
        	 	 //for (Integer[] tuplePermuted : listObj) {
        	 		 // returns list and assign to tuple
        	 //		 checkPart(tuplePermuted, maxSummands);
        	 //	 }
        	 	 for (Integer[] i : listObj ) {
        	 		 checkPart(i, maxSummands);
        	 	 }
        	 	 
         }
        	 
        	 
         
         
      }
         
		

}


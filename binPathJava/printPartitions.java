package binPathJava;

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
	
	
	
	public static int[] getPossibleValues(int min,int max) {
		int[] arr = new int[max];
		int v=0;
		for (int i=min; i <= max;i++) {
			arr[v] = i;
			v++;
		}
		return arr;
	}
	public static int sumValues(int[] arr) {
		int sum=0;
	
		for (int i=0; i < arr.length ; i++) 
			sum+=arr[i];
		
			return sum;
	}
	 
	/*
	 * @returns list with tuples that are parts 8from partition math theory
	 * 
	 */
	public static List<AllPermutations> permuteTemp(int[] values,int partitionNumber) {
		AllPermutations perm = new AllPermutations(values);
		
		List<AllPermutations> l = new ArrayList<>();
    	perm.GetFirst();
    	System.out.println(perm);
    	l.add(perm);
    	 
    	
       	
    	int sum = sumValues(perm.getArray());
    	
    	if (sum != partitionNumber)
      		 System.err.println("the Tuple " + perm + " doest add up to "+partitionNumber);
    	else
    		System.err.println("the Tuple " + perm + " is good");
       	
    	
    	while (perm.HasNext()) 
   	     { 	
       		 
       		 perm.GetNext();
       		 l.add(perm);
   	         System.out.println(perm);
   	         sum = sumValues(perm.getArray());
   	      if (sum != partitionNumber)
       		 System.err.println("the Tuple " + perm + " doest add up to "+partitionNumber);
   	      else
     		System.err.println("the Tuple " + perm + " is good");
        	
   	     } 
   	     
    	 return l;
    	 
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("\nNeeds number of summands or partiiton number");
		}
		 int maxSummands = Integer.parseInt(args[0]);
			 
         
         
         
         for (int summand=1; summand <= maxSummands ;summand++) {
        	 	 int[] values = getPossibleValues(1,summand);
        	 	 permuteTemp(values,maxSummands);
         }
        	 
        	 
         
         
      }
         
		

}


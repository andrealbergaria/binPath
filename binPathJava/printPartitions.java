package binPathJava;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	
	
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("\nNeeds number of summands or partiiton number");
		}
		 int partitionNumber = Integer.parseInt(args[0]);
		 int[] possibleValues = new int[partitionNumber];
         int idx = 0;
         for (int i=1; i <= possibleValues.length;i++) {
        	 possibleValues[idx] =i;
        			 idx++;
         }
        	 
                   //Possible values
		  // 	A= {1,2} B = {1,2} C={1,2}
         
         // A= {1,2} B = {1,2} => (1,1)(1,2)(2,1)(2,2)
         // get Possible 
         
         AllPermutations perm = new AllPermutations(possibleValues); 
         permute(perm);
         
         
         
        	 
         }
        		   	
     public static void permute(AllPermutations perm) {
    	 perm.GetFirst();
    	 perm.Output();
    	 int arr[] = perm.getArray();
    	 
    	 while (perm.HasNext()) 
	     { 
	         perm.GetNext();
	         perm.Output();
	     } 
	     
     }
	     
		

}


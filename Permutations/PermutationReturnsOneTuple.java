package Permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationReturnsOneTuple {

	/*
	 * 
	 * @param a, the elements to be permuted
	 * @param k number of elements
	 * @returns Tuple
	 */
	    public static Integer[] permute(Integer[] a, int k,boolean print) {
	    	// numOfValuesInTuple=num;
	    	
	        int n = a.length;
	        
	        int[] indexes = new int[k];
	        int total = (int) Math.pow(n, k);

	        Integer[] tuple = new Integer[k];
	        
	        while (total > 0) {
	            for (int i = 0; i < k; i++){
	                tuple[i] = a[indexes[i]];
	            }

	            /*	WORKS OK
	             *  COPY TUPLES TO LIST (OTHER WAY (tuples.add) DIDNT WORK..GOING FOR CYCLE */
	         /*   System.out.println("[");
	           for (int q=0 ; q < tuple.length;q++) {
	        	   System.out.print(tuple[q]+",");
	           }
	           System.out.println("]");
	           */
	            
	            if (print == true)
	            		handle(tuple);
	            
	            for (int i = 0; i < k; i++) {
	                if (indexes[i] >= n - 1) {
	                    indexes[i] = 0;
	                } else {
	                    indexes[i]++;
	                    break;
	                }
	            }
	            total--;
	        }
  
	        
	        return tuple;
	    }

	    public static void handle(Integer[] snapshot) {
	        for(int i = 0; i < snapshot.length; i ++){
	            System.out.print(snapshot[i]);
	        }
	        System.out.println();
	    }
	    
	    

}

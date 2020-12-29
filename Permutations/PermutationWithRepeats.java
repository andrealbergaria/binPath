package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import binPathJava.printPartitions;




//I use this java realization of permutations with repetitions. A~(n,m): n = length of array, m = k. m can be greater or lesser then n.

public class PermutationWithRepeats {

	
	
/*
 * 
 * @param a, the elements to be permuted
 * @param k number of elements
 */
    public static List<Integer[]> permute(Integer[] a, int k) {
    	// numOfValuesInTuple=num;
    	ArrayList<Integer[]> tuples = new ArrayList<Integer[]>();
        int n = a.length;
        int idxTuples=0;
        int[] indexes = new int[k];
        int total = (int) Math.pow(n, k);

        Integer[] tuple = new Integer[k];
        while (total-- > 0) {
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
            
            Integer[] tupleBackup = new Integer[tuple.length];
            System.arraycopy(tuple, 0, tupleBackup, 0, tuple.length);
            
            //printPartitions.listTuple(tupleBackup);
            tuples.add(tupleBackup);
            //printPartitions.ListAllPermutations(tuples);
            //handle(tuple);
            
            for (int i = 0; i < k; i++) {
                if (indexes[i] >= n - 1) {
                    indexes[i] = 0;
                } else {
                    indexes[i]++;
                    break;
                }
            }
        }
    //  
        
        return tuples;
    }

    public static void handle(Integer[] snapshot) {
        for(int i = 0; i < snapshot.length; i ++){
            System.out.print(snapshot[i]);
        }
        System.out.println();
    }
    
    	
    
}

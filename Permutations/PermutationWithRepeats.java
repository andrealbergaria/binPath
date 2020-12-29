package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*For simplicity, consider the data in the range 0 to 9. 
Input data: 1, 4, 1, 2, 7, 5, 2
  1) Take a count array to store the count of each unique object.
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  2  0   1  1  0  1  0  0

  2) Modify the count array such that each element at each index 
  stores the sum of previous counts. 
  Index:     0  1  2  3  4  5  6  7  8  9
  Count:     0  2  4  4  5  6  6  7  7  7

The modified count array indicates the position of each object in 
the output sequence.
 
  3) Output each object from the input sequence followed by 
  decreasing its count by 1.
  Process the input data: 1, 4, 1, 2, 7, 5, 2. Position of 1 is 2.
  Put data 1 at index 2 in output. Decrease count by 1 to place 
  next data 1 at an index 1 smaller than this index.

*/



//I use this java realization of permutations with repetitions. A~(n,m): n = length of array, m = k. m can be greater or lesser then n.

public class PermutationWithRepeats {

	
	
/*
 * 
 * @param a, the elements to be permuted
 * @param k number of elements
 */
    public static List<Integer[]> permute(Integer[] a, int k,boolean print) {
    	// numOfValuesInTuple=num;
    	ArrayList<Integer[]> tuples = new ArrayList<Integer[]>();
        int n = a.length;
        
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
          //  if (print == true)
            //		handle(tuple);
            
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

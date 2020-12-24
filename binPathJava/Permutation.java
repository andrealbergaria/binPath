
package binPathJava;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



// taken from https://www.baeldung.com/java-array-permutations
public class Permutation {

private static Integer[] swap(Integer[] input, int a, int b) {
    int tmp = input[a];
    input[a] = input[b];
    input[b] = tmp;
    return input;
}

   public static Vector<Integer[]> permute(int n, Integer[] elements) {

	   	Vector<Integer[]> v = new Vector();
	 
	Integer[] ret = new Integer[elements.length];
   	int[] indexes = new int[n];
	
//	for (int i = 0; i < n; i++) {
//	    indexes[i] = 0;
//	}
	 
   	v.add(elements);
	
    int it=0;
	int i = 0;
	while (i < n) {
		
		it++;
	    if (indexes[i] < i) {
	    	
	    	ret = swap(elements, (i % 2 == 0) ?  0: indexes[i], i);
	    	v.add(ret);
	        indexes[i] = 0;
	        i++;
	    }
	}
	
	return v;
   }
	
   
}


package binPathJava;
import java.util.ArrayList;
import java.util.List;



// taken from https://www.baeldung.com/java-array-permutations
public class Permutation {

private static <T> void swap(T[] input, int a, int b) {
    T tmp = input[a];
    input[a] = input[b];
    input[b] = tmp;
}

private static  <T> void printArray(T[] input,char delimeter) {
    System.out.print('\n');
    System.out.print("[");
    for(int i = 0; i < input.length; i++) {
    	if (i == input.length-1)
        System.out.print(input[i]+" ");
    	else
    		System.out.print(input[i]+" "+delimeter);
    }
    System.out.println("]");
}


   public static <T> List<T[]> permute(int n, T[] elements, char delimiter) {
	List<T[]> li = new ArrayList<T[]>();
	
   	int[] indexes = new int[n];
	
	for (int i = 0; i < n; i++) {
	    indexes[i] = 0;
	}
	 
	//printArray(elements, delimiter);
    int it=0;
	int i = 0;
	while (i < n) {
		
		it++;
	    if (indexes[i] < i) {
	        swap(elements, i % 2 == 0 ?  0: indexes[i], i);
	        li.add(elements);
	        for (T[] obj : li)
	        	System.out.println("\n"+obj[0]+" , "+obj[1]);
	     //   printArray(elements, delimiter);
	        indexes[i]++;
	        i = 0;
	    }
	    else {
	        indexes[i] = 0;
	        i++;
	    }
	}
	
	return li;
   }
	
   
}

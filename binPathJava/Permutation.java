
package binPathJava;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.reflect.Array;


// taken from https://www.baeldung.com/java-array-permutations
public class Permutation {

private static <T> void swap(T[] input, int a, int b) {
    T tmp = input[a];
    input[a] = input[b];
    input[b] = tmp;
}

private static  <T> void printArray(T[] input,char delimeter) {
    System.out.print('\n');
    System.err.print("[");
    for(int i = 0; i < input.length; i++) {
        System.out.print(input[i]+" "+delimeter);
    }
    System.out.println("]");
}


   public static <T> void permute(int n, T[] elements, char delimiter) {
		 
   	int[] indexes = new int[n];
	
	for (int i = 0; i < n; i++) {
	    indexes[i] = 0;
	}
	 
	printArray(elements, delimiter);
	 
	int i = 0;
	while (i < n) {
	    if (indexes[i] < i) {
	        swap(elements, i % 2 == 0 ?  0: indexes[i], i);
	        printArray(elements, delimiter);
	        indexes[i]++;
	        i = 0;
	    }
	    else {
	        indexes[i] = 0;
	        i++;
	    }
	}
   }
	
   
}

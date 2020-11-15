

// taken from https://www.baeldung.com/java-array-permutations

public class Permutation {
	
	public static <T> void printAllRecursive(
			  int n, T[] elements, char delimiter) {
			 
			    if(n == 1) {
			        printArray(elements, delimiter);
			    } else {
			        for(int i = 0; i < n-1; i++) {
			            printAllRecursive(n - 1, elements, delimiter);
			            if(n % 2 == 0) {
			                swap(elements, i, n-1);
			            } else {
			                swap(elements, 0, n-1);
			            }
			        }
			        printAllRecursive(n - 1, elements, delimiter);
			    }
			}
	
	
	public static void permute(int[] elems) {
		
	char delimiter = ',';
	int n=8;
	
	int[] indexes = new int[n];
	
	for (int i = 0; i < n; i++) {
	    indexes[i] = 0;
	}
	 
	int i = 0;
	while (i < n) {
	    if (indexes[i] < i) {
	        swap(elems, i % 2 == 0 ?  0: indexes[i], i);
	        printArray(elems);
	        indexes[i]++;
	        i = 0;
	    }
	    else {
	        indexes[i] = 0;
	        i++;
	    }
	}
	}
	
	private static void swap(int[] input, int a, int b) {
	    int tmp = input[a];
	    input[a] = input[b];
	    input[b] = tmp;
	}

	private static void printArray(int[] input) {
	    System.out.print('\n');
	    for(int i = 0; i < input.length; i++) {
	        System.out.print(" , "+input[i]);
	    }
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

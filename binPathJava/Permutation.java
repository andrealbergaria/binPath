
package binPathJava;
import java.util.ArrayList;
import org.javatuples.*;
import java.util.List;
import java.util.Vector;



// taken from https://www.baeldung.com/java-array-permutations
public class Permutation {
/*
 * @þaram input it is the tuple that is going to swamp elements
 * @returns a tuple with swapped elements
 */
private static <E> E[] swap(E input, int a, int b) {
	// Swamp A with B, and B with A
    E temp = input[a];
    input[a] = input[b];
    input[b] = input[a];
    
    
    
    return input;
}	
/*
 * @returns a vector with all permutations of tuple
 * @param tuple to be permuted
 */



	public static <E> Vector<Tuple> getsThreeElements(E tuple) {
		
	}


   public static <E> Vector<Tuple> permute(E tuple) {
	   
	 
	
	}
	
	return v;
   }
	
   
}

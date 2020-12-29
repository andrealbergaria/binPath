package Permutations;

import java.util.List;

public class printPartsReturnTuple extends printPartitions {
	public static void main(String[] args) {
	if (args.length != 1) {
		System.err.println("\nNeeds number of summands or partiiton number");
		System.exit(-1);
	}
	
//	 int maxSummands = Integer.parseInt(args[0]);
	int maxSummands= 6;
		 Integer[] tuple;
    Integer[] possibleValuesForTuple =  {1,2,3}; 
     List<Integer[]> listObj;
     boolean print = true;
   for (int summand=1; summand <= maxSummands ;summand++) {
	   
	   		// Gets the values from 1...summand works
    	 	 
    	 	 
    	 	 print=false;
    	 	 //possibleValuesForTuple = getRange(summand);
    	 	 
    	 		 tuple = PermutationReturnsOneTuple.permute(possibleValuesForTuple, summand,print);


    	 	 checkPart(tuple, maxSummands);
    	 	 

     }
   
   
   }
}
